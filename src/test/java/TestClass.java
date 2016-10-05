import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import is.ru.honn.rutube.reader.ClientRequest;
import is.ru.honn.rutube.reader.UserReader;
import is.ru.honn.rutube.reader.VideoReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class TestClass extends Tests{
    public static void main(String args[]){
        VideoReader videoReader = new VideoReader();
        UserReader userReader = new UserReader(videoReader);
        ClientRequest clientRequest = new ClientRequest();
        String content = clientRequest.getRequest("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
        List<User> users = (List<User>)userReader.parse(content);
        for(int i = 0; i< users.size();i++){
            System.out.println("User: " + users.get(i).getDisplayName());
            List<Video> videos = users.get(i).getVideos();
            System.out.println("    Videos: ");
            for(int j = 0; j < videos.size(); j++){
                System.out.println("        " + videos.get(j).getTitle());
            }
        }
    }


}
