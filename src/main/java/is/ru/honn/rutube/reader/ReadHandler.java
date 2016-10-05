package is.ru.honn.rutube.reader;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public interface ReadHandler {

    /**
     * Handles the reading of objects
     * @param count number of objects to read
     * @param object list of object to be read
     */
    public void read(int count, Object object);
}
