package org.tellervo.desktop.editor.view;

import java.util.ArrayList;

import org.tellervo.desktop.editor.AbstractEditor;
import org.tellervo.desktop.prefs.PrefsEvent;
import org.tellervo.desktop.sample.Sample;
import org.tellervo.desktop.sample.SampleEvent;

public class FullEditor extends AbstractEditor {

	private static final long serialVersionUID = 1L;

	public FullEditor()
	{
		super();
		this.setVisible(true);

	}
	
	public FullEditor(Sample sample)
	{
		super(sample);
		
		this.setVisible(true);
	}
	
	public FullEditor(ArrayList<Sample> samples)
	{
		super(samples);
		this.setVisible(true);

	}
	
	@Override
	public boolean isSaved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNameChangeable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFilename(String fn) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSavedDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prefChanged(PrefsEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleRedated(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleDataChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleMetadataChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleElementsChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleDisplayUnitsChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sampleDisplayCalendarChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void measurementVariableChanged(SampleEvent e) {
		// TODO Auto-generated method stub

	}

}
