package is.ru.honn.rutube.reader;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class UserReader extends AbstractReader{

    /**
     * An instance of the videoReader for a given userReader
     */
    private VideoReader videoReader;

    /**
     * Constructor for UserReader with an instance of videoReader
     * @param videoReader instance of videoReader
     */
    public UserReader(VideoReader videoReader){
        this.videoReader = videoReader;
    }

    /**
     * Needs a new instance of ReadHandler to run the parser correctly
     */
    private ReadHandler myReadHandler = new ReadHandler() {
        @Override
        public void read(int count, Object object) {

        }
    };

    /**
     *
     * Walks through the json String and maps it to lists of users, which all contain 1 or more videos.
     *
     * @param content Json string with list of users, see http://mockaroo.com/f13b8200/download?count=1&key=e79a3650
     * @return Object which is a list of users.
     */
    public Object parse(String content) {

        //root object
        JSONObject jsonObject = (JSONObject) JSONValue.parse(content);

        // Get apiResults, this is an array so get the first (and only) item
        JSONArray apiResults = (JSONArray) jsonObject.get("apiResults");
        JSONObject jTmp = (JSONObject) apiResults.get(0);

        JSONArray jUsers = (JSONArray) jTmp.get("users");
        List<User> users = new ArrayList<>();

        jUsers.stream().forEach(jUser1 -> {
            JSONObject jUser = (JSONObject) jUser1;
            int userId = AbstractReader.getInt(jUser, "userId");
            User user = new User(
                    userId,
                    (String) jUser.get("firstName"),
                    (String) jUser.get("lastName"),
                    (String) jUser.get("email"),
                    (String) jUser.get("displayName"),
                    (String) jUser.get("birthdate"));

            JSONArray jVideos = (JSONArray) jUser.get("videos");
            Object jvids = videoReader.parse(jVideos.toString());
            List<Video> videos = (List<Video>) jvids;
            user.setVideos(videos);

            users.add(user);
        });
        myReadHandler.read(users.size(), users);
        return users;
    }
}
