/**
 * Created at Jan 19, 2011, 7:11:14 PM
 */
package org.tellervo.desktop.io.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tellervo.desktop.core.App;
import org.tellervo.desktop.io.Metadata;
import org.tellervo.desktop.io.control.ConvertEvent;
import org.tellervo.desktop.io.control.ExportEvent;
import org.tellervo.desktop.io.model.ConvertModel;
import org.tellervo.desktop.prefs.Prefs.PrefKey;
import org.tellervo.desktop.sample.Element;
import org.tellervo.desktop.sample.Sample;
import org.tellervo.desktop.tridasv2.LabCode;
import org.tellervo.desktop.ui.Alert;
import org.tellervo.desktop.util.openrecent.OpenRecent;
import org.tellervo.desktop.util.openrecent.SeriesDescriptor;
import org.tridas.interfaces.ITridasSeries;
import org.tridas.io.defaults.TridasMetadataFieldSet;
import org.tridas.io.naming.HierarchicalNamingConvention;
import org.tridas.io.naming.INamingConvention;
import org.tridas.io.naming.NumericalNamingConvention;
import org.tridas.io.util.DateUtils;
import org.tridas.io.util.TridasUtils;
import org.tridas.schema.DateTime;
import org.tridas.schema.TridasAddress;
import org.tridas.schema.TridasDerivedSeries;
import org.tridas.schema.TridasElement;
import org.tridas.schema.TridasGenericField;
import org.tridas.schema.TridasLaboratory;
import org.tridas.schema.TridasMeasurementSeries;
import org.tridas.schema.TridasObject;
import org.tridas.schema.TridasProject;
import org.tridas.schema.TridasRadius;
import org.tridas.schema.TridasSample;



import com.dmurph.mvc.MVCEvent;
import com.dmurph.mvc.control.ICommand;





/**
 * @author Daniel
 *
 */
public class ExportCommand implements ICommand {
	private static final Logger log = LoggerFactory.getLogger(ExportCommand.class);
	
	/**
	 * @see com.dmurph.mvc.control.ICommand#execute(com.dmurph.mvc.MVCEvent)
	 */
	@Override
	public void execute(MVCEvent argEvent) {
		ExportEvent event = (ExportEvent) argEvent;
		
		// Set the export format for future use
    	App.prefs.setPref(PrefKey.EXPORT_FORMAT, event.format);
    	    	
    	// Get defaults for creating project
    	TridasMetadataFieldSet defaults = new TridasMetadataFieldSet();
		
    	// Create sample list from elements
		List<Sample> samples = new ArrayList<Sample>();
		for(Element e : event.model.getElements()) {		
			// load it
			Sample s;
			try {
				s = e.load();
				
			} catch (IOException ioe) {
				Alert.error("Error Loading Sample", "Can't open this file: " + ioe.getMessage());
				continue;
			}
			
			samples.add(s);

			OpenRecent.sampleOpened(new SeriesDescriptor(s));
		}
		
		// no samples => don't bother doing anything
		if (samples.isEmpty()) {
			log.error("No samples to export");
			return;
		}
    	
		// Create a list of projects 
		ArrayList<TridasProject> projList = new ArrayList<TridasProject>();
		ArrayList<LabCode> labCodeList = new ArrayList<LabCode>();
		TridasProject project = defaults.getProjectWithDefaults();
		for (Sample s : samples){
			if(!event.grouped){
				// User wants separate files so create a new project for each sample
				project = defaults.getProjectWithDefaults();
			}
			
			// Set some basic project details
			project.setTitle("Tellervo export project");
			project.setCreatedTimestamp(DateUtils.getTodaysDateTime());
			project.setLastModifiedTimestamp(DateUtils.getTodaysDateTime());
			project.setComments("Autogenerated project produced by the export facility in Tellervo by "
								+App.currentUser.getFirstName()+" "+App.currentUser.getLastName());
			TridasLaboratory lab = new TridasLaboratory();
			TridasLaboratory.Name labName = new TridasLaboratory.Name();
			labName.setAcronym(App.getLabAcronym());
			labName.setValue(App.getLabName());
			lab.setName(labName);
			TridasAddress address = new TridasAddress();
			lab.setAddress(address);
			project.unsetLaboratories();
			project.getLaboratories().add(lab);
			
			TridasObject tobj = (TridasObject) s.getMeta(Metadata.OBJECT, TridasObject.class);
			TridasElement telem = s.getMeta(Metadata.ELEMENT, TridasElement.class);
			TridasSample tsamp = s.getMeta(Metadata.SAMPLE, TridasSample.class);
			TridasRadius trad = s.getMeta(Metadata.RADIUS, TridasRadius.class);
			ITridasSeries tseries = s.getSeries();
			
			// Set Generic 'Keycode' field as this is useful for some export formats
			TridasGenericField gf = new TridasGenericField();
			gf.setName("keycode");
			gf.setType("xs:string");
			String keycode;
			if(StringUtils.countMatches(s.getDisplayTitle(), "-")==5)
			{
				keycode = s.getDisplayTitle().substring(s.getDisplayTitle().indexOf("-")+1);	
			}
			else {
				keycode = s.getDisplayTitle();
			}
			keycode = keycode.replace("-", "");
			gf.setValue(keycode);
			tseries.getGenericFields().add(gf);
			
			if(tseries instanceof TridasMeasurementSeries)
			{
				// Set all the standard mSeries entities
				trad.getMeasurementSeries().clear();
				trad.getMeasurementSeries().add((TridasMeasurementSeries) tseries);
				tsamp.getRadiuses().clear();
				tsamp.getRadiuses().add(trad);				
				telem.getSamples().clear();
				telem.getSamples().add(tsamp);
				tobj.getElements().clear();
				tobj.getElements().add(telem);
				project.getObjects().add(tobj);
			}
			else
			{
				// Derived series so no other entities
				project.getDerivedSeries().add((TridasDerivedSeries) tseries);
			}
			
			if(!event.grouped){
				// Add project to list
				projList.add(project);
				LabCode code = s.getMeta(Metadata.LABCODE, LabCode.class);
				labCodeList.add(code);
			}		
		}
		
		if(event.grouped) {
			
			
			ArrayList<TridasObject> obj = TridasUtils.consolidateObjects(project.getObjects(), true);
			project.getObjects().clear();
			project.setObjects(obj);
			
			projList.add(project);
			
			if (samples.size() == 1){
				LabCode code = samples.get(0).getMeta(Metadata.LABCODE, LabCode.class);
				labCodeList.add(code);
			}
		}
		
		INamingConvention naming = event.naming;
		if(naming instanceof NumericalNamingConvention)
		{
			if(labCodeList.size() != projList.size()){
				log.warn("Lab code list isn't the same size as project list");
				Alert.message("Inconsistent", "There was a problem using the labcodes to name files.\n" +
						"Using hierarchical naming convention instead.");
				naming = new HierarchicalNamingConvention();
			}
		}
		
		ConvertModel cmodel = new ConvertModel(event.model.getNodes());
		cmodel.setTridasProjects(projList.toArray(new TridasProject[0]));
		cmodel.setLabCodes(labCodeList.toArray(new LabCode[0]));
		
		ConvertEvent cevent = new ConvertEvent(event.format, naming, cmodel, event.model.getExportView());
		cevent.dispatch();
	}
	
}
