package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class ReaderFactory {
    public Reader getReader(String reader){
        /*VideoReader videoReader = new VideoReader();
        UserReader userReader = new UserReader(videoReader);
        if(reader == "videoReader"){
            return videoReader;
        }
        if(reader == "userReader"){
            return userReader;
        }
        throw new ReaderException("Not a valid reader!");*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("reader.xml");

        Reader myReader = (Reader) applicationContext.getBean(reader);
        return myReader;
    }
}
