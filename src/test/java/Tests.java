import static org.junit.Assert.assertEquals;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.reader.ReaderException;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.UserServiceStub;
import is.ru.honn.rutube.service.VideoServiceStub;
import org.junit.Test;

import javax.management.ServiceNotFoundException;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class Tests {
    public class TestUserService{
        @Test
        public void AddingUserShouldBeSuccessful() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            try{
                //User should be added
                assertEquals(uss.addUser(u), 0);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }
        }
        @Test
        public void AddingUserShouldFail() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            User u2 = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            try{
                //User should be added
                assertEquals(uss.addUser(u),0);
                //User should already exist
                assertEquals(uss.addUser(u2),-1);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }
        }
        @Test
        public void ShouldReturnAnExistingUser(){
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            try{
                //User should be found
                assertEquals(uss.getUserById(u.getUserId()).getUserId(), 0);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }

            //Return existing user in list
            assertEquals(uss.getUsers().get(0),u);
        }
        @Test
        public void GettingUserThatDoesNotExist(){
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            try{
                //User should be found
                assertEquals(uss.getUserById(u.getUserId()).getUserId(), 1);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }

            //Return null for non existing user
            assertEquals(uss.getUsers().get(1),null);
        }
    }
    public class TestVideoService{
        @Test
        public void AddingVideoShouldBeSuccessful() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            try{
                //Video should be added
                assertEquals(vss.addVideo(uss.getUsers(),v,u.getUserId()),0);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }
        }
        @Test
        public void AddingVideoShouldFail() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            try{
                //Video should be added
                assertEquals(vss.addVideo(uss.getUsers(),v,1),-1);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }
        }
        @Test
        public void GettingVideoThatDoesNotExist(){
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "13.Nóv");
            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            try{
                //Video should be added
                assertEquals(vss.addVideo(uss.getUsers(),v,u.getUserId()),0);
            }
            catch (ServiceException x){
                System.out.println("Service not found");
            }
            //Video should not be returned
            assertEquals(vss.getVideo(-1),null);

        }
    }
    public class TestReader{
        @Test
        public void FactoryShouldReadXMLCorrectly(){

        }
        @Test
        public void ShouldThrowExceptionIfURLIncorrect() throws ReaderException{

        }
        @Test
        public void ShouldThrowExceptionIfHandlerNotSet() throws ReaderException{

        }
        @Test
        public void NumberOfLinesShouldMatchFile(){

        }
    }
    public class TestObserver{
        @Test
        public void ObserverPatternShouldWorkCorrectly(){

        }
    }
}
