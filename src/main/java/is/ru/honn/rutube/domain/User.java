package is.ru.honn.rutube.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class User {
    int userId;
    String firstName;
    String lastName;
    String email;
    String displayName;
    LocalDate birthDate;
    List<Video> videos;

    /**
     * Constructor for User.
     * @param userId        The ID of the user.
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param email         The e-mail of the user.
     * @param displayName   The username of the user.
     * @param birthDate     The birth date of the user.
     */
    public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.birthDate = LocalDate.parse(birthDate);
        videos = new ArrayList<>();
    }

    /**
     * Creates a list of the users videos.
     * @param videos The list of videos.
     */
    public void setVideos(List<Video> videos){
        this.videos = videos;
    }

    /**
     * Gets the ID of the user.
     * @return The ID of the user.
     */
    public int getUserId(){
        return this.userId;
    }

    /**
     * Gets a list of the users videos.
     * @return A list of the users videos.
     */
    public List<Video> getVideos(){
        return videos;
    }

    /**
     * Returns the display name of user
     * @return displayName
     */
    public String getDisplayName() { return displayName; }

    /**
     * Returns the first name of user
     * @return firstName
     */
    public String getFirstName() { return firstName; }

    /**
     * Returns the last name of user
     * @return lastName
     */
    public String getLastName() { return lastName; }

    /**
     * Returns the email of user
     * @return email
     */
    public String getEmail() { return email; }

    /**
     * Returns date of birth of user
     * @return birthDate
     */
    public LocalDate getBirthDate() { return birthDate; }
}
