import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import is.ru.honn.rutube.reader.*;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.UserServiceStub;
import is.ru.honn.rutube.service.VideoServiceStub;
import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class Tests {
    public static void main(String args[]) throws Exception {
        TestUserService tus = new TestUserService();
        tus.AddingUserShouldBeSuccessful();
        tus.AddingUserShouldFail();
        tus.ShouldReturnAnExistingUser();
        tus.GettingUserThatDoesNotExist();

        TestVideoService tvs = new TestVideoService();
        tvs.AddingVideoShouldBeSuccessful();
        tvs.AddingVideoShouldFail();
        tvs.GettingVideoThatDoesNotExist();

        TestReader tr = new TestReader();
        tr.FactoryShouldReadXMLCorrectly();
        tr.ShouldThrowExceptionIfURLIncorrect();
        tr.ShouldThrowExceptionIfHandlerNotSet();
    }

    public static class TestUserService{
        @Test
        public void AddingUserShouldBeSuccessful() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try{
                //User should be added
                assertEquals(uss.addUser(u), 0);
            }
            catch (ServiceException x){
                System.out.println("Service not found - AddingUserShouldBeSuccessful()");
            }
        }

        @Test(expected = ServiceException.class)
        public void AddingUserShouldFail() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            User u2 = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try{
                //User should be added
                assertEquals(uss.addUser(u),0);
                uss.addUser(u2);
            }
            catch (ServiceException x){
                System.out.println("Service not found - AddingUserShouldFail()");
            }
        }
        @Test
        public void ShouldReturnAnExistingUser(){
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try{
                //User should be added
                assertEquals(uss.addUser(u),0);
            }
            catch (ServiceException x){
                System.out.println("Service not found - ShouldReturnAnExistingUser()");
            }

            //Return existing user in list
            assertEquals(uss.getUsers().get(0),u);
        }
        @Test
        public void GettingUserThatDoesNotExist(){
            UserServiceStub uss = new UserServiceStub();

            //Return null for non existing user
            assertEquals(uss.getUserById(0),null);
        }
    }

    public static class TestVideoService{
        @Test
        public void AddingVideoShouldBeSuccessful() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try {
                uss.addUser(u);
            }
            catch (ServiceException x){
                System.out.println("Service not found - Adding user");
            }

            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            vss.setUserServiceStub(uss);
            try{
                //Video should be added
                assertEquals(vss.addVideo(uss.getUsers(),v,u.getUserId()),0);
            }
            catch (ServiceException x){
                System.out.println("Service not found - AddingVideoShouldBeSuccessful()");
            }
        }
        @Test(expected = ServiceException.class)
        public void AddingVideoShouldFail() throws Exception{
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try {
                uss.addUser(u);
            }
            catch (ServiceException x){
                System.out.println("Service not found - Adding user");
            }

            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            vss.setUserServiceStub(uss);
            try{
                //Video should be added
                vss.addVideo(uss.getUsers(),v,1);
            }
            catch (ServiceException x){
                System.out.println("Service not found - AddingVideoShouldFail()");
            }
        }
        @Test
        public void GettingVideoThatDoesNotExist(){
            UserServiceStub uss = new UserServiceStub();
            User u = new User(0, "Vilhjalmur", "hannesson", "vilhjalmur@gmail.com", "Villson", "2005-11-12");
            try {
                uss.addUser(u);
            }
            catch (ServiceException x){
                    System.out.println("Service not found - Adding user");
            }

            VideoServiceStub vss = new VideoServiceStub();
            Video v = new Video(0, "Mega Song", "Super good song", "Reykjavik", "mp4", null);
            vss.setUserServiceStub(uss);

            //Video should not be returned
            assertEquals(vss.getVideo(0),null);

        }
    }
    public static class TestReader{
        @Test
        public void FactoryShouldReadXMLCorrectly(){
            /*VideoReader videoreader = new VideoReader();
            UserReader userreader = new UserReader(videoreader);
            ReaderFactory readerfactory = new ReaderFactory();

            assertEquals(readerfactory.getReader("userReader"), userreader);*/
        }

        @Test(expected = ReaderException.class)
        public void ShouldThrowExceptionIfURLIncorrect() throws ReaderException{
            AbstractReader abstractReader = new AbstractReader() {
                @Override
                public Object parse(String content) {
                    return null;
                }
            };

            try{
                abstractReader.read();
            }
            catch (ReaderException x){
                System.out.println("URI Not Found");
            }

        }
        @Test
        public void ShouldThrowExceptionIfHandlerNotSet() throws ReaderException{
            AbstractReader abstractReader = new AbstractReader() {
                @Override
                public Object parse(String content) {
                    return null;
                }
            };

            abstractReader.setURI("/niggas/in/paris");
            try{
                abstractReader.read();
            }
            catch (ReaderException x){
                System.out.println("ReadHandler Not Found");
            }
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
