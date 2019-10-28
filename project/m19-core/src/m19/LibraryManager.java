package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import java.io.IOException;
import java.io.Serializable;

public class LibraryManager {
  private Library _library;  // FIXME initialize this attribute
  private String _filename;
  // FIXME define other attributes

  // FIXME define contructor(s)
  
  // FIXME define methods

  /**
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void save(Library library, String file) throws MissingFileAssociationException, IOException {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    out.writeObject(library);
    out.close();
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    _filename = filename;
    save();
  }

  /**
   * @param filename
   * @throws FailedToOpenFileException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void load(String filename) throws FailedToOpenFileException, IOException, ClassNotFoundException {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
  
      Library library = (Library) in.readObject();
      in.close();
  }

  /**
   * @param datafile
   * @throws ImportFileException
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }

}
