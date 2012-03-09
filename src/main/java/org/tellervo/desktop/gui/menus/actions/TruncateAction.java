package org.tellervo.desktop.gui.menus.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.tellervo.desktop.editor.Editor;
import org.tellervo.desktop.manip.TruncateDialog;
import org.tellervo.desktop.sample.Sample;
import org.tellervo.desktop.ui.Builder;

public class TruncateAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private final Sample sample;
	private final Editor editor;
	
	public TruncateAction(String text, Sample sample, Editor editor, Integer mnemonic) {
        super(text, Builder.getIcon("truncate.png", 22));
        putValue(SHORT_DESCRIPTION, "Truncate the current series");
        putValue(MNEMONIC_KEY, mnemonic);
        this.sample = sample;
        this.editor = editor;
    }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TruncateDialog(sample, editor);
		
	}
	
}