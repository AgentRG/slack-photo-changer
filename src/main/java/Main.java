import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.request.users.UsersSetPhotoRequest;
import com.github.seratch.jslack.api.methods.response.users.UsersSetPhotoResponse;

import java.io.File;

public class Main {

    /**
     * Uses Slack API to set the profile picture for your Slack profile
     * Required to be JPEG, GIF or PNG
     * Minimum resolution is 512x512
     * Maximum resolution is 1024x1024
     * @param token the legacy token for your account
     * @param image the photo you would like to upload
     * @see File
     */

    public static void setPhoto(String token, File image) throws Exception {
        Slack slack = Slack.getInstance();
        UsersSetPhotoRequest request = UsersSetPhotoRequest.
                builder()
                .image(image)
                .build();
        UsersSetPhotoResponse response = slack.methods(token).usersSetPhoto(request);
        slack.close();
    }

    public static void main(String[] args) throws Exception {
        setPhoto("foo", new File("bar"));
    }
}
