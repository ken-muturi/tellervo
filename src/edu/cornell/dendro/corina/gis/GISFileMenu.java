package edu.cornell.dendro.corina.gis;

import javax.swing.JMenuItem;

import edu.cornell.dendro.corina.core.App;
import edu.cornell.dendro.corina.gui.menus.FileMenu;
import edu.cornell.dendro.corina.ui.Builder;
import edu.cornell.dendro.corina.ui.I18n;
import gov.nasa.worldwind.examples.util.ScreenShotAction;

public class GISFileMenu extends FileMenu {

	private static final long serialVersionUID = 4583709816910084036L;

	
	public GISFileMenu(GISFrame f) {
		super(f);
	}
	
	@Override
	public void addPrintMenu() {
		// Add report printing entry
		JMenuItem reportPrint = Builder.makeMenuItem("menus.file.print", true, "printer.png");
		reportPrint.setEnabled(false);
		add(reportPrint);

		// Add preview printing entry
		JMenuItem reportPreview = Builder.makeMenuItem("menus.file.printpreview", true);
		reportPreview.setEnabled(false);
		add(reportPreview);		

	}
	

	@Override
	public void addIOMenus(){
		
		JMenuItem importmenu = Builder.makeMenuItem("menus.file.import", "edu.cornell.dendro.corina.gui.menus.FileMenu.importdbwithbarcode()", "fileimport.png");
		importmenu.setEnabled(false);
		add(importmenu);
		
		GISPanel panel = ((GISFrame)this.f).wwMapPanel;
		
        JMenuItem exportmenu = new JMenuItem(I18n.getText("menus.file.exportmapimage"));
        exportmenu.setIcon(Builder.getIcon("captureimage.png", 22));
        exportmenu.addActionListener(new ScreenShotAction(panel.wwd));
        
        add(exportmenu);
	}
	
	
	  protected void setMenusForNetworkStatus()
	  {

		  logoff.setVisible(App.isLoggedIn());  
		  logon.setVisible(!App.isLoggedIn());  
		  fileopen.setEnabled(App.isLoggedIn());
		  fileopenmulti.setEnabled(App.isLoggedIn());
		  openrecent.setEnabled(App.isLoggedIn());
		  //fileimport.setEnabled(App.isLoggedIn());
		  //fileexport.setEnabled(App.isLoggedIn());
		  //bulkentry.setEnabled(App.isLoggedIn());
		  //save.setEnabled(App.isLoggedIn() && f instanceof SaveableDocument);

	  }

}
