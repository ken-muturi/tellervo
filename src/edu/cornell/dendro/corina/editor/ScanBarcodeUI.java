package edu.cornell.dendro.corina.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import edu.cornell.dendro.corina.editor.EditorFactory.BarcodeDialogResult;
import edu.cornell.dendro.corina.ui.Builder;
/*
 * ScanBarcodeUI.java
 *
 * Created on August 10, 2009, 4:41 PM
 */
import edu.cornell.dendro.corina.ui.I18n;



/**
 *
 * @author  peterbrewer
 */
public class ScanBarcodeUI extends javax.swing.JPanel {
    
	final BarcodeDialogResult result;
	
    /** Creates new form ScanBarcodeUI */
    public ScanBarcodeUI(final JDialog parent) {
        initComponents();
        internationalizeComponents();
        jLabel2.setIcon(Builder.getIcon("barcode.png", 128));
        
        result = new BarcodeDialogResult(parent);

		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcodeText = txtBarcode.getText();
				
				if(result.loadFromBarcode(barcodeText))
					parent.dispose();
			}
		};

		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkAlwaysManual.isSelected()) {
					// Set in prefs
					System.out.println("Requested to never show barcode gui again");
				}
				result.success = true;
				parent.dispose();
			}
		};

		txtBarcode.addActionListener(al1);
		btnManual.addActionListener(al2);
    }

    public BarcodeDialogResult getResult()
    {
    	return result;
    }
    
    private void internationalizeComponents()
    {
    	btnManual.setText(I18n.getText("barcode.enterManually"));
        chkAlwaysManual.setText(I18n.getText("barcode.alwaysEnterManually"));
        jLabel1.setText(I18n.getText("barcode.instructions"));
    	
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBarcode = new javax.swing.JTextField();
        btnManual = new javax.swing.JButton();
        chkAlwaysManual = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        btnManual.setText("Enter manually later ");
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });

        chkAlwaysManual.setText("Always enter manually, do not show this dialog again.");

        jLabel1.setText("<html>Set the sample metadata for this series by <br>scanning the sample's barcode.  Alternatively <br> manually enter the metadata later.</html>");

        jLabel2.setIcon(new javax.swing.ImageIcon("Users/peterbrewer/dev/java/workspace2/Corina/src/edu/cornell/dendro/corina_resources/Icons/128x128/barcode.png")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, chkAlwaysManual, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtBarcode, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1)
                            .add(btnManual))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(18, 18, 18)
                        .add(txtBarcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnManual)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(18, 18, 18)
                .add(chkAlwaysManual)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManualActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnManual;
    protected javax.swing.JCheckBox chkAlwaysManual;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JTextField txtBarcode;
    // End of variables declaration//GEN-END:variables
    
}
