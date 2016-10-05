package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class ReaderFactory {

    /**
     * Creates a new Reader of a given type, either userReader or videoReader,
     * by comparing the given string to the reader.xml file
     * @param reader the type of reader to be used
     * @return a new reader of specified type
     */
    public Reader getReader(String reader){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("reader.xml");
        Reader myReader = (Reader) applicationContext.getBean(reader);
        return myReader;
    }
}
