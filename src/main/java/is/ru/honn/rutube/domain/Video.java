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

    /**
     * Constructor for Video.
     * @param videoId       The ID of the video.
     * @param title         The title of the video.
     * @param description   The description of the video.
     * @param source        The link of the video.
     * @param videoType     The type of the video.
     * @param tags          A list of tags for the video.
     */
    public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.source = source;
        this.videoType = videoType;
        this.tags = tags;
    }

    /**
     * Adds a tag to the video.
     * @param tag The tag that should be added to the video.
     */
    public void addTag(String tag){
        tags.add(tag);
    }

    /**
     * Gets the ID of the video.
     * @return The ID of the video.
     */
    public int getVideoId(){
        return videoId;
    }
}