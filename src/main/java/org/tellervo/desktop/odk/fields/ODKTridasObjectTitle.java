package org.tellervo.desktop.odk.fields;

import org.tellervo.desktop.tridasv2.doc.Documentation;
import org.tridas.interfaces.ITridas;
import org.tridas.schema.TridasObject;

public class ODKTridasObjectTitle extends AbstractODKField {
	
	public ODKTridasObjectTitle()
	{
		super(ODKDataType.STRING, "tridas_object_title", "Object title", Documentation.getDocumentation("object.title"), null);
	}
	
	@Override
	public Boolean isFieldRequired() {
		return true;
	}

	@Override
	public Class<? extends ITridas> getTridasClass() {
		return TridasObject.class;
	}
}
