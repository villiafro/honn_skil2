import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.reader.ClientRequest;
import is.ru.honn.rutube.reader.UserReader;
import is.ru.honn.rutube.reader.VideoReader;

import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson
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
            System.out.println(users.get(i));
        }
    }
}
