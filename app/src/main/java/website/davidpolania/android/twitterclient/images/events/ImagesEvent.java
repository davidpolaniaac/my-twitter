package website.davidpolania.android.twitterclient.images.events;

import java.util.List;

import website.davidpolania.android.twitterclient.images.entities.Image;

/**
 * Created by David Polania.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
