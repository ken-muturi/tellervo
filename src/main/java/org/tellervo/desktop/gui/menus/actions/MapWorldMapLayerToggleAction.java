package org.tellervo.desktop.gui.menus.actions;

import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.util.Logging;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import org.tellervo.desktop.editor.FullEditor;
import org.tellervo.desktop.ui.Builder;

public class MapWorldMapLayerToggleAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private FullEditor editor;
	
	public MapWorldMapLayerToggleAction(FullEditor editor) {
        super("Overview Map", Builder.getIcon("mapoverview.png", 22));
		putValue(SHORT_DESCRIPTION, "Show/hide the overview map");
		putValue(Action.SELECTED_KEY, true);
        this.editor = editor;

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Layer worldMapLayer = editor.getMapPanel().getWwd()
				.getModel().getLayers()
				.getLayerByName(Logging.getMessage("layers.Earth.WorldMapLayer.Name"));
		
		worldMapLayer.setEnabled(!worldMapLayer.isEnabled());
		
	}

}
