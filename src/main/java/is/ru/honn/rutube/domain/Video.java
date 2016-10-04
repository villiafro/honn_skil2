package is.ru.honn.rutube.domain;

import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class Video {
    int videoId;
    String title;
    String description;
    String source;
    String videoType;
    List<String> tags;

    public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.source = source;
        this.videoType = videoType;
        this.tags = tags;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public int getVideoId(){
        return videoId;
    }
}