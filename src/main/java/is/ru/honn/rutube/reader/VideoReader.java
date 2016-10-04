package is.ru.honn.rutube.reader;

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
public class VideoReader extends AbstractReader{

    public VideoReader(){}

    /**
     * Walks through a json array of videos and maps it to a object which is a list of videos.
     *
     * @param content Should be a json Array of videos. see http://mockaroo.com/f13b8200/download?count=1&key=e79a3650
     * @return Object which is a list of videos.
     */

    public Object parse(String content){

        JSONArray jVideos = (JSONArray) JSONValue.parse(content);
        List<Video> videos = new ArrayList<>();

        jVideos.stream().forEach(jVideo -> {
            JSONObject jVid = (JSONObject) jVideo;
            int videoId = AbstractReader.getInt(jVid, "videoId");

            Video video = new Video(
                    videoId,
                    (String) jVid.get("title"),
                    (String) jVid.get("description"),
                    (String) jVid.get("src"),
                    (String) jVid.get("type"),
                    (List<String>) jVid.get("tags")
            );
            videos.add(video);
        });
        myReadHandler.read(videos.size(), videos);
        return videos;
    }

    /**
     *
     * @param jParent Json parent containing an integer field.
     * @param name name of the integer field
     * @return int value of the json int in the jParent object.
     */
    protected static int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }
}