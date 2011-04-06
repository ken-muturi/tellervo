package edu.cornell.dendro.corina.gis;

import edu.cornell.dendro.corina.dictionary.Dictionary;
import edu.cornell.dendro.corina.schema.WSIWmsServer;
import edu.cornell.dendro.corina.ui.Alert;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class WMSManager extends JFrame {
    private final Dimension wmsPanelSize = new Dimension(400, 600);
    protected WorldWindowGLCanvas wwd;
    private JTabbedPane tabbedPane;
    private int previousTabIndex;
    
    /*private static final String[] servers = new String[]
	{
    	   // "http://hypercube.telascience.org/cgi-bin/mapserv?map=/geo/haiti/mapfiles/4326.map&",
	       "http://neowms.sci.gsfc.nasa.gov/wms/wms",
	       // "http://mapserver.flightgear.org/cgi-bin/landcover",
	       // "http://wms.jpl.nasa.gov/wms.cgi",
	       // "http://nasa.network.com/wms"
	};*/
    
    ArrayList<WSIWmsServer> serverDetails = new ArrayList<WSIWmsServer>();
    
    
    public WMSManager(WorldWindowGLCanvas wwd)
    {
    	this.wwd = wwd;
    	setupGUI();
    }
    
    @SuppressWarnings("unchecked")
	public void setupGUI()
    {
    	serverDetails = Dictionary.getMutableDictionary("wmsServerDictionary");

    	if(serverDetails==null || serverDetails.size()==0)
    	{
    		Alert.error("Error", "No WMS servers configured");
    		this.dispose();
    	}
    	
        this.tabbedPane = new JTabbedPane();

        this.tabbedPane.add(new JPanel());
        this.tabbedPane.setTitleAt(0, "+");
        this.tabbedPane.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent changeEvent)
            {
                if (tabbedPane.getSelectedIndex() != 0)
                {
                    previousTabIndex = tabbedPane.getSelectedIndex();
                    return;
                }

                String server = JOptionPane.showInputDialog("Enter wms server URL");
                if (server == null || server.length() < 1)
                {
                    tabbedPane.setSelectedIndex(previousTabIndex);
                    return;
                }

                // Respond by adding a new WMSLayerPanel to the tabbed pane.
                WSIWmsServer newserver = new WSIWmsServer();
                newserver.setName("New server");
                newserver.setUrl(server.trim());
                if (addTab(tabbedPane.getTabCount(), newserver) != null)
                    tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
            }
        });

        // Create a tab for each server and add it to the tabbed panel.
        int i = 1;
    	for(WSIWmsServer server : serverDetails)    	
    	{
    		this.addTab(i, server);
    		i++;
    	}


        // Display the first server pane by default.
        this.tabbedPane.setSelectedIndex(this.tabbedPane.getTabCount() > 0 ? 1 : 0);
        this.previousTabIndex = this.tabbedPane.getSelectedIndex();

        // Add the tabbed pane to a frame separate from the world window.
        
        this.getContentPane().add(tabbedPane);
        this.pack();
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setTitle("WMS Layer Manager");
    }

    private WMSLayersPanel addTab(int position, WSIWmsServer server)
    {
        // Add a server to the tabbed dialog.
        try
        {
            WMSLayersPanel layersPanel = new WMSLayersPanel(wwd, server.getUrl(), server.getName(), wmsPanelSize);
            this.tabbedPane.add(layersPanel, BorderLayout.CENTER);
            String title = layersPanel.getServerDisplayString();
            this.tabbedPane.setTitleAt(position, title != null && title.length() > 0 ? title : server.getName());

            // Add a listener to notice wms layer selections and tell the layer panel to reflect the new state.
            layersPanel.addPropertyChangeListener("LayersPanelUpdated", new PropertyChangeListener()
            {
                public void propertyChange(PropertyChangeEvent propertyChangeEvent)
                {
                    //WMSLayersPanel.this.getLayerPanel().update(AppFrame.this.getWwd());
                }
            });

            return layersPanel;
        }
        catch (URISyntaxException e)
        {
            JOptionPane.showMessageDialog(null, "Server URL is invalid", "Invalid Server URL",
                JOptionPane.ERROR_MESSAGE);
            tabbedPane.setSelectedIndex(previousTabIndex);
            return null;
        }
    }
}
