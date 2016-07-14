package website.davidpolania.android.twitterclient.images.ui;

import java.util.List;

import website.davidpolania.android.twitterclient.images.entities.Image;


/**
 * Created by David Polania.
 */
public interface ImagesView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onImagesError(String error);
    void setImages(List<Image> items);
}
