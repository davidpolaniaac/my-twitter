package website.davidpolania.android.twitterclient.hashtags;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import website.davidpolania.android.twitterclient.hashtags.entities.Hashtag;
import website.davidpolania.android.twitterclient.hashtags.events.HashtagsEvent;
import website.davidpolania.android.twitterclient.hashtags.ui.HashtagsView;
import website.davidpolania.android.twitterclient.lib.EventBus;

/**
 * Created by David Polania.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private EventBus eventBus;
    private HashtagsView hashtagsView;
    private HashtagsInteractor hashtagsInteractor;

    public HashtagsPresenterImpl(HashtagsView hashtagsView, HashtagsInteractor hashtagsInteractor, EventBus eventBus) {
        this.eventBus = eventBus;
        this.hashtagsView = hashtagsView;
        this.hashtagsInteractor = hashtagsInteractor;
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.hashtagsView = null;
    }

    @Override
    public void getHashtagTweets(){
        if (this.hashtagsView != null){
            hashtagsView.hideList();
            hashtagsView.showProgress();
        }
        this.hashtagsInteractor.getHashtagItemsList();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (this.hashtagsView != null) {
            hashtagsView.showList();
            hashtagsView.hideProgress();
            if (errorMsg != null) {
                this.hashtagsView.onHashtagsError(errorMsg);
            } else {
                List<Hashtag> items = event.getHashtags();
                if (items != null && !items.isEmpty()) {
                    this.hashtagsView.setHashtags(items);
                }
            }
        }
    }
}
