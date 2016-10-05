package is.ru.honn.rutube.process;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.reader.AbstractReader;
import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.reader.ReadHandler;
import is.ru.honn.rutube.reader.ReaderException;
import is.ru.honn.rutube.reader.ReaderFactory;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class UserImportProcess implements ReadHandler{
    private UserService us;
    MessageSource message;

    public void beforeProcess(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("readerApp.xml");
        us = (UserService) applicationContext.getBean("userService");
        message = (MessageSource)applicationContext.getBean("messageSource");
    }

    public void startProcess(){
        ReaderFactory factory = new ReaderFactory();
        Reader reader = factory.getReader("userReader");

        reader.setReadHandler(this);
        try {
            reader.read();
        }
        catch(ReaderException r){
            System.out.println("Read failed! #Failure");
        }
    }

    public void read(int count, Object object){
        User user = (User)object;
        try{
            us.addUser(user);
        }
        catch(ServiceException s){
            System.out.println("User not added");
        }
    }
}
