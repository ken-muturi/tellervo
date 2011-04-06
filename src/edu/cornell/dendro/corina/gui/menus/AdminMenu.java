//
// This file is part of Corina.
//
// Corina is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// Corina is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Corina; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
// Copyright 2003 Ken Harris <kbh7@cornell.edu>
//

package edu.cornell.dendro.corina.gui.menus;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import edu.cornell.dendro.corina.core.App;
import edu.cornell.dendro.corina.core.AppModel;
import edu.cornell.dendro.corina.gis.GISFrame;
import edu.cornell.dendro.corina.gui.AboutBox;
import edu.cornell.dendro.corina.gui.dbbrowse.MetadataBrowser;
import edu.cornell.dendro.corina.ui.Builder;
import edu.cornell.dendro.corina.ui.CorinaAction;
import edu.cornell.dendro.corina.ui.I18n;

// TODO: move all menus to corina.gui.menus or even corina.menus (i'm tending towards the latter)
// TODO: error-log should be a singleton-window, and centered
// TODO: system-info should be a singleton-window, and centered
// TODO: perhaps also provide a menuitem which takes you to the corina web page?
// TODO: the error log should be just a text dump window, perhaps
// TODO: need a complaint menu item; perhaps "Submit Complaint..."

/**
   A Help menu.

   <p>Standard menuitems are:</p>

   <ul>
     <li>Corina Help</li>
     <br>
     <li>System Properties...</li>
     <li>Error Log...</li>
     <br>
     <li>About Corina... (except on Mac)</li>
   </ul>

   @author Ken Harris &lt;kbh7 <i style="color: gray">at</i> cornell <i style="color: gray">dot</i> edu&gt;
   @version $Id: HelpMenu.java 2163 2009-09-15 19:39:09Z Peter Brewer $
*/
@SuppressWarnings("serial")
public class AdminMenu extends JMenu {
	
	
	
  public static final CorinaAction ABOUT_ACTION = new CorinaAction("menus.about") {
    public void actionPerformed(ActionEvent ae) {
      AboutBox.getInstance().setVisible(true);
   
    }
  };
/** Make a new Admin menu. */
  public AdminMenu(JFrame frame) {
      super(I18n.getText("menus.admin"));
      
      init();
      linkModel();  
  }
  
  protected void linkModel()
  {
	  App.appmodel.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent argEvt) {
				if(argEvt.getPropertyName().equals(AppModel.NETWORK_STATUS)){
					setEnabled(App.isLoggedIn());
				}	
			}
		});
	  
	  setEnabled(App.isLoggedIn());
  }
  
  
  protected void init() {

	  addUserGroupMenu();
	  addPasswordMenu();
      	addSeparator();
	  addReportsMenu();
	  addLabelMenu();
	  	addSeparator();
	  addCurationMenu();
	  
  }
  
	protected void addPasswordMenu()
  	{
  	  JMenuItem changepwd = Builder.makeMenuItem("menus.admin.changepwd",
              "edu.cornell.dendro.corina.admin.SetPasswordUI.loadDialog()", "password.png");
   	  add(changepwd); 
   	  
   	  
   	  if(App.prefs.getPref("corina.login.remember_password") != null)
   	  {
   		  JMenuItem forgetpwd = Builder.makeMenuItem("menus.admin.forgetpwd",
   				  "edu.cornell.dendro.corina.gui.menus.AdminMenu.forgetPassword()", "forgetpassword.png");
   		  add(forgetpwd);
   	  }
   	  
  	}
  	
    /**
     * Remove preferences for remembering password and autologging in
     */
    public static void forgetPassword()
    {
		App.prefs.removePref("corina.login.remember_password");
		App.prefs.removePref("corina.login.password");
		App.prefs.removePref("corina.login.auto_login");
		// TODO Would be good to disable or remove the button after this
    }
    
  
    /**
       Add the "Labels" menuitem.
    */
    protected void addLabelMenu() {
    	
    	JMenu labelmenu = Builder.makeMenu("menus.admin.labels", "label.png");

    	
    	JMenuItem boxlabel = Builder.makeMenuItem("menus.admin.boxlabels",
                "edu.cornell.dendro.corina.util.labels.ui.PrintingDialog.boxLabelDialog()", "box.png");
        labelmenu.add(boxlabel);
    	
        JMenuItem samplelabel = Builder.makeMenuItem("menus.admin.samplelabels",
                "edu.cornell.dendro.corina.util.labels.ui.PrintingDialog.sampleLabelDialog()", "sample.png");
        labelmenu.add(samplelabel);   
        add(labelmenu);
    }
    
    /**
    Add the "Reports" menuitem.
    */
	 protected void addReportsMenu() {
	 	
	 	JMenu reportmenu = Builder.makeMenu("menus.admin.reports", "prosheet.png");
	 	
	 	
	    JMenuItem prosheet = Builder.makeMenuItem("menus.admin.prosheet",
	            "edu.cornell.dendro.corina.util.labels.ui.PrintingDialog.proSheetPrintingDialog()", "prosheet.png");
	    reportmenu.add(prosheet); 
	 	add(reportmenu);
	 }
 
	 /**
	 Add the "User and groups" menuitem.
	*/
	protected void addUserGroupMenu() {
		
	  	JMenuItem usergroup = Builder.makeMenuItem("menus.admin.usersandgroups",
	            "edu.cornell.dendro.corina.admin.UserGroupAdmin.main()", "edit_group.png");
	
	  	
		// Enable if user is an admin
	  	Boolean adm = App.isAdmin;
		usergroup.setEnabled(adm);
		
		add(usergroup);
	}

	 /**
	 Add the "Curation" menuitem.
	*/
	protected void addCurationMenu() {
		
	 	JMenu curationmenu = Builder.makeMenu("menus.admin.curation", "curation.png");
	 	
	 	
	    JMenuItem findsample = Builder.makeMenuItem("menus.admin.findsample",
	            "edu.cornell.dendro.corina.admin.SampleCuration.showDialog()", "findsample.png");
	    curationmenu.add(findsample); 
	    
	    curationmenu.addSeparator();
	    
	    JMenuItem boxdetails = Builder.makeMenuItem("menus.admin.boxdetails",
	            "edu.cornell.dendro.corina.admin.BoxCuration.showDialog()", "box.png");
	    curationmenu.add(boxdetails); 
	    
	    JMenuItem checkoutbox = Builder.makeMenuItem("menus.admin.checkoutbox",
	            "edu.cornell.dendro.corina.admin.BoxCuration.checkoutBox()", "checkout.png");
	    curationmenu.add(checkoutbox); 
	    
	    JMenuItem checkinbox = Builder.makeMenuItem("menus.admin.checkinbox",
	            "edu.cornell.dendro.corina.admin.BoxCuration.checkinBox()", "checkin.png");
	    curationmenu.add(checkinbox); 
	    
	    JMenuItem inventory = Builder.makeMenuItem("menus.admin.inventory",
	            "edu.cornell.dendro.corina.util.labels.ui.PrintingDialog.proSheetPrintingDialog()");
	    inventory.setEnabled(false);
	    //curationmenu.add(inventory); 
	    
	 	add(curationmenu);
	 	addSeparator();
		add(Builder.makeMenuItem("menus.admin.metadatabrowser", "edu.cornell.dendro.corina.gui.menus.AdminMenu.metadataBrowser()", "database.png"));
		add(Builder.makeMenuItem("general.sitemap", "edu.cornell.dendro.corina.gui.menus.AdminMenu.showMap()", "globe.png"));


	}
    
	public static void metadataBrowser(){
		MetadataBrowser dialog = new MetadataBrowser(null, false);
		dialog.setVisible(true);
	}
	
	public static void showMap(){
				
		GISFrame map = new GISFrame();
		map.setVisible(true);
    
		
	}
}
