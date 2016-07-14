package website.davidpolania.android.twitterclient.images.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.davidpolania.android.twitterclient.api.CustomTwitterApiClient;
import website.davidpolania.android.twitterclient.images.ImagesInteractor;
import website.davidpolania.android.twitterclient.images.ImagesInteractorImpl;
import website.davidpolania.android.twitterclient.images.ImagesPresenter;
import website.davidpolania.android.twitterclient.images.ImagesPresenterImpl;
import website.davidpolania.android.twitterclient.images.ImagesRepository;
import website.davidpolania.android.twitterclient.images.ImagesRepositoryImpl;
import website.davidpolania.android.twitterclient.images.adapters.ImagesAdapter;
import website.davidpolania.android.twitterclient.images.entities.Image;
import website.davidpolania.android.twitterclient.images.ui.ImagesView;
import website.davidpolania.android.twitterclient.images.ui.OnItemClickListener;
import website.davidpolania.android.twitterclient.lib.EventBus;
import website.davidpolania.android.twitterclient.lib.ImageLoader;

/**
 * Created by David Polania.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Image> provideItems() {
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    ImagesAdapter provideAdapter(List<Image> items, OnItemClickListener clickListener, ImageLoader imageLoader) {
        return new ImagesAdapter(items, clickListener, imageLoader);
    }

    @Provides
    @Singleton
    ImagesView provideImagesView() {
        return this.view;
    }

    @Provides
    @Singleton
    ImagesPresenter provideImagesPresenter(ImagesView view, ImagesInteractor interactor, EventBus eventBus) {
        return new ImagesPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    ImagesInteractor provideImagesInteractor(ImagesRepository repository) {
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository provideImagesRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new ImagesRepositoryImpl(client, eventBus);
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
