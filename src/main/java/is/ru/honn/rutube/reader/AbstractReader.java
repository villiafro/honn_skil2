package is.ru.honn.rutube.reader;

import org.json.simple.JSONObject;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public abstract class AbstractReader<T> implements Reader{
    @Override
    public Object read() {
        return null;
    }

    @Override
    public void setURI(String URI) {

    }

    @Override
    public void setReadHandler(ReadHandler readHandler) {

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
