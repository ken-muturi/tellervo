/*******************************************************************************
 * Copyright (C) 2010 Lucas Madar and Peter Brewer
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
 *     Lucas Madar
 *     Peter Brewer
 ******************************************************************************/
package org.tellervo.desktop.sources;

import javax.swing.Icon;

// in a FavList, right-click, "Show original"

public interface Source {

    // available sources!
    public static final String[] SOURCES = new String[] {
       "org.tellervo.desktop.sources.FolderSource",
       "org.tellervo.desktop.sources.FavoritesSource",
    };

    // like "Trash" or "ITRDB"
    public String getName();

    // a trash can, for example.
    // note: icons are per-class, not per-object.  all sources of the same type
    // should have the same icon (what, and not allow user customization?  eep!)
    public Icon getIcon();

    // do sources have folders?  or just sub-sources?
    // getFolders()?
    // public Element[] getSamples();
    // Element -> SampleRef

    // -- special right-click menus (e.g., empty trash)
    // ---- as Action[]?  ActionListener[], where [i].toString() is name?
    // ---- is Get Info one of these?  or separate showInfo() method?
    // public Action[] getContextMenus();

    // TODO:
    // -- un/serialize -- for prefs
    // ---- (i'll need a factory, and maybe a predicate here)

    // -- dnd
    // ---- accept drop (sample[])
    public boolean canAcceptDrop();
    public boolean canBeDragged();
    public boolean canElementsBeDragged();

    // WRITE: instances
    // -- FolderSource
    // -- FTPSource (default: FTPSource.ITRDBSource)
    // -- RecentSource (25 most recent files)
    // -- TrashSource
    // -- FavoritesSource (just a list of files)
    // FUTURE:
    // -- SmartSource (a list auto-generated by tellervo.search)
    // -- DatabaseSource (JDBC)

    /*
      DETAILS:
      -- any Source must be able to do everything a filesystem does.
      -- create/delete, move/copy, rename, load/save, mkdir, list dir, possibly drag/drop
      -- might need a File-like object for dealing with file-like things.
      ---- or will SampleRef take care of all that?

      ...
      -- a Source consists of Folders, and SampleRefs (right?)
    */

    /*
      what's a SampleRef?

      class SampleRef {
        SampleRef(filename);
	Sample get() throws IOE?;
	// need get-metadata-only!
      }
    */

    /*
      sources will need to be able to say "my contents have changed" --
      this won't require anything special in Source, will it?
    */

    /*
      other things:
      -- can-rename?
      -- rename!
      -- can remove?
      -- tooltip(?)
    */
}
