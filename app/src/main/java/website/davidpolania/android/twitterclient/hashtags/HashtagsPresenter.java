package website.davidpolania.android.twitterclient.hashtags;

import website.davidpolania.android.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by David Polania.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
