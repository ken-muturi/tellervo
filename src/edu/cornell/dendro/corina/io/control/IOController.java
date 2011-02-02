package edu.cornell.dendro.corina.io.control;

import com.dmurph.mvc.control.FrontController;

import edu.cornell.dendro.corina.io.command.ConvertCommand;
import edu.cornell.dendro.corina.io.command.EntitySaveCommand;
import edu.cornell.dendro.corina.io.command.EntitySwappedCommand;
import edu.cornell.dendro.corina.io.command.FileSelectedCommand;
import edu.cornell.dendro.corina.io.command.MergeEntitiesCommand;
import edu.cornell.dendro.corina.io.command.ExportCommand;
import edu.cornell.dendro.corina.io.command.NodeSelectedCommand;
import edu.cornell.dendro.corina.io.command.OpenExportCommand;
import edu.cornell.dendro.corina.io.command.SaveCommand;


public class IOController extends FrontController {

    public static final String ENTITY_SELECTED = "IMPORT_ENTITY_SELECTED";
    public static final String FILE_SELECTED = "IMPORT_FILE_SELECTED";
    public static final String ENTITY_SWAPPED = "IMPORT_ENTITY_SWAPPED";
    public static final String MERGE_ENTITIES = "IMPORT_MERGE_ENTITIES";

    public static final String ENTITY_SAVE = "IMPORT_ENTITY_SAVE";
    
    public static final String CONVERT_PROJECTS = "IO_CONVERT_PROJECTS";
    public static final String EXPORT = "IO_EXPORT";
    
    public static final String OPEN_EXPORT_WINDOW = "IO_OPEN_EXPORT";
    
    public static final String SAVE = "IO_SAVE";

    public IOController()
    {
    	registerCommand(ENTITY_SELECTED, NodeSelectedCommand.class);
    	registerCommand(ENTITY_SWAPPED, EntitySwappedCommand.class);
    	registerCommand(FILE_SELECTED, FileSelectedCommand.class);
    	registerCommand(MERGE_ENTITIES, MergeEntitiesCommand.class);
    	registerCommand(ENTITY_SAVE, EntitySaveCommand.class);
    	
    	registerCommand(CONVERT_PROJECTS, ConvertCommand.class);
    	
    	registerCommand(EXPORT, ExportCommand.class);
    	
    	registerCommand(OPEN_EXPORT_WINDOW, OpenExportCommand.class);
    	
    	registerCommand(SAVE, SaveCommand.class);
    }

	
}
