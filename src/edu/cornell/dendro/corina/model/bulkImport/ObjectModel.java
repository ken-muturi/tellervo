/**
 * Created on Jul 16, 2010, 6:44:22 PM
 */
package edu.cornell.dendro.corina.model.bulkImport;

import java.util.ArrayList;
import java.util.Iterator;

import org.tridas.schema.TridasObject;
import org.tridas.util.TridasObjectEx;

import com.dmurph.mvc.model.HashModel;
import com.dmurph.mvc.model.MVCArrayList;

import edu.cornell.dendro.corina.control.bulkImport.BulkImportController;
import edu.cornell.dendro.corina.gis.GPXParser.GPXWaypoint;

/**
 * @author Daniel Murphy
 *
 */
@SuppressWarnings("unchecked")
public class ObjectModel extends HashModel implements IBulkImportSectionModel{
	private static final long serialVersionUID = 1L;
	
	public ObjectModel(){
		registerProperty(ROWS, PropertyType.FINAL, new MVCArrayList<SingleObjectModel>());
		registerProperty(COLUMN_MODEL, PropertyType.FINAL, new ColumnChooserModel());
		registerProperty(TABLE_MODEL, PropertyType.FINAL, new ObjectTableModel(this));
		registerProperty(IMPORTED_LIST, PropertyType.FINAL, new MVCArrayList<TridasObjectEx>());
		registerProperty(WAYPOINT_LIST, PropertyType.FINAL, new MVCArrayList<GPXWaypoint>());

	}
	
	public MVCArrayList<SingleObjectModel> getRows(){
		return (MVCArrayList<SingleObjectModel>) getProperty(ROWS);
	}
	
	public ColumnChooserModel getColumnModel(){
		return (ColumnChooserModel) getProperty(COLUMN_MODEL);
	}
	
	public ObjectTableModel getTableModel(){
		return (ObjectTableModel) getProperty(TABLE_MODEL);
	}
	
	public MVCArrayList<TridasObjectEx> getImportedList(){
		return (MVCArrayList<TridasObjectEx>) getProperty(IMPORTED_LIST);
	}
	
	public MVCArrayList<GPXWaypoint> getWaypointList(){
		return (MVCArrayList<GPXWaypoint>) getProperty(WAYPOINT_LIST);
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getImportedListStrings()
	 */
	@Override
	public String[] getImportedListStrings() {
		MVCArrayList<TridasObjectEx> imported = getImportedList();
		String[] s = new String[imported.size()];
		for(int i=0; i<s.length; i++){
			s[i] = imported.get(i).getLabCode();
		}
		return s;
	}
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getImportedDynamicComboBoxKey()
	 */
	@Override
	public String getImportedDynamicComboBoxKey() {
		return BulkImportController.SET_DYNAMIC_COMBO_BOX_OBJECTS;
	}
	
	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#removeSelected()
	 */
	@Override
	public void removeSelected() {
		ArrayList<SingleObjectModel> removed = new ArrayList<SingleObjectModel>();
		getTableModel().removeSelected(removed);
		
		Iterator<SingleObjectModel> it = removed.iterator();
		
		while(it.hasNext()){
			if(it.next().getImported() == null){
				it.remove();
			}
		}
		if(removed.size() == 0){
			return;
		}
		MVCArrayList<TridasObjectEx> imported = getImportedList();
		for(int i=0; i< imported.size(); i++){
			TridasObjectEx o = imported.get(i);
			for(SingleObjectModel som : removed){
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
		return new SingleObjectModel();
	}

	/**
	 * @see edu.cornell.dendro.corina.model.bulkImport.IBulkImportSectionModel#getModelTableProperties()
	 */
	@Override
	public String[] getModelTableProperties() {
		return SingleObjectModel.TABLE_PROPERTIES;
	}

	@Override
	public ISingleRowModel createClonedRowInstance(ISingleRowModel source) {
		SingleObjectModel som = (SingleObjectModel) createRowInstance();
		TridasObject obj = new TridasObject();
		((SingleObjectModel)source).populateTridasObject(obj);
		
		som.populateFromTridasObject(obj);
		return som;
	}


}
