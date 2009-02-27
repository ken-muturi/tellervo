/*
 * Site.java
 *
 * Created on June 2, 2008, 3:38 PM
 */

package edu.cornell.dendro.corina.gui.datawizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.cornell.dendro.corina.dictionary.Taxon;
import edu.cornell.dendro.corina.site.TridasRadius;
import edu.cornell.dendro.corina.site.TridasSample;
import edu.cornell.dendro.corina.site.TridasElement;
import edu.cornell.dendro.corina.util.Center;
import edu.cornell.dendro.corina.webdbi.IntermediateResource;

/**
 *
 * @author  peterbrewer
 */
public class RadiusEditorPanel extends BaseEditorPanel<TridasRadius> {
    
    /** Creates new form Site */
    public RadiusEditorPanel() {
        initComponents();
                
        initialize();
        validateForm();
    }
        
    private void initialize() {
    	txtRadiusName.setText("Radius code");
    	setCapsNoWhitespace(txtRadiusName);
    	setFieldValidateButtons(txtRadiusName);
    	setSelectAllOnFocus(txtRadiusName);
    	
    	//getRootPane().setDefaultButton(btnApply);
    	btnApply.setEnabled(false);
    	btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commit();
			}		
    	});

    	btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}		
    	});
    }
    
    public void populate(String parentPrefix) {
        lblNamePrefix.setText(parentPrefix);
    }
    
	public void setDefaultsFrom(TridasRadius r) {
		String v;
		
		// populate name
		v = r.toString();
		if(!v.equals(TridasRadius.NAME_INVALID))
			txtRadiusName.setText(v);
	}
    
    public void commit() {
    	TridasRadius radius = new TridasRadius(TridasRadius.ID_NEW, txtRadiusName.getText());
    	assimilateUpdateObject(radius);
    	IntermediateResource ir = new IntermediateResource(getParentObject(), radius);
    	
       	if(!createOrUpdateObject(ir))
    		return;
    	
		if(ir.getObject().get(0) instanceof TridasRadius) {
			setNewObject((TridasRadius) ir.getObject().get(0));
		}
		
    	dispose();
    }
    
    protected void validateForm() {
    	boolean nameOk;

    	// tree name name
		int len = txtRadiusName.getText().length();

		if(len > 0 && !txtRadiusName.getText().equals("Radius code"))
			nameOk = true;
		else
			nameOk = false;
		
		colorField(txtRadiusName, nameOk);
	
		setFormValidated(nameOk);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRadiusName = new javax.swing.JTextField();
        lblRadiusName = new javax.swing.JLabel();
        lblNamePrefix = new javax.swing.JLabel();
        panelButtons = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();
        seperatorButtons = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Radius details");

        txtRadiusName.setText("Name of this site");
        txtRadiusName.setToolTipText("Name of this site");

        lblRadiusName.setText("Radius:");

        lblNamePrefix.setText("C-ABC-1-1-");

        btnCancel.setText("Cancel");

        btnApply.setText("Apply");

        seperatorButtons.setBackground(new java.awt.Color(153, 153, 153));
        seperatorButtons.setOpaque(true);

        /*
        org.jdesktop.layout.GroupLayout panelButtonsLayout = new org.jdesktop.layout.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .add(btnApply)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCancel)
                .add(5, 5, 5))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, seperatorButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelButtonsLayout.createSequentialGroup()
                .add(seperatorButtons, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnCancel)
                    .add(btnApply))
                .addContainerGap(33, Short.MAX_VALUE))
        );*/

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblRadiusName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(48, 48, 48)
                .add(layout.createSequentialGroup()
                    .add(lblNamePrefix)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(txtRadiusName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            //.add(org.jdesktop.layout.GroupLayout.TRAILING, panelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblRadiusName)
                    .add(lblNamePrefix)
                    .add(txtRadiusName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                )//.add(panelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblNamePrefix;
    private javax.swing.JLabel lblRadiusName;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JSeparator seperatorButtons;
    private javax.swing.JTextField txtRadiusName;
    // End of variables declaration//GEN-END:variables
    
}
