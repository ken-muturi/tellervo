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
// Copyright 2001 Ken Harris <kbh7@cornell.edu>
//

package org.tellervo.desktop.manip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.EnumSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.tellervo.desktop.Range;
import org.tellervo.desktop.Year;
import org.tellervo.desktop.editor.Editor;
import org.tellervo.desktop.gui.Layout;
import org.tellervo.desktop.gui.NameVersionJustificationPanel;
import org.tellervo.desktop.io.Metadata;
import org.tellervo.desktop.sample.CorinaWsiTridasElement;
import org.tellervo.desktop.sample.Sample;
import org.tellervo.desktop.sample.SampleType;
import org.tellervo.desktop.tridasv2.GenericFieldUtils;
import org.tellervo.desktop.tridasv2.SeriesLinkUtil;
import org.tellervo.desktop.tridasv2.ui.ComboBoxFilterable;
import org.tellervo.desktop.tridasv2.ui.EnumComboBoxItemRenderer;
import org.tellervo.desktop.ui.Alert;
import org.tellervo.desktop.ui.Builder;
import org.tellervo.desktop.ui.I18n;
import org.tellervo.desktop.util.Center;
import org.tellervo.desktop.util.OKCancel;
import org.tellervo.desktop.util.openrecent.OpenRecent;
import org.tellervo.desktop.util.openrecent.SeriesDescriptor;
import org.tellervo.desktop.wsi.tellervo.NewTridasIdentifier;
import org.tridas.interfaces.ITridasSeries;
import org.tridas.schema.ControlledVoc;
import org.tridas.schema.NormalTridasDatingType;
import org.tridas.schema.TridasDating;
import org.tridas.schema.TridasDerivedSeries;
import org.tridas.schema.TridasInterpretation;


/**
 * A dialog which enables the user to redate a sample. You can redate either one
 * that has already been loaded or a file on disk.
 * 
 * @author Ken Harris &lt;kbh7 <i style="color: gray">at</i> cornell <i
 *         style="color: gray">dot</i> edu&gt;
 * @author Lucas Madar
 * @version $Id$
 */
public class RedateDialog extends JDialog {
	/** A DocumentListener for the end value */
	private class EndListener implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			update();
		}

		public void insertUpdate(DocumentEvent e) {
			update();
		}

		public void removeUpdate(DocumentEvent e) {
			update();
		}

		private void update() {
			// disable StartListener
			startField.getDocument().removeDocumentListener(startListener);

			// get text
			String value = endField.getText();

			// if it's the same, do nothing -- (not worth the code)

			// set the range
			try {
				range = range.redateEndTo(new Year(value));
				startField.setText(range.getStart().toString());
			} catch (NumberFormatException nfe) {
				startField.setText(I18n.getText("error"));
			}

			// re-enable startListener
			startField.getDocument().addDocumentListener(startListener);
		}
	}

	/** A DocumentListener for the starting value */
	private class StartListener implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			update();
		}

		public void insertUpdate(DocumentEvent e) {
			update();
		}

		public void removeUpdate(DocumentEvent e) {
			update();
		}

		private void update() {
			// disable EndListener
			endField.getDocument().removeDocumentListener(endListener);

			// get text
			String value = startField.getText();

			// if it's the same, do nothing -- (not worth the code)

			// set the range
			try {
				range = range.redateStartTo(new Year(value));
				endField.setText(range.getEnd().toString());
			} catch (NumberFormatException nfe) {
				endField.setText(I18n.getText("error"));
			}

			// re-enable endListener
			endField.getDocument().addDocumentListener(endListener);
		}
	}

	private static final long serialVersionUID = 1L;
	
	/** The sample we're redating */
	private Sample sample;

	/** The new range */
	private Range range;
	
	/** The original dating type (can be null) */
	private NormalTridasDatingType originalDatingType;
	
	/** The current dating type */
	private NormalTridasDatingType datingType;

	/** The name, version, and justificaiton panel */
	private NameVersionJustificationPanel info;

	/** Text field document listeners to auto-update each other */
	private DocumentListener startListener, endListener;

	/** The Combo box that holds the dating type */
	protected JComboBox cboDatingType;
	
	/** The text boxes that hold our start/end year */
	protected JTextField startField, endField;

	/**
	 * @param sample
	 * @param owner
	 * @wbp.parser.constructor
	 */
	public RedateDialog(Sample sample, JFrame owner) {
		this(sample, owner, sample.getRange());
	}
	
	/**
	 * Create a redater for a loaded sample. The "OK" button will fire a
	 * <code>sampleRedated</code> event to update other views.
	 * 
	 * @param sample
	 *            the sample to redate
	 * @param owner
	 *            the owning frame
	 * @param startRange
	 * 			  the initial range
	 */
	public RedateDialog(Sample sample, JFrame owner, Range startRange) {
		// modal
		super(owner, true);

		// get sample
		this.sample = sample;

		// determine dating type
		setupDatingType();
		
		// pass
		setup(startRange);

		// all done
		pack();
		endField.requestFocusInWindow();
		
		Center.center(this, owner);
	}
	
	/**
	 * Apply a redate directly to the sample
	 * @param dating
	 */
	private void performRedateInPlace(TridasDating dating) {
		sample.postEdit(Redate.redate(sample, range, dating));
	}
	
	/**
	 * Create a new redate on the webservice
	 * @param dating
	 * @return true on success, false otherwise
	 */
	private boolean performCorinaWsiRedate(TridasDating dating) {
		// we have to have a name and a justification
		if(!info.testAndComplainRequired(EnumSet.of(NameVersionJustificationPanel.Fields.NAME,
				NameVersionJustificationPanel.Fields.JUSTIFICATION)))
			return false;

		TridasDerivedSeries series = new TridasDerivedSeries();
		
		// set title (and version?)
		series.setTitle(info.getSeriesName());
		if(info.hasVersion())
			series.setVersion(info.getVersion());
		
		// it's a truncate
		ControlledVoc voc = new ControlledVoc();
		voc.setValue(SampleType.REDATE.toString());
		series.setType(voc);
		
		// the identifier is based on the domain from the series
		series.setIdentifier(NewTridasIdentifier.getInstance(sample.getSeries().getIdentifier()));
		
		// set the parent
		SeriesLinkUtil.addToSeries(series, sample.getSeries().getIdentifier());
		
		// now, a redate has three other parameters
		TridasInterpretation interpretation = new TridasInterpretation();
		series.setInterpretation(interpretation);
		
		// 1: Dating type (but only if it changed)
		if(datingType != originalDatingType)
			interpretation.setDating(dating);

		// 2: Relative start year
		interpretation.setFirstYear(range.getStart().tridasYearValue());
		// looks like the genericField is what's actually used?
		GenericFieldUtils.setField(series, "tellervo.newStartYear", Integer.parseInt(range.getStart().toString()));

		// 3: Justification
		GenericFieldUtils.setField(series, "tellervo.justification", info.getJustification());
		
		// make a new 'redate' dummy sample for saving
		Sample tmp = new Sample(series);		

		try {
			CorinaWsiTridasElement saver = new CorinaWsiTridasElement(series.getIdentifier());
			// here's where we do the "meat"
			if(saver.save(tmp)) {
				// put it in our menu
				OpenRecent.sampleOpened(new SeriesDescriptor(tmp));
				
				new Editor(tmp).toFront();
				
				// get out of here! :)
				return true;
			}
		} catch (IOException ioe) {
			Alert.error(I18n.getText("error.couldNotRedate"), I18n.getText("error") + ": " + ioe.toString());
		}
		
		return false;
	}
	
	private boolean performRedate() {
		ITridasSeries series = sample.getSeries();
		TridasDating newDating;
		
		if(series.isSetInterpretation() && series.getInterpretation().isSetDating()) {
			TridasDating oldDating = series.getInterpretation().getDating();
			// create a copy!
			newDating = (TridasDating) oldDating.clone();
			oldDating.copyTo(newDating);
		}
		else
			// just make a new dating element
			newDating = new TridasDating();
		
		// set the new dating type
		newDating.setType(datingType);

		// if it's not derived and has no children, we can truncate in place
		if (!sample.getSampleType().isDerived()
				&& (!sample.hasMeta(Metadata.CHILD_COUNT) || sample.getMeta(Metadata.CHILD_COUNT, Integer.class) == 0)) {

			
			String message = MessageFormat.format(I18n.getText("question.doInPlace"),
					new Object[] { I18n.getText("menus.tools.redate").toLowerCase() });
			String options[] = { I18n.getText("question.deriveNewSeries"), I18n.getText("question.redateInPlace"), I18n.getText("general.cancel")};
			
			int ret = JOptionPane.showOptionDialog(this, message, I18n.getText("question.redateInPlace")+"?", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			switch(ret) {
			case 0:
				break;
				
			// truncate in place
			case 1:
				performRedateInPlace(newDating);
				return true;
			
			// cancel
			case 2:
				return false;
			}
		}
		
		if(sample.getLoader() instanceof CorinaWsiTridasElement) {
			return performCorinaWsiRedate(newDating);
		}
		
		Alert.error(I18n.getText("error"), I18n.getText("error.couldNotRedate"));
		
		return false;
	}
	
	private void setupDatingType() {
		ITridasSeries series = sample.getSeries();
		
		// default to relative if there's no information
		if(!series.isSetInterpretation() || !series.getInterpretation().isSetDating())
			datingType = NormalTridasDatingType.RELATIVE;
		else
			originalDatingType = datingType = series.getInterpretation().getDating().getType();
	}
	
	private JComboBox getDatingTypeComboBox() {
		final JComboBox combo = new ComboBoxFilterable(NormalTridasDatingType.values());
		
		combo.setRenderer(new EnumComboBoxItemRenderer());
		combo.setSelectedItem(datingType);
		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datingType = (NormalTridasDatingType) combo.getSelectedItem();
			}
		});
		
		return combo;
	}
	
	private void setup(Range startRange) {
		// set title
		setTitle(I18n.getText("menus.tools.redate"));

		// kill me when i'm gone
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// grab data
		range = startRange;

		// dialog is a boxlayout
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(14, 20, 20, 20));
		setContentPane(p);

		p.add(getTopPanel());
		
		p.add(Box.createVerticalStrut(8));
		p.add(new JSeparator(JSeparator.HORIZONTAL));
		p.add(Box.createVerticalStrut(8));

		// name, version, justificaiton panel
		info = new NameVersionJustificationPanel(sample, false, true);
		p.add(info);

		p.add(Box.createVerticalStrut(8));
		p.add(new JSeparator(JSeparator.HORIZONTAL));
		p.add(Box.createVerticalStrut(8));
		
		// cancel, ok
		JButton cancel = Builder.makeButton("general.cancel");
		final JButton ok = Builder.makeButton("general.ok");

		// (listen for cancel, ok)
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isOk = e.getSource() == ok;
				boolean rangeChanged = !sample.getRange().equals(range);

				if (isOk && (rangeChanged || datingType != originalDatingType)) {
					if(!performRedate())
						return;
				}

				dispose();
			}
		};
		cancel.addActionListener(buttonListener);
		ok.addActionListener(buttonListener);

		// in panel
		p.add(Box.createVerticalStrut(14));
		p.add(Layout.buttonLayout(cancel, ok));

		// esc => cancel, return => ok
		OKCancel.addKeyboardDefaults(ok);
	}

	private JPanel getTopPanel() {
		JPanel p = new JPanel();
		
		JLabel lblNewRange = new JLabel();
		startField = new JTextField(6);
		JLabel lblTo = new JLabel();
		endField = new JTextField(6);
		JLabel lblDating = new JLabel();
		cboDatingType = getDatingTypeComboBox();

		lblNewRange.setText(I18n.getText("redate.new_range") + ":");

		lblTo.setText(I18n.getText("general.to"));

		startListener = new StartListener();
		startField.setText(range.getStart().toString());
		startField.getDocument().addDocumentListener(startListener);

		endListener = new EndListener();
		endField.setText(range.getEnd().toString());
		endField.getDocument().addDocumentListener(endListener);

		lblDating.setText(I18n.getText("general.dating") + ":");

		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblNewRange)
								.addComponent(lblDating))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(startField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(lblTo)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(endField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addContainerGap(89, Short.MAX_VALUE))
												.addComponent(cboDatingType, 0, 191, Short.MAX_VALUE)))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblNewRange)
								.addComponent(startField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTo)
								.addComponent(endField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblDating)
										.addComponent(cboDatingType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		return p;
	}
}
