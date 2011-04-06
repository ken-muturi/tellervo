package edu.cornell.dendro.corina.util.labels.ui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import org.tridas.schema.TridasElement;
import org.tridas.schema.TridasGenericField;
import org.tridas.schema.TridasSample;

import edu.cornell.dendro.corina.schema.WSIBox;
import edu.cornell.dendro.corina.tridasv2.GenericFieldUtils;

public class TridasListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 5452092569212454680L;

	public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if(value instanceof WSIBox) {
            value = ((WSIBox) value).getTitle();
        }
        
        if(value instanceof TridasSample){
        	TridasSample s = (TridasSample) value;
        	TridasGenericField f = GenericFieldUtils.findField(s, "corina.internal.labcodeText");
                	
        	value = (f != null) ? f.getValue() : s.getTitle();
        }
        
        if(value instanceof TridasElement){
        	TridasElement e = (TridasElement) value;
        	TridasGenericField f = GenericFieldUtils.findField(e, "corina.internal.labcodeText");
                	
        	value = (f != null) ? f.getValue() : e.getTitle();
        } 
        
        /*else
        {
        	System.out.println("The object type "+ value.getClass().toString()+" is unsupported in TridasListCellRenderer");
        }*/


        return super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
    } 
	
	
}
