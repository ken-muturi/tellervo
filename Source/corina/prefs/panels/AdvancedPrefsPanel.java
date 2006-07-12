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

package corina.prefs.panels;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;

import corina.core.App;
import corina.io.SerialSampleIO;
import corina.prefs.components.BoolPrefComponent;
import corina.prefs.components.FontPrefComponent;
import corina.util.DocumentListener2;

// TODO: javadoc

// TODO: center this stuff

// TODO: i18n

/*
    [ ] override menubar font
        font: Lucida Grande 11
              (Change...)
        
    [ ] Override user name
        name: [             ]
        
    
    use which file chooser:
        (*) swing (slower)
        ( ) awt (faster, but no preview)
*/

public class AdvancedPrefsPanel extends JPanel {
  private FontPrefComponent fontprefcomponent = new FontPrefComponent("corina.menubar.font");
  public AdvancedPrefsPanel() {
    // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setLayout(new BorderLayout());
    //setLayout(new GridLayout(0, 1));
    
    Container co = new Container();
    co.setLayout(new GridBagLayout());
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.NONE;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.gridy = 0;
    gbc.gridx = 0;
    gbc.weightx = 1;
    
    // menubar font override
    final JCheckBox menubarCheckBox = new JCheckBox("Override menubar font");
    menubarCheckBox.setAlignmentX(LEFT_ALIGNMENT);
    co.add(menubarCheckBox, gbc);

    // TODO: make checkbox a bool-pref
    // TODO: make checkbox control font-pref-component (dim)
    // TODO: c.gui.menubar.font isn't the right pref!
    // TODO: figure out how to make the checkbox un-set the font pref
    // (idea: PrefComponent interface, getPref(), checkbox calls
    // getPref() on controlled components, sets them to null on dim)

    gbc.gridx++;
    co.add(fontprefcomponent.getLabel(), gbc);

    gbc.gridx++;
    gbc.weightx = 1;
    co.add(fontprefcomponent.getButton(), gbc);

    fontprefcomponent.getLabel().setEnabled(menubarCheckBox.isSelected()); 
    fontprefcomponent.getButton().setEnabled(menubarCheckBox.isSelected());

    menubarCheckBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        fontprefcomponent.getLabel().setEnabled(menubarCheckBox.isSelected());
        fontprefcomponent.getButton().setEnabled(menubarCheckBox.isSelected());
      }
    });

    // user name override
    // TODO: fix layout
    // TODO: change these to better names (usernameCheckbox, usernameField)
    final JCheckBox username = new JCheckBox("Override user name");
    final JTextField usernameField = new JTextField(20);
    final JLabel usernameLabel = new JLabel("Name:");
    usernameLabel.setLabelFor(usernameField);

    // set initial state from prefs
    if (App.prefs.getPref("corina.user.name") != null) {
      username.setSelected(true);
      usernameField.setText(App.prefs.getPref("corina.user.name"));
    } else {
      username.setSelected(false);
      usernameField.setEnabled(false);
      usernameLabel.setEnabled(false);
      usernameField.setText(System.getProperty("user.name"));
    }

    /*
        why use corina.user.name instead of just setting user.name directly?
        because if the user unchecks the checkbox, we need to be able to get
        the original value of user.name back, and once you set the system
        property user.name to something else, the original value is gone.
    */

    username.setAlignmentX(LEFT_ALIGNMENT);
    username.addActionListener(new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            // enable/disable text field
            usernameField.setEnabled(username.isSelected());
            usernameLabel.setEnabled(username.isSelected());
            
            // name to use: either the default, or the user's version
            String name;
            if (username.isSelected())
                name = usernameField.getText();
            else
                name = System.getProperty("user.name");

            // set pref
            App.prefs.setPref("corina.user.name", name);
        }
    });

    usernameField.getDocument().addDocumentListener(new DocumentListener2() {
        public void update(DocumentEvent e) {
          App.prefs.setPref("corina.user.name", usernameField.getText());
        }
    });

    gbc.gridy++;
    gbc.gridx = 0;
    gbc.weightx = 0;

    co.add(username, gbc);

    gbc.gridx++;

    co.add(usernameLabel, gbc);

    gbc.gridx++;
    gbc.weightx = 1;

    co.add(usernameField, gbc);
    
    // serial IO capability...?
    if (SerialSampleIO.hasSerialCapability()) {
    	gbc.gridy++;
    	gbc.gridx = 0;
    	gbc.weightx = 0;
    	
    	boolean addedPort = false;
    	JLabel label = new JLabel("Sample Recorder Data Port");
    	// first, enumerate all the ports.
    	Vector comportlist = SerialSampleIO.enumeratePorts();
    	
    	// do we have a COM port selected that's not in the list? (ugh!)
    	String curport = App.prefs.getPref("corina.serialsampleio.port");
    	if (curport != null && !comportlist.contains(curport)) {
    		comportlist.add(curport);
    		addedPort = true;
    	}
    	else if(curport == null) {
    		curport = "<choose a serial port>";
    		comportlist.add(curport);
    	}
    	
    	// make the combobox, and select the current port...
    	final JComboBox comports = new JComboBox(comportlist);
    	if (curport != null)
    		comports.setSelectedItem(curport);
    	
    	comports.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			App.prefs.setPref("corina.serialsampleio.port",
    					(String) comports.getSelectedItem());
    		}
    	});
    	
    	label.setLabelFor(comports);
    	co.add(label, gbc);
    	
    	gbc.gridx++;
    	gbc.weightx = 1;
    	
    	co.add(comports, gbc);
    	
    	// add a warning message if we have a strange com port...
    	if (addedPort) {
    		gbc.gridy++;
    		gbc.gridx = 1;
    		gbc.gridwidth = gbc.REMAINDER;
    		gbc.weightx = 0;
    		gbc.fill = gbc.VERTICAL;
    		
    		label = new JLabel(
    				"<html>The communications port '"
    				+ curport
    				+ "' was not found.<br>It may be in use;<br>"
    				+ "you may experience problems if you attempt to use it.");
    		co.add(label, gbc);
    		
    		gbc.fill = gbc.NONE;
    		gbc.gridwidth = 1;
    	}
    }

    gbc.gridy++;
    gbc.gridx = 0;
    gbc.weightx = 0;
    
    Component c = new BoolPrefComponent("BETA: Smoothed feel on Windows [requires restart]", "corina.windows.smooth");
    co.add(c, gbc);

    gbc.gridy++;    
    c = new BoolPrefComponent("<html>Adaptive reading for elements (G:\\DATA removal)<br>" +
    		"<font size=-2>Attempts to interpret absolute paths when reading from sums.", "corina.dir.adaptiveread");
    co.add(c, gbc);
    
    gbc.gridy++;    
    c = new BoolPrefComponent("<html>Save relative paths to elements<br>" +
    		"<font size=-2>Sums produced with this on will not be compatible with older versions of Corina.", "corina.dir.relativepaths");
    co.add(c, gbc);
    
    // file chooser
    /*
	 * This appears to be absolutely useless. Commented out for now? - lucas
	 * ButtonGroup group = new ButtonGroup(); JRadioButton swing = new
	 * JRadioButton("Swing (slower)"); JRadioButton awt = new JRadioButton("AWT
	 * (faster, but no preview)"); group.add(swing); group.add(awt);
	 * 
	 * JLabel l = new JLabel("Use which file chooser:");
	 * l.setAlignmentX(LEFT_ALIGNMENT);
	 * 
	 * co.add(l, gbc);
	 * 
	 * gbc.gridx++;
	 * 
	 * co.add(swing, gbc);
	 * 
	 * gbc.gridx++; gbc.weightx = 1;
	 * 
	 * co.add(awt, gbc);
	 *  // TODO: add spacer below bottom, just in case?
	 * 
	 */

    add(co, BorderLayout.NORTH);
  }
  
  public void addNotify() {
    fontprefcomponent.setParent(getTopLevelAncestor());
    super.addNotify();
  }
}
