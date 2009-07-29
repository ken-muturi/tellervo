package edu.cornell.dendro.corina.tridasv2.ui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import org.tridas.schema.SeriesLink;
import org.tridas.schema.TridasDatingReference;
import org.tridas.schema.TridasIdentifier;

import com.l2fprod.common.beans.editor.AbstractPropertyEditor;

import edu.cornell.dendro.corina.editor.Editor;
import edu.cornell.dendro.corina.gui.Bug;
import edu.cornell.dendro.corina.sample.CorinaWsiTridasElement;
import edu.cornell.dendro.corina.sample.Sample;
import edu.cornell.dendro.corina.ui.Builder;

/**
 * Renderer class for SeriesLink
 * 
 * Also works with containers for seriesLink:
 * 	TridasDatingReference
 * 
 * Others can be added manually
 * 
 * @author Lucas Madar
 *
 */

public class TridasSeriesLinkRendererEditor extends AbstractPropertyEditor implements
		TableCellRenderer {
	private static final long serialVersionUID = 1L;
	
	/** When we're rendering, this is our label, lazily created */
	private DefaultTableCellRenderer label;
	
	private JButton openButton;
	
	/** The value we're holding (for editor) */
	private Object myValue;
	
	public TridasSeriesLinkRendererEditor() {
		
		// create a new "editor" panel
		JPanel panel = new JPanel();		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		openButton = Builder.makeButton("open");
		panel.add(openButton);
		panel.add(Box.createHorizontalGlue());
		panel.setOpaque(false);
		
		editor = panel;
		
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpen();
			}
		});
	}

	private void doOpen() {
		SeriesLink link = getSeriesLinkForValue(myValue);
		
		if(!link.isSetIdentifier()) {
			new Bug(new IllegalArgumentException("doOpen() called for non-identifier link?"));
			return;
		}
		
		TridasIdentifier identifier = link.getIdentifier();
		CorinaWsiTridasElement element = new CorinaWsiTridasElement(identifier);
		
		Window window = SwingUtilities.getWindowAncestor(editor);
		Frame frame = (window instanceof Frame) ? ((Frame) window) : null;
		
		try {
			Sample s = element.load(frame);
			new Editor(s);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(frame, "Could not load: " + 
					ioe.getMessage(), "Error loading", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Object getValue() {
		return myValue;
	}
	
	public void setValue(Object value) {
		myValue = value;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		if(label == null)
			label = new DefaultTableCellRenderer();
		
		label.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		SeriesLink link = getSeriesLinkForValue(value);
		
		if(link != null && link.isSetIdentifier())
			label.setText("Click to open");
		else if(link != null)
			label.setText("Not openable");
		else
			label.setText("");
		
		return label;
	}
	
	private SeriesLink getSeriesLinkForValue(Object value) {
		if(value instanceof SeriesLink)
			return (SeriesLink) value;
		
		if(value instanceof TridasDatingReference)
			return ((TridasDatingReference)value).getLinkSeries();
		
		return null;
	}
}
