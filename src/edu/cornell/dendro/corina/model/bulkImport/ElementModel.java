/**
 * Created on Aug 18, 2010, 1:11:20 PM
 */
package edu.cornell.dendro.corina.model.bulkImport;

import java.util.ArrayList;
import java.util.Iterator;

import org.tridas.schema.TridasElement;
import org.tridas.schema.TridasObject;

import com.dmurph.mvc.model.HashModel;
import com.dmurph.mvc.model.MVCArrayList;

import edu.cornell.dendro.corina.control.bulkImport.BulkImportController;
import edu.cornell.dendro.corina.gis.GPXParser.GPXWaypoint;

/**
 * @author Daniel Murphy
 *
 */
@SuppressWarnings("unchecked")
public class ElementModel extends HashModel implements IBulkImportSectionModel{
	private static final long serialVersionUID = 1L;
	
	public ElementModel(){
		registerProperty(ROWS, PropertyType.FINAL, new MVCArrayList<SingleElementModel>());
		registerProperty(COLUMN_MODEL, PropertyType.FINAL, new ColumnChooserModel());
		registerProperty(TABLE_MODEL, PropertyType.FINAL, new ElementTableModel(this));
		registerProperty(IMPORTED_LIST, PropertyType.FINAL, new MVCArrayList<TridasElement>());
		registerProperty(WAYPOINT_LIST, PropertyType.FINAL, new MVCArrayList<GPXWaypoint>());
	}
	
	public MVCArrayList<SingleElementModel> getRows(){
		return (MVCArrayList<SingleElementModel>) getProperty(ROWS);
	}
	
	public ColumnChooserModel getColumnModel(){
		return (ColumnChooserModel) getProperty(COLUMN_MODEL);
	}
	
	public ElementTableModel getTableModel(){
		return (ElementTableModel) getProperty(TABLE_MODEL);
	}
	
	public MVCArrayList<TridasElement> getImportedList(){
		return (MVCArrayList<TridasElement>) getProperty(IMPORTED_LIST);
	}
	
	public MVCArrayList<GPXWaypoint> getWaypointList(){
		return (MVCArrayList<GPXWaypoint>) getProperty(WAYPOINT_LIST);
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getImportedListStrings()
	 */
	@Override
	public String[] getImportedListStrings() {
		MVCArrayList<TridasElement> imported = getImportedList();
		String[] s = new String[imported.size()];
		for(int i=0; i<s.length; i++){
			s[i] = imported.get(i).getTitle();
		}
		return s;
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getImportedDynamicComboBoxKey()
	 */
	@Override
	public String getImportedDynamicComboBoxKey() {
		return BulkImportController.SET_DYNAMIC_COMBO_BOX_ELEMENTS;
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#removeSelected()
	 */
	@Override
	public void removeSelected() {
		ArrayList<SingleElementModel> removed = new ArrayList<SingleElementModel>();
		getTableModel().removeSelected(removed);
		
		Iterator<SingleElementModel> it = removed.iterator();
		
		while(it.hasNext()){
			if(it.next().getImported() == null){
				it.remove();
			}
		}
		if(removed.size() == 0){
			return;
		}
		MVCArrayList<TridasElement> imported = getImportedList();
		for(int i=0; i< imported.size(); i++){
			TridasElement o = imported.get(i);
			for(SingleElementModel som : removed){
				if(o.getIdentifier().equals(som.getImported())){
					imported.remove(i);
					i--;
				}
			}
		}
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#createRowInstance()
	 */
	@Override
	public ISingleRowModel createRowInstance() {
		return new SingleElementModel();
	}

	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getModelTableProperties()
	 */
	@Override
	public String[] getModelTableProperties() {
		return SingleElementModel.TABLE_PROPERTIES;
	}
	
	@Override
	public ISingleRowModel createClonedRowInstance(ISingleRowModel source) {
		SingleElementModel som = (SingleElementModel) createRowInstance();
		TridasElement elm = new TridasElement();
		((SingleElementModel)source).populateToTridasElement(elm);
		
		som.populateFromTridasElement(elm);
		return som;
	}
}