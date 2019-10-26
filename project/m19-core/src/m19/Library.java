package m19;

import java.io.IOException;
import java.io.Serializable;

import m19.LibraryManager;

import m19.exceptions.BadEntrySpecificationException;
//import m19.exceptions.BadEntryException;
//import m19.exceptions.BadTimeSpecificationException;
//import m19.exceptions.ImportFileException;
//import mmt.exceptions.NoSuchItineraryChoiceException;
//import mmt.exceptions.InvalidPassengerNameException;
//import mmt.exceptions.NoSuchDepartureException;
//import m19.exceptions.NoSuchPassengerIdException;
//import m19.exceptions.NoSuchServiceIdException;
//import m19.exceptions.NoSuchStationNameException;
//import m19.exceptions.NonUniquePassengerNameException;
// FIXME import system types
// FIXME import project (core) types

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  // FIXME define attributes

  // FIXME define contructor(s)

  // FIXME define methods

  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
  }

}
