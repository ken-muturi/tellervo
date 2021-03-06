package org.tellervo.desktop.tridasv2.ui;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tellervo.desktop.gui.dbbrowse.MetadataBrowser;
import org.tellervo.desktop.tridasv2.ui.support.TridasEntityProperty;
import org.tellervo.desktop.ui.Alert;
import org.tridas.schema.TridasElement;
import org.tridas.schema.TridasEntity;
import org.tridas.schema.TridasFile;
import org.tridas.schema.TridasGenericField;
import org.tridas.schema.TridasObject;
import org.tridas.schema.TridasSample;

import com.l2fprod.common.propertysheet.Property;
import com.l2fprod.common.propertysheet.PropertySheetPanel;


/**
 * This class exists to kludge over a bug in PropertySheetPanel, whereby 
 * the array of TridasFiles is not written to the entity when writeToObject
 * is called.  
 * 
 * I presume this bug is also an issue for any other arrays, so be warned!
 * 
 * @author pwb48
 *
 */
public class TellervoPropertySheetPanel extends PropertySheetPanel {

	private final static Logger log = LoggerFactory.getLogger(TellervoPropertySheetPanel.class);

	private static final long serialVersionUID = 1L;
	
	public TellervoPropertySheetPanel(TellervoPropertySheetTable propertiesTable) {
		super(propertiesTable);
	}

	@Override
	public void readFromObject(Object object)
	{
		super.readFromObject(object);
		
		Property[] prop = this.getProperties();
		
		if(object instanceof TridasObject)
		{
			TridasObject obj = (TridasObject) object;
			TellervoGenericFieldProperty refField = TellervoGenericFieldProperty.getObjectCodeProperty();
			TellervoGenericFieldProperty refField2 = TellervoGenericFieldProperty.getVegetationTypeProperty();
			
			if (obj.isSetGenericFields())
			{
				for(TridasGenericField gf : obj.getGenericFields())
				{
					if(gf.getName().equals(refField.getXMLFieldName()))
					{
						for(Property p : prop)
						{
							TridasEntityProperty tep = (TridasEntityProperty) p;
							if(tep.qname.equals(refField.qname))
							{
								p.setValue(gf.getValue());
							}
						}
					}
					else if(gf.getName().equals(refField2.getXMLFieldName()))
					{
						for(Property p : prop)
						{
							TridasEntityProperty tep = (TridasEntityProperty) p;
							if(tep.qname.equals(refField2.qname))
							{
								p.setValue(gf.getValue());
							}
						}
					}
				}
			}
		}
		
		
		if(object instanceof TridasSample)
		{
			TridasSample sample = (TridasSample) object;
			TellervoGenericFieldProperty externalID = TellervoGenericFieldProperty.getSampleExternalIDProperty();
			TellervoGenericFieldProperty curationStatus = TellervoGenericFieldProperty.getSampleCurationStatusProperty();
			TellervoGenericFieldProperty sampleStatus = TellervoGenericFieldProperty.getSampleStatusProperty();

			
			if (sample.isSetGenericFields())
			{
				for(TridasGenericField gf : sample.getGenericFields())
				{
					if(gf.getName().equals(externalID.getXMLFieldName()))
					{
						for(Property p : prop)
						{
							TridasEntityProperty tep = (TridasEntityProperty) p;
							//log.debug("Property name : "+tep.qname);
							if(tep.qname.equals(externalID.qname))
							{
								p.setValue(gf.getValue());
							}
						}
					}
					else if(gf.getName().equals(curationStatus.getXMLFieldName()))
					{
						for(Property p : prop)
						{
							TridasEntityProperty tep = (TridasEntityProperty) p;
							//log.debug("Property name : "+tep.qname);
							if(tep.qname.equals(curationStatus.qname))
							{
								p.setValue(gf.getValue());
							}
						}
					}
					else if(gf.getName().equals(sampleStatus.getXMLFieldName()))
					{
						for(Property p : prop)
						{
							TridasEntityProperty tep = (TridasEntityProperty) p;
							//log.debug("Property name : "+tep.qname);
							if(tep.qname.equals(sampleStatus.qname))
							{
								p.setValue(gf.getValue());
							}
						}
					}
				}
			}
		}
		
		
		
		
	}
	
	@Override
	public void writeToObject(Object data) {
		// ensure pending edits are committed
		getTable().commitEditing();
		Property[] properties = getProperties();
		for (int i = 0, c = properties.length; i < c; i++) {
			properties[i].writeToObject(data);
				
		}

		Property[] prop2 = this.getProperties();
		
		for(Property p : prop2)
		{

			// Find any properties called 'files'
			if(p.getName().equals("files"))
			{
				Object files = p.getValue();
				
				if(data instanceof TridasObject)
				{
					((TridasObject)data).setFiles((List<TridasFile>) files);
				}
				else if(data instanceof TridasElement)
				{
					((TridasElement)data).setFiles((List<TridasFile>) files);
				}
				else if(data instanceof TridasSample)
				{
					((TridasSample)data).setFiles((List<TridasFile>) files);
				}
			}
			
			
			if(p instanceof TellervoGenericFieldProperty)
			{
				TellervoGenericFieldProperty tgfp = (TellervoGenericFieldProperty) p;
				
				TellervoGenericFieldProperty.addOrReplaceGenericField((TridasEntity)data, tgfp.getTridasGenericField());

			}
				
			
			/*if(tep.qname.equals("sample.externalId"))
			{
				if(data instanceof TridasSample)
				{
					TridasGenericField gf = new TridasGenericField();
					gf.setName("tellervo.externalID");
					gf.setType("xs:string");
					gf.setValue((String) p.getValue());
					
					((TridasSample)data).getGenericFields().add(gf);
				}
			}*/
		}
		

	}
	
	
}
