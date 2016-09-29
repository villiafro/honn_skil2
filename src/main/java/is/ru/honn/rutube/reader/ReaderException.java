package is.ru.honn.rutube.reader;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
 * @Date 26/09/2016
 */
public class ReaderException extends Exception
{
    public ReaderException()
    {
        super();
    }

    public ReaderException(String message)
    {
        super(message);
    }

    public ReaderException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
