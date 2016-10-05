package is.ru.honn.rutube.reader;

import org.json.simple.JSONObject;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public abstract class AbstractReader implements Reader{
    String uri;
    ClientRequest clientRequest = new ClientRequest();
    ReadHandler myReadHandler;

    /**
     * Reads the file from a given uri using a specific readHandler and parses it for the user
     * @return the parsed file from the requested uri
     * @throws ReaderException if either the uri or readHandler has not been set
     */
    @Override
    public Object read() throws ReaderException {
        if(uri == null){
            throw new ReaderException("URI Not Found");
        }
        if(myReadHandler == null){
            throw new ReaderException("ReadHandler Not Found");
        }
        return this.parse(clientRequest.getRequest(uri));
    }

    /**
     * Sets the uri for the given reader
     * @param URI the uri to be set
     */
    @Override
    public void setURI(String URI) {
        this.uri = URI;
    }

    /**
     * Sets the readHandler for the given reader
     * @param readHandler the readHandler to be set
     */
    @Override
    public void setReadHandler(ReadHandler readHandler) {
        this.myReadHandler = readHandler;
    }

    /**
     *
     * @param jParent Json parent containing an integer field.
     * @param name name of the integer field
     * @return int value of the json int in the jParent object.
     */
    protected static int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }
}
