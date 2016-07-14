package website.davidpolania.android.twitterclient.hashtags.di;

import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.davidpolania.android.twitterclient.api.CustomTwitterApiClient;
import website.davidpolania.android.twitterclient.hashtags.entities.Hashtag;
import website.davidpolania.android.twitterclient.hashtags.HashtagsInteractor;
import website.davidpolania.android.twitterclient.hashtags.HashtagsInteractorImpl;
import website.davidpolania.android.twitterclient.hashtags.HashtagsPresenter;
import website.davidpolania.android.twitterclient.hashtags.HashtagsPresenterImpl;
import website.davidpolania.android.twitterclient.hashtags.HashtagsRepository;
import website.davidpolania.android.twitterclient.hashtags.HashtagsRepositoryImpl;
import website.davidpolania.android.twitterclient.hashtags.ui.HashtagsView;
import website.davidpolania.android.twitterclient.hashtags.ui.OnItemClickListener;
import website.davidpolania.android.twitterclient.hashtags.adapters.HashtagsAdapter;
import website.davidpolania.android.twitterclient.lib.EventBus;

/**
 * Created by David Polania.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> provideItems() {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    HashtagsAdapter provideAdapter(Context context, List<Hashtag> items, OnItemClickListener clickListener) {
        return new HashtagsAdapter(context, items, clickListener);
    }

    @Provides
    @Singleton
    HashtagsView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsPresenter provideHashtagsPresenter(HashtagsView view, HashtagsInteractor interactor, EventBus eventBus) {
        return new HashtagsPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagsInteractor provideHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository provideHashtagsRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(client, eventBus);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
