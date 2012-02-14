/*******************************************************************************
 * Copyright (C) 2011 Peter Brewer.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Peter Brewer
 ******************************************************************************/
package org.tellervo.desktop.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import org.tellervo.desktop.editor.EditorFactory.BarcodeDialogResult;
import org.tellervo.desktop.prefs.wrappers.CheckBoxWrapper;
import org.tellervo.desktop.ui.Builder;
import org.tellervo.desktop.ui.I18n;

import net.miginfocom.swing.MigLayout;


/**
 *
 * @author  peterbrewer
 */
public class ScanBarcodeUI extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 1L;
	final BarcodeDialogResult result;
	
    /** Creates new form ScanBarcodeUI */
    public ScanBarcodeUI(final JDialog parent) {
    	

    	
        initComponents();
        internationalizeComponents();
        jLabel2.setIcon(Builder.getIcon("barcode.png", 128));
        setLayout(new MigLayout("", "[128px][12px][286px,grow,fill]", "[75px][19px][25px][23px]"));
        add(chkAlwaysManual, "cell 0 3 3 1,growx,aligny top");
        add(jLabel2, "cell 0 0 1 3,alignx left,aligny top");
        add(txtBarcode, "cell 2 1,growx,aligny top");
        add(jLabel1, "cell 2 0,growx,aligny top");
        add(btnManual, "cell 2 2,alignx center,aligny top");
        
        new CheckBoxWrapper(chkAlwaysManual, "tellervo.barcodes.disable", false );
        
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

        jLabel2.setIcon(new javax.swing.ImageIcon("Icons/128x128/barcode.png"));
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
