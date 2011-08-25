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
package edu.cornell.dendro.corina.gis;

import edu.cornell.dendro.corina.core.App;
import edu.cornell.dendro.corina.prefs.Prefs.PrefKey;
import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.event.RenderingExceptionListener;
import gov.nasa.worldwind.event.SelectEvent;
import gov.nasa.worldwind.event.SelectListener;
import gov.nasa.worldwind.examples.ApplicationTemplate;
import gov.nasa.worldwind.examples.ClickAndGoSelectListener;
import gov.nasa.worldwind.examples.util.LayerManagerLayer;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.geom.Vec4;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.layers.ScalebarLayer;
import gov.nasa.worldwind.layers.ViewControlsLayer;
import gov.nasa.worldwind.layers.ViewControlsSelectListener;
import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwind.pick.PickedObject;
import gov.nasa.worldwind.util.Logging;
import gov.nasa.worldwind.util.StatusBar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.tridas.interfaces.ITridas;

/**
 * Map panel containing a WorldWind Java canvas
 * 
 * @author peterbrewer
 *
 */
public class GISPanel extends JPanel implements SelectListener{

	private static final long serialVersionUID = 6769486491009238118L;
		protected WorldWindowGLCanvas wwd;
        protected StatusBar statusBar;
        protected TridasMarker selectedMarker;
        protected RenderableLayer annotationLayer;
        protected TridasAnnotation annotation;
        protected Boolean isGrfxRetest= false;
        protected Boolean failedRetest;
        protected ViewControlsLayer viewControlsLayer;
        protected Boolean isMiniMap = false;
        
        
        public Boolean isMiniMap()
        {
        	return isMiniMap;
        }
        
        public void setIsMiniMap(Boolean b)
        {
        	isMiniMap = b;
        }
        
        public GISPanel(Dimension canvasSize, boolean includeStatusBar, MarkerLayer ly)
        {
        	super(new BorderLayout());
        	
        	if(App.prefs.getBooleanPref(PrefKey.OPENGL_FAILED, false))
        	{
        		wwd=null;
        		failedReq();
        		return;
        	}
        	            
        	setupGui(canvasSize, includeStatusBar);
        	addLayer(ly);
        	
            this.annotationLayer = new RenderableLayer();
            annotationLayer.setName("Popup information");
            ApplicationTemplate.insertBeforePlacenames(this.getWwd(), this.annotationLayer);

        	this.getWwd().addSelectListener(this);
        	
        	
            // Find ViewControls layer and keep reference to it
            /*for (Layer layer : this.getWwd().getModel().getLayers())
            {
                if (layer instanceof ViewControlsLayer)
                {
                    viewControlsLayer = (ViewControlsLayer) layer;                 
                }
            }*/
            
            // Create and install the view controls layer and register a controller for it with the World Window.
            ViewControlsLayer viewControlsLayer = new ViewControlsLayer();
            viewControlsLayer.setPosition(AVKey.NORTHEAST);
            ApplicationTemplate.insertBeforeCompass(getWwd(), viewControlsLayer);
            viewControlsLayer.setLayout(AVKey.VERTICAL);
            this.getWwd().addSelectListener(new ViewControlsSelectListener(this.getWwd(), viewControlsLayer));
            
            CompassLayer compass = (CompassLayer) this.getWwd().getModel().getLayers().getLayerByName("Compass");
            compass.setPosition(AVKey.SOUTHEAST);
            compass.setLocationOffset(new Vec4(0, 20));
            
            WorldMapLayer overview = (WorldMapLayer) this.getWwd().getModel().getLayers().getLayerByName("World Map");
            overview.setPosition(AVKey.SOUTHWEST);
            overview.setResizeBehavior(AVKey.RESIZE_STRETCH);
            
            ScalebarLayer scale = (ScalebarLayer) this.getWwd().getModel().getLayers().getLayerByName("Scale bar");
            

        	overview.setEnabled(isMiniMap);
        	compass.setEnabled(isMiniMap);
        	scale.setEnabled(isMiniMap);

        }

        public Boolean isGrfxRetest()
        {
        	return this.isGrfxRetest;
        }
        
        public Boolean getFailedRetest()
        {
        	return this.failedRetest;
        }
        
        public void setIsGrfxRetest(Boolean b)
        {
        	this.isGrfxRetest = b;
        }

 
        public void addLayer(MarkerLayer layer)
        {
        	ApplicationTemplate.insertBeforePlacenames(this.getWwd(), layer);
        }
        
        public void addLayer(Layer layer)
        {
        	ApplicationTemplate.insertBeforeCompass(this.getWwd(), layer);
        }
        
        private void failedReq()
        {
        	this.failedRetest = true;
        	App.prefs.setBooleanPref(PrefKey.OPENGL_FAILED, true);
        	GrfxWarning warn = new GrfxWarning(this);
        	warn.btnRetry.setVisible(false);
        	this.add(warn, BorderLayout.CENTER);
        }
                
        private void setupGui(Dimension canvasSize, boolean includeStatusBar)
        {
        	
            this.wwd = this.createWorldWindow();
            this.wwd.setPreferredSize(canvasSize);
                
            // Create the default model as described in the current worldwind properties.
            Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
            this.wwd.setModel(m);
            
            // Setup a select listener for the worldmap click-and-go feature
            this.wwd.addSelectListener(new ClickAndGoSelectListener(this.getWwd(), WorldMapLayer.class));

            this.wwd.addRenderingExceptionListener(new RenderingExceptionListener()
            {
                public void exceptionThrown(Throwable t)
                {
                	GISPanel.this.remove((Component) wwd);
                	GISPanel.this.failedReq();
                    return;
                        
                }
            });
            
            
            this.add(this.wwd, BorderLayout.CENTER);
           
            
            if (includeStatusBar)
            {
                this.statusBar = new StatusBar();
                this.add(statusBar, BorderLayout.PAGE_END);
                this.statusBar.setEventSource(wwd);
            }
            
            // Add the layer manager layer to the model layer list
            
            if(isMiniMap)
            {
	            CorinaLayerManagerLayer layermanager = new CorinaLayerManagerLayer(getWwd(), getWwd().getModel().getLayers());
	            layermanager.setName("Show/hide layer list");
	            layermanager.setMinimized(true);
	            layermanager.setPosition(AVKey.NORTHWEST);
	            getWwd().getModel().getLayers().add(layermanager);
            }

            
        }
        
        protected WorldWindowGLCanvas createWorldWindow()
        {
            return new WorldWindowGLCanvas();
        }

        public WorldWindowGLCanvas getWwd()
        {
            return wwd;
        }

        public StatusBar getStatusBar()
        {
            return statusBar;
        }


        public void selected(SelectEvent e)
        {
            if (e == null)
                return;

            PickedObject topPickedObject = e.getTopPickedObject();

           /* if (e.getEventAction() == SelectEvent.LEFT_PRESS)
            {
                if (topPickedObject != null && topPickedObject.getObject() instanceof TridasMarker)
                {
                	TridasMarker selected = (TridasMarker) topPickedObject.getObject();
                    this.highlight(selected);
                }
                else
                {
                    this.highlight(null);
                }
            }*/
            if (e.getEventAction() == SelectEvent.LEFT_PRESS)
            {
                if (topPickedObject != null && topPickedObject.getObject() instanceof TridasMarker)
                {
                	TridasMarker selected = (TridasMarker) topPickedObject.getObject();
                    this.highlight(selected);
                    this.openResource(selected);
                }
            }

        }
        
        public void highlight(TridasMarker marker)
        {
            if (this.selectedMarker == marker)
                return;

            if (this.selectedMarker != null)
            {
                this.selectedMarker = null;
            }

            if (marker != null)
            {
                this.selectedMarker = marker;
            }

            this.getWwd().redraw();            
        }

        protected void closeResource(ContentAnnotation content)
        {
            if (content == null)
                return;

            content.detach();
        }
        
        protected void openResource(TridasMarker marker)
        {
            if (marker == null)
                return;

            ContentAnnotation content = this.createContent(marker.getPosition(), marker.getEntity());

            if (content != null)
            {
                content.attach();
            }
        }
        
        protected ContentAnnotation createContent(Position position, ITridas entity)
        {
            return createContentAnnotation(this, position, entity);
        }
        
        public static ContentAnnotation createContentAnnotation(GISPanel mapPanel, Position position, ITridas entity)
        {
            if (mapPanel == null)
            {
                String message = "AppFrameIsNull";
                Logging.logger().severe(message);
                throw new IllegalArgumentException(message);
            }

            if (position == null)
            {
                String message = Logging.getMessage("nullValue.PositionIsNull");
                Logging.logger().severe(message);
                throw new IllegalArgumentException(message);
            }


            return createTridasAnnotation(mapPanel, position, "blah", entity);

           
        }
        
        public static ContentAnnotation createTridasAnnotation(GISPanel mapPanel, Position position, String title,
                ITridas entity)
            {
                if (mapPanel == null)
                {
                    String message = "AppFrameIsNull";
                    Logging.logger().severe(message);
                    throw new IllegalArgumentException(message);
                }

                if (position == null)
                {
                    String message = Logging.getMessage("nullValue.PositionIsNull");
                    Logging.logger().severe(message);
                    throw new IllegalArgumentException(message);
                }

                if (title == null)
                {
                    String message = Logging.getMessage("nullValue.StringIsNull");
                    Logging.logger().severe(message);
                    throw new IllegalArgumentException(message);
                }

                if (entity == null)
                {
                    String message = Logging.getMessage("nullValue.SourceIsNull");
                    Logging.logger().severe(message);
                    throw new IllegalArgumentException(message);
                }

                TridasAnnotation annotation = new TridasAnnotation(position, entity);
                annotation.setAlwaysOnTop(true);
                

                TridasAnnotationController controller = new TridasAnnotationController(mapPanel.getWwd(), annotation, entity);

                
                return new TridasContentAnnotation(mapPanel, annotation, controller, entity);
            }
        

        protected RenderableLayer getAnnotationLayer()
        {
        	return this.annotationLayer;
        }
		
	
	    public static class ContentAnnotation implements ActionListener
	    {
	        protected GISPanel mapPanel;
	        protected TridasAnnotation annotation;
	        protected TridasAnnotationController controller;

	        public ContentAnnotation(GISPanel mapPanel, TridasAnnotation annotation, TridasAnnotationController controller)
	        {
	            this.mapPanel = mapPanel;
	            this.annotation = annotation;
	            this.annotation.addActionListener(this);
	            this.controller = controller;
	        }

	        public GISPanel getMapPanel()
	        {
	            return this.mapPanel;
	        }

	        public TridasAnnotation getAnnotation()
	        {
	            return this.annotation;
	        }

	        public TridasAnnotationController getController()
	        {
	            return this.controller;
	        }

	        public void actionPerformed(ActionEvent e)
	        {
	            if (e == null)
	                return;

	            if (e.getActionCommand() == AVKey.CLOSE)
	            {
	                this.getMapPanel().closeResource(this);
	            }
	        }

	        public void detach()
	        {
	            this.getController().setEnabled(false);

	            RenderableLayer layer = this.getMapPanel().getAnnotationLayer();
	            layer.removeRenderable(this.getAnnotation());
	        }

	        public void attach()
	        {
	            this.getController().setEnabled(true);

	            RenderableLayer layer = this.mapPanel.getAnnotationLayer();
	            layer.removeRenderable(this.getAnnotation());
	            layer.addRenderable(this.getAnnotation());
	        }
	    }
		
	    public static class TridasContentAnnotation extends ContentAnnotation
	    {

	    	ITridas entity;
	    	
			public TridasContentAnnotation(GISPanel mapPanel,
					TridasAnnotation annotation,
					TridasAnnotationController controller,
					ITridas entity) {
				super(mapPanel, annotation, controller);
				this.entity=entity;
			}
	    	
	    }
	    

		
}
