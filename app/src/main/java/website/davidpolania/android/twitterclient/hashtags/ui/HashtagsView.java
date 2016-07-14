package website.davidpolania.android.twitterclient.hashtags.ui;

import java.util.List;

import website.davidpolania.android.twitterclient.hashtags.entities.Hashtag;

/**
 * Created by David Polania.
 */
public interface HashtagsView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
