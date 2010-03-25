package edu.cornell.dendro.corina.view.editor;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import edu.cornell.dendro.corina.control.editor.EditorController;
import edu.cornell.dendro.corina.model.editor.EditorModel;
import edu.cornell.dendro.corina.mvc.control.CEvent;
import edu.cornell.dendro.corina.mvc.control.events.ObjectEvent;

@SuppressWarnings("serial")
public class RingAnnotations extends JPanel implements PropertyChangeListener{
	
	 // Variables declaration - do not modify                     
    protected javax.swing.JButton btnApply;
    protected javax.swing.JButton btnCancel;
    protected javax.swing.JButton btnCustom;
    protected javax.swing.JLabel lblCustomNote;
    protected javax.swing.JPanel panelCustomNote;
    protected javax.swing.JScrollPane scrCustomNote;
    protected javax.swing.JScrollPane scrRingAnnotations;
    protected javax.swing.JTable tblRingAnnotations;
    protected javax.swing.JTextArea txtCustomNote;
    
    private EditorModel model = EditorModel.getInstance();
    
    public static void main(String[] args){
    	/*JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation( 3);
    	RingAnnotations ra = new RingAnnotations();
    	frame.add(ra);
    	frame.setVisible(true);
    	ra.model.addRow( new Object[]{ "test", "User", true, 39});
    	ra.tblRingAnnotations.repaint();
    	ToolTipManager.sharedInstance().setDismissDelay( 10000);
    	ToolTipManager.sharedInstance().setInitialDelay( 1000);*/
    }
    
    /** Creates new form RingAnnotations */
    public RingAnnotations() {
        initComponents();
        initListeners();
        populateTable();
    }
    
    private void initListeners(){
    	// initialize our listeners, so we can fire off mvc events from user actions
    	btnApply.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e) {
				CEvent event = new CEvent(EditorController.ANNOTATIONS_APPLY_EVENT);
				event.dispatch();
			}
		});
    	btnCancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e) {
				CEvent event = new CEvent( EditorController.ANNOTATIONS_CANCEL_EVENT);
				event.dispatch();
			}
		});
    	btnCustom.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e) {
				CEvent event = new CEvent( EditorController.ANNOTATIONS_ADD_EDIT_CUSTOM_EVENT);
				event.dispatch();
			}
		});
    	// we have to use the document listener, as it fires the event after the document changes
    	txtCustomNote.getDocument().addDocumentListener( new DocumentListener() {
			@Override
			public void removeUpdate( DocumentEvent e) {
				ObjectEvent<String> event = new ObjectEvent<String>(
						EditorController.ANNOTATIONS_CUSTOM_TEXT_CHANGE_EVENT,
						txtCustomNote.getText());
				event.dispatch();
			}
			@Override
			public void insertUpdate( DocumentEvent e) {
				ObjectEvent<String> event = new ObjectEvent<String>(
						EditorController.ANNOTATIONS_CUSTOM_TEXT_CHANGE_EVENT,
						txtCustomNote.getText());
				event.dispatch();
			}
			@Override
			public void changedUpdate( DocumentEvent e) {
				ObjectEvent<String> event = new ObjectEvent<String>(
						EditorController.ANNOTATIONS_CUSTOM_TEXT_CHANGE_EVENT,
						txtCustomNote.getText());
				event.dispatch();
			}
		});
    	// listen to the model so we can change our 
    	model.addPropertyChangeListener(this);
    }
    
    @Override
    public void propertyChange( PropertyChangeEvent argEvent){
    	if(argEvent.getPropertyName().equals( EditorModel.ANNOTATIONS_TABLE_MODEL)){
			//tblRingAnnotations.getModel().removeTableModelListener(this);
			tblRingAnnotations.setModel( (TableModel) argEvent.getNewValue());
			//tblRingAnnotations.getModel().addTableModelListener(this);
			tblRingAnnotations.repaint();
    	}else if(argEvent.getPropertyName().equals( EditorModel.CUSTOM_NOTE)){
    		if(txtCustomNote.getText().equals( argEvent.getNewValue().toString())){
    			return;
    		}
    		txtCustomNote.setText( argEvent.getNewValue().toString());
    	}
    }
    
    public void populateTable(){
        tblRingAnnotations.setModel(model.getAnnotationsTableModel());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        scrRingAnnotations = new javax.swing.JScrollPane();
        tblRingAnnotations = new javax.swing.JTable();
        btnApply = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnCustom = new javax.swing.JButton();
        panelCustomNote = new javax.swing.JPanel();
        scrCustomNote = new javax.swing.JScrollPane();
        txtCustomNote = new javax.swing.JTextArea();
        lblCustomNote = new javax.swing.JLabel();

        tblRingAnnotations.setDefaultEditor( Integer.class, new JSliderEditor());

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ring Annotations"));
        scrRingAnnotations.setViewportView(tblRingAnnotations);
        		
        btnApply.setText("Apply");

        btnCancel.setText("Cancel");

        btnCustom.setText("Add or edit custom note");

        txtCustomNote.setColumns(20);
        txtCustomNote.setRows(5);
        scrCustomNote.setViewportView(txtCustomNote);

        lblCustomNote.setText("Custom note:");

        org.jdesktop.layout.GroupLayout panelCustomNoteLayout = new org.jdesktop.layout.GroupLayout(panelCustomNote);
        panelCustomNote.setLayout(panelCustomNoteLayout);
        panelCustomNoteLayout.setHorizontalGroup(
            panelCustomNoteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelCustomNoteLayout.createSequentialGroup()
                .add(lblCustomNote)
                .addContainerGap())
            .add(scrCustomNote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        panelCustomNoteLayout.setVerticalGroup(
            panelCustomNoteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelCustomNoteLayout.createSequentialGroup()
                .add(lblCustomNote)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrCustomNote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(panelCustomNote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(btnCustom)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 53, Short.MAX_VALUE)
                        .add(btnApply)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel)
                        .add(17, 17, 17))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(scrRingAnnotations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(scrRingAnnotations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 187, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelCustomNote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnApply)
                    .add(btnCancel)
                    .add(btnCustom))
                .addContainerGap())
        );
    }// </editor-fold>                        
}

/*class SliderRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

	public SliderRenderer() {

	}

	public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected,
													boolean hasFocus, int row, int column) {
		if ( value == null) { return this; }
		return this;
	}
}*/

@SuppressWarnings("serial")
class JSliderEditor extends JSlider implements TableCellEditor {
	
	protected transient ValueTooltip tooltip = new ValueTooltip();
	protected transient Vector<CellEditorListener> listeners;
	protected transient int originalValue;
	protected transient boolean editing;

	public JSliderEditor() {
		super( SwingConstants.HORIZONTAL);
		listeners = new Vector<CellEditorListener>();
		super.setToolTipText( "");
		sliderModel.addChangeListener( new ChangeListener() {
			
			@Override
			public void stateChanged( ChangeEvent e) {
				DefaultBoundedRangeModel source = (DefaultBoundedRangeModel) e.getSource();
				tooltip.setValue( source.getValue());
			}
		});
	}
	
	public class ValueTooltip extends JWindow {
	    private JLabel value = new JLabel();


	    private int w = 50;

	    private int h = 24;

	    public ValueTooltip() {
	      setSize(w, h);
	      JPanel p = new JPanel();
	      //p.setBorder(BorderFactory.createLineBorder(Color.gray));
	      //okB.setBorder(null);
	      //cancelB.setBorder(null);
	      p.add(value);
	      setContentPane(p);
	      this.setAlwaysOnTop( true);
	    }
	    
	    public void setValue(Integer argValue){
	    	value.setText( ""+ argValue);
	    }
	  }
	
	public String getToolTipText(MouseEvent e) {
        return getValue()+"";
    }

	public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected,
													int row, int column) {
		if ( value == null) { return this; }
		if ( value instanceof Integer) {
			setValue( ((Integer) value));
		}
		else {
			setValue( 0);
		}
		table.setRowSelectionInterval( row, row);
		table.setColumnSelectionInterval( column, column);
		originalValue = getValue();
		editing = true;
		Point p = table.getLocationOnScreen();
		Rectangle r = table.getCellRect( row, column, true);
		tooltip.setLocation( r.x + p.x + getWidth() - 50, r.y + p.y + getHeight());
		tooltip.setValue( getValue());
		tooltip.setVisible( true);
		return this;
	}

	// CellEditor methods
	public void cancelCellEditing() {
		fireEditingCanceled();
		editing = false;
	    tooltip.setVisible(false);
	}

	public Object getCellEditorValue() {
		return new Integer( getValue());
	}

	public boolean isCellEditable( EventObject eo) {
		return true;
	}

	public boolean shouldSelectCell( EventObject eo) {
		return true;
	}

	public boolean stopCellEditing() {
		fireEditingStopped();
		editing = false;
	    tooltip.setVisible(false);
		return true;
	}

	public void addCellEditorListener( CellEditorListener cel) {
		listeners.addElement( cel);
	}

	public void removeCellEditorListener( CellEditorListener cel) {
		listeners.removeElement( cel);
	}

	protected void fireEditingCanceled() {
		setValue( originalValue);
		ChangeEvent ce = new ChangeEvent( this);
		for ( int i = listeners.size() - 1; i >= 0; i--) {
			listeners.elementAt( i).editingCanceled( ce);
		}
	}

	protected void fireEditingStopped() {
		ChangeEvent ce = new ChangeEvent( this);
		for ( int i = listeners.size() - 1; i >= 0; i--) {
			listeners.elementAt( i).editingStopped( ce);
		}
	}
}
