package com.lecture.resource;

import com.lecture.db.DatabaseClass;
import com.lecture.model.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibraryResource {
    private Map<Long, Library> libraries = DatabaseClass.getLibraries();
    public List<Library> getAllLibraries() {
        return new ArrayList<Library>(libraries.values());
    }
    public Library getLibrary(long id) {
        Library library = libraries.get(id);
        return library;
    }
    public Library addLibrary(Library library) {
        library.setId(libraries.size() + 1);
        libraries.put(library.getId(), library);
        return library;
    }
    public Library updateLibrary(Library library) {
        if(library.getId() <= 0) {
            return null;
        }
        libraries.put(library.getId(), library);
        return library;
    }
    public Library removeLibrary(long id) {
        return libraries.remove(id);
    }


}
