package website.davidpolania.android.twitterclient.images;

import website.davidpolania.android.twitterclient.images.events.ImagesEvent;

/**
 * Created by David Polania.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
