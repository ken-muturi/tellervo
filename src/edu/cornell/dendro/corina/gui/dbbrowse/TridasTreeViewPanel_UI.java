package edu.cornell.dendro.corina.gui.dbbrowse;

/**
 *
 * @author  peterbrewer
 */
public class TridasTreeViewPanel_UI extends javax.swing.JPanel {

	private static final long serialVersionUID = 6724237826572311289L;

	
	/** Creates new form TridasTreeViewPanel_UI */
    public TridasTreeViewPanel_UI() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeScrollPane = new javax.swing.JScrollPane();
        btnCollapse = new javax.swing.JButton();

        btnCollapse.setText("Collapse All");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(treeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .add(btnCollapse))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(treeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCollapse)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCollapse;
    protected javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables
    
}
