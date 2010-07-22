/**
 * Created on Jul 22, 2010, 2:15:56 AM
 */
package edu.cornell.dendro.corina.view.bulkImport;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import edu.cornell.dendro.corina.model.bulkImport.ObjectModel;
import edu.cornell.dendro.corina.model.bulkImport.ObjectTableModel;

/**
 * @author Daniel Murphy
 *
 */
public class ObjectView extends JPanel{
	
	private ObjectModel model;

	private JTable table;
	private JButton addRow;
	private JButton showHideColumns;
	private JButton removeSelected;
	private JButton selectAll;
	private JButton selectNone;
	private JButton importSelected;
	
	public ObjectView(ObjectModel argModel){
		
		initComponents();
		linkModel();
		addListeners();
		populateLocale();
	}

	private void initComponents(){
		table = new JTable();
		addRow = new JButton();
		showHideColumns = new JButton();
		removeSelected = new JButton();
		selectAll = new JButton();
		selectNone = new JButton();
		importSelected = new JButton();
		
		setLayout(new BorderLayout());
		
		Box box = Box.createHorizontalBox();
		box.add(addRow);
		box.add( Box.createHorizontalGlue());
		box.add(showHideColumns);
		add(box, "North");
		
		add(table, "Center");
		
		box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		box.add(selectAll);
		box.add(selectNone);
		box.add(removeSelected);
		box.add(Box.createRigidArea(new Dimension(30, 1)));
		box.add(importSelected);
	}
	
	private void linkModel() {
		table.setModel((TableModel) model.getProperty(ObjectModel.TABLE_MODEL));
	}
	
	private void addListeners() {
		// TODO Auto-generated method stub
		
	}

	private void populateLocale() {
		addRow.setText("Add Row");
		showHideColumns.setText("Show/Hide Columns");
		removeSelected.setText("Remove Selected");
		selectAll.setText("Select All");
		selectNone.setText("Select None");
		importSelected.setText("Import Selected");
	}
}