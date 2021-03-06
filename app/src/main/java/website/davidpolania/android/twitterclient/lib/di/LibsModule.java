package website.davidpolania.android.twitterclient.lib.di;

import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.davidpolania.android.twitterclient.lib.EventBus;
import website.davidpolania.android.twitterclient.lib.GlideImageLoader;
import website.davidpolania.android.twitterclient.lib.GreenRobotEventBus;
import website.davidpolania.android.twitterclient.lib.ImageLoader;

/**
 * Created by David Polania.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Fragment fragment) {
        return new GlideImageLoader(fragment);
    }

    @Provides
    @Singleton
    Fragment provideImageLoaderFragment() {
        return this.fragment;
    }
}
