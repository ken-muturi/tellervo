/*
 * Tree.java
 *
 * Created on June 2, 2008, 3:38 PM
 */

package edu.cornell.dendro.corina.gui.newui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.cornell.dendro.corina.core.App;
import edu.cornell.dendro.corina.dictionary.Taxon;
import edu.cornell.dendro.corina.site.Subsite;
import edu.cornell.dendro.corina.site.Tree;
import edu.cornell.dendro.corina.util.Center;
import edu.cornell.dendro.corina.webdbi.IntermediateResource;

/**
 *
 * @author  peterbrewer
 */
public class TreeEditorPanel extends BaseEditorPanel<Tree> {
    
    /** Creates new form NewSite */
    public TreeEditorPanel() {
        initComponents();
                
        initialize();
        validateForm();
    }
       
    //@SuppressWarnings("unchecked")
	private void initialize() {

		// select the whole box
		setSelectAllOnFocus(txtTreeName);
		setFieldValidateButtons(txtTreeName);
		setCapsNoWhitespace(txtTreeName);
		
    	// force focus
    	txtTreeName.requestFocusInWindow();
    	
    	// set up the original stuff to be blank
    	txtLatitude.setText("");
    	txtLongitude.setText("");
    	txtPrecision.setText("");
    	txtOriginalTaxon.setText("");
    	
    	// force number entry
    	setNumbersOnly(txtLatitude, true);
    	setNumbersOnly(txtLongitude, true);
    	setNumbersOnly(txtPrecision, false);

    	// set up the taxon stuff
    	List<Taxon> taxonList = new ArrayList<Taxon>(
    			(List<Taxon>) App.dictionary.getDictionary("taxon"));
    	
    	// sort the list alphabetically
    	Collections.sort(taxonList);
    	    	
    	// make an array of stuff
    	Object[] taxonArray = new Object[taxonList.size() + 1];
    	taxonArray[0] = "-- Choose a taxon --";
    	System.arraycopy(taxonList.toArray(), 0, taxonArray, 1, taxonList.size());
    	
    	// finally, put it in the combobox
    	cboTaxon.setModel(new DefaultComboBoxModel(taxonArray));
    	
    	// update selection on combo goodness
    	cboTaxon.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent ie) {
        		if(ie.getStateChange() != ItemEvent.SELECTED)
        			return;
        		
        		validateForm();
        	}
    	});
    	
    	// apply button
    	//getRootPane().setDefaultButton(btnApply);
    	btnApply.setEnabled(false);
       	btnApply.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			commit();
    		}
    	});
       	
    	// cancel button
       	btnCancel.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			dispose();
    		}
    	});
       	
       	btnGPSImport.setVisible(false);

    }
	
	public void populate(String parentPrefix) {
    	lblNamePrefix.setText(parentPrefix);
	}
	
	public void setDefaultsFrom(Tree tree) {
		String v;
		
		// populate name
		v = tree.toString();
		if(!v.equals(Tree.NAME_INVALID))
			txtTreeName.setText(v);
		
		// populate original taxon
		// and guess for real taxon, why not
		if((v = tree.getOriginalTaxonName()) != null) {
			txtOriginalTaxon.setText(v);
		
			Taxon dummy = new Taxon(null, v);
			TreeSet<Taxon> ts = new TreeSet<Taxon>((List<Taxon>) App.dictionary.getDictionary("taxon"));
			Taxon closest = ts.tailSet(dummy).first();
			
			// well, if the closest match begins with the same first two letters, why not?
			if(closest.toString().substring(0, 2).equalsIgnoreCase(dummy.toString().substring(0, 2)))
				cboTaxon.setSelectedItem(closest);
		}
	}
		
	public void commit() {
		Tree tree = new Tree(Tree.ID_NEW, txtTreeName.getText());
		assimilateUpdateObject(tree);
    	IntermediateResource ir = new IntermediateResource(getParentObject(), tree);

    	// populate the tree... 
    	if(txtLatitude.getText().length() != 0)
    		tree.setLatitude(txtLatitude.getText());
    	if(txtLongitude.getText().length() != 0)
    		tree.setLongitude(txtLongitude.getText());
    	if(txtPrecision.getText().length() != 0)
    		tree.setPrecision(txtPrecision.getText());
    	if(txtOriginalTaxon.getText().length() != 0)
    		tree.setOriginalTaxonName(txtOriginalTaxon.getText());
    	if(cboTaxon.getSelectedItem() instanceof Taxon)
    		tree.setValidatedTaxon((Taxon) cboTaxon.getSelectedItem());
    	
    	// live tree is a little harder
    	String liveTree = (String) cboIsALiveTree.getSelectedItem();
    	if(liveTree.equalsIgnoreCase("Yes"))
    		tree.setIsLiveTree(true);
    	else if(liveTree.equalsIgnoreCase("No"))
    		tree.setIsLiveTree(false);
    	
    	if(!createOrUpdateObject(ir))
    		return;
    	
		if(ir.getObject().get(0) instanceof Tree) {
			setNewObject((Tree) ir.getObject().get(0));
		}
		
    	dispose();
    }
	
	protected void validateForm() {
    	boolean nameOk;
    	boolean taxonOk;

    	// tree name name
		int len = txtTreeName.getText().length();

		if(len > 0 && !txtTreeName.getText().equals("Tree code"))
			nameOk = true;
		else
			nameOk = false;
		
		if(cboTaxon.getSelectedItem() instanceof Taxon)
			taxonOk = true;
		else
			taxonOk = false;

		colorField(txtTreeName, nameOk);
		colorField(cboTaxon, taxonOk);
		
		setFormValidated(nameOk && taxonOk);
    }
	
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTreeName = new javax.swing.JTextField();
        lblTreeName = new javax.swing.JLabel();
        cboTaxon = new javax.swing.JComboBox();
        lblTaxon = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        panelLocation = new javax.swing.JPanel();
        lblLatitude = new javax.swing.JLabel();
        lblLongitude = new javax.swing.JLabel();
        lblPrecision = new javax.swing.JLabel();
        txtPrecision = new javax.swing.JTextField();
        lblSpinUnits = new javax.swing.JLabel();
        txtLongitude = new javax.swing.JTextField();
        txtLatitude = new javax.swing.JTextField();
        btnGPSImport = new javax.swing.JButton();
        txtOriginalTaxon = new javax.swing.JTextField();
        lblOrigTaxon = new javax.swing.JLabel();
        lblNamePrefix = new javax.swing.JLabel();
        lblIsALiveTree = new javax.swing.JLabel();
        cboIsALiveTree = new javax.swing.JComboBox();
        panelButtons = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();
        seperatorButtons = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Tree");

        txtTreeName.setText("Tree code");
        txtTreeName.setToolTipText("Laboratory code for tree");

        lblTreeName.setLabelFor(txtTreeName);
        lblTreeName.setText("Tree:");

        cboTaxon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pinus nigra", "Quercus robur" }));
        cboTaxon.setToolTipText("The most detailed taxonomic name for this tree.  This should be a species where possible.");

        lblTaxon.setText("Taxon:");

        lblLocation.setLabelFor(panelLocation);
        lblLocation.setText("Location:");

        panelLocation.setAlignmentX(0.0F);
        panelLocation.setAlignmentY(0.0F);

        lblLatitude.setLabelFor(txtLatitude);
        lblLatitude.setText("Latitude:");

        lblLongitude.setLabelFor(txtLongitude);
        lblLongitude.setText("Longitude:");

        lblPrecision.setLabelFor(txtPrecision);
        lblPrecision.setText("Precision:");

        txtPrecision.setToolTipText("Precision of locality information in meters");

        lblSpinUnits.setText("m");

        txtLongitude.setText("50.23");
        txtLongitude.setToolTipText("Longitude in decimal degrees");

        txtLatitude.setText("34.5");
        txtLatitude.setToolTipText("Latitude in decimal degrees");

        btnGPSImport.setText("GPS Import");
        btnGPSImport.setToolTipText("Import coordinates from GPX (GPS XML) file");

        org.jdesktop.layout.GroupLayout panelLocationLayout = new org.jdesktop.layout.GroupLayout(panelLocation);
        panelLocation.setLayout(panelLocationLayout);
        panelLocationLayout.setHorizontalGroup(
            panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLocationLayout.createSequentialGroup()
                .add(panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(lblLatitude, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(txtLatitude, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtLongitude, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblLongitude))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panelLocationLayout.createSequentialGroup()
                        .add(txtPrecision, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblSpinUnits))
                    .add(lblPrecision, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnGPSImport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        panelLocationLayout.setVerticalGroup(
            panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLocationLayout.createSequentialGroup()
                .add(panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLatitude)
                    .add(lblLongitude)
                    .add(lblPrecision))
                .add(4, 4, 4)
                .add(panelLocationLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtLatitude, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtLongitude, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtPrecision, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblSpinUnits)
                    .add(btnGPSImport))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtOriginalTaxon.setText("Pinus nigra");
        txtOriginalTaxon.setToolTipText("The original identification of this tree");

        lblOrigTaxon.setLabelFor(txtOriginalTaxon);
        lblOrigTaxon.setText("Originally identified as:");

        lblNamePrefix.setText("C-ABC-");
        lblNamePrefix.setToolTipText("Laboratory code prefix for tree");

        lblIsALiveTree.setLabelFor(cboIsALiveTree);
        lblIsALiveTree.setText("Is a live tree:");

        cboIsALiveTree.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unspecified", "Yes", "No" }));

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
                .addContainerGap(450, Short.MAX_VALUE)
                .add(btnApply)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCancel)
                .add(5, 5, 5))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, seperatorButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelButtonsLayout.createSequentialGroup()
                .add(seperatorButtons, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnCancel)
                    .add(btnApply))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        */

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(lblIsALiveTree))
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lblTreeName)
                            .add(lblTaxon)
                            .add(lblOrigTaxon)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(lblLocation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cboIsALiveTree, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboTaxon, 0, 407, Short.MAX_VALUE)
                    .add(txtOriginalTaxon, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(lblNamePrefix)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtTreeName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                    .add(panelLocation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            //.add(panelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTreeName)
                    .add(lblNamePrefix)
                    .add(txtTreeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTaxon)
                    .add(cboTaxon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblOrigTaxon)
                    .add(txtOriginalTaxon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblIsALiveTree)
                    .add(cboIsALiveTree, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelLocation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblLocation))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                )//.add(panelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGPSImport;
    private javax.swing.JComboBox cboIsALiveTree;
    private javax.swing.JComboBox cboTaxon;
    private javax.swing.JLabel lblIsALiveTree;
    private javax.swing.JLabel lblLatitude;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblLongitude;
    private javax.swing.JLabel lblNamePrefix;
    private javax.swing.JLabel lblOrigTaxon;
    private javax.swing.JLabel lblPrecision;
    private javax.swing.JLabel lblSpinUnits;
    private javax.swing.JLabel lblTaxon;
    private javax.swing.JLabel lblTreeName;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelLocation;
    private javax.swing.JSeparator seperatorButtons;
    private javax.swing.JTextField txtPrecision;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtOriginalTaxon;
    private javax.swing.JTextField txtTreeName;
    // End of variables declaration//GEN-END:variables
    
}
