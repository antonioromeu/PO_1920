package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import java.io.IOException;
import java.io.Serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class LibraryManager {
    
    private Library _library;  // FIXME initialize this attribute
    private String _filename;
    
    public void save(Library library, String file) throws MissingFileAssociationException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(library);
        out.close();
    }

    public void saveAs(String filename) throws MissingFileAssociationException, IOException {
        _filename = filename;
        save(_library, filename);
    }

    public void load(String filename) throws FailedToOpenFileException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Library library = (Library) in.readObject();
        in.close();
    }
    
    public void importFile(String datafile) throws ImportFileException {
        try {
            _library.importFile(datafile);
        } catch (IOException | BadEntrySpecificationException e) {
            throw new ImportFileException(e);
        }
    }

}
