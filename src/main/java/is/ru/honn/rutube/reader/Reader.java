package is.ru.honn.rutube.reader;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public interface Reader{

    /**
     * Reads the file from a given uri using a specific readHandler and parses it for the user
     * @return the parsed file from the requested uri
     * @throws ReaderException if either the uri or readHandler has not been set
     */
    public Object read() throws ReaderException;

    /**
     *
     * Walks through the json String and maps it to lists of users, which all contain 1 or more videos.
     *
     * @param content Json string with list of users, see http://mockaroo.com/f13b8200/download?count=1&key=e79a3650
     * @return Object which is a list of users.
     */
    public Object parse(String content);

    /**
     * Sets the uri for the given reader
     * @param URI the uri to be set
     */
    public void setURI(String URI);

    /**
     * Sets the readHandler for the given reader
     * @param readHandler the readHandler to be set
     */
    public void setReadHandler(ReadHandler readHandler);
}
