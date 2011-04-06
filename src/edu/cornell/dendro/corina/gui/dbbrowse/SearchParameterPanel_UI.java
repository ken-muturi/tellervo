/*
 * SearchParameterPanel.java
 *
 * Created on July 24, 2009, 1:25 PM
 */

package edu.cornell.dendro.corina.gui.dbbrowse;

/**
 *
 * @author  peterbrewer
 */
@SuppressWarnings("serial")
public class SearchParameterPanel_UI extends javax.swing.JPanel {
    
    /** Creates new form SearchParameterPanel */
    public SearchParameterPanel_UI() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkUseSearch = new javax.swing.JCheckBox();
        cboSearchField = new javax.swing.JComboBox();
        cboSearchOperator = new javax.swing.JComboBox();
        txtSearchText = new javax.swing.JTextField();

        chkUseSearch.setSelected(true);
        chkUseSearch.setText("and");

        cboSearchField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[--select--]", "sitename", "sitecode", "sitecreated", "sitelastmodified", "sitexcentroid", "siteycentroid", "subsitename", "subsitecreated", "subsitelastmodified", "treename", "treecreated", "treelastmodified", "precision", "latitude", "longitude", "specimenname", "datecollected", "specimencreated", "specimenlastmodified", "specimentype", "isterminalringverified", "isspecimenqualityverified", "ispithverified", "unmeaspre", "unmeaspost", "isunmeaspreverified", "isunmeaspostverified", "terminalring", "specimenquality", "specimencontinuity", "pith", "isspecimencontinuityverified", "radiusname", "radiuscreated", "radiuslastmodified", "measurementname", "measurementcreated", "measurementlastmodified", "measurementoperator", "measurementdescription", "measurementispublished", "measurementowneruserid", "operatorparameter", "measurementisreconciled", "datingtype", "datingerrorpositive", "datingerrornegative", "startyear", "readingcount", "measurementcount", "measurementymin", "measurementxmin", "measurementxmax", "measurementymax", "measurementxcentroid", "measurementycentroid" }));
        cboSearchField.setMaximumSize(new java.awt.Dimension(250, 32767));
        cboSearchField.setMinimumSize(new java.awt.Dimension(250, 27));
        cboSearchField.setPreferredSize(new java.awt.Dimension(50, 27));

        cboSearchOperator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<", "!=", "ilike" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(chkUseSearch)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cboSearchField, 0, 177, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cboSearchOperator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtSearchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chkUseSearch)
                    .add(cboSearchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtSearchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboSearchOperator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox cboSearchField;
    protected javax.swing.JComboBox cboSearchOperator;
    protected javax.swing.JCheckBox chkUseSearch;
    protected javax.swing.JTextField txtSearchText;
    // End of variables declaration//GEN-END:variables
    
}
