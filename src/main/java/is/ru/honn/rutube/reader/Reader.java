package is.ru.honn.rutube.reader;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public interface Reader extends ReadHandler{
    public Object read();
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
