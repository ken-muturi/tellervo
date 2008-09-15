package edu.cornell.dendro.corina.sample;

public enum SampleType {
	UNKNOWN, // being imported, perhaps?
	DIRECT,
	SUM,
	INDEX,
	CLEAN,
	REDATE,
	LEGACYCLEAN;
	
	public String toString() {
		switch(this) {
		case UNKNOWN:
			return "Unknown";
		case DIRECT:
			return "Raw";
		case SUM:
			return "Sum";
		case INDEX:
			return "Index";
		case CLEAN:
			return "Clean";
		case REDATE:
			return "Redate";
		case LEGACYCLEAN:
			return "Legacy";
		default:
			return "";
		}
	}

	public static SampleType fromString(String name) {
		try {
			return valueOf(name.toUpperCase());
		} catch (IllegalArgumentException ie) {
			return null;
		}
	}
}
