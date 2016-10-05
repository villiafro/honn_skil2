package is.ru.honn.rutube.service;

/**
 * Created by Hoskuldur on 01/10/16.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 01/10/2016
 */
public class ServiceException extends Exception {
    public ServiceException()
    {
        super();
    }

    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
