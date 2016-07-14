package website.davidpolania.android.twitterclient.hashtags.di;

import javax.inject.Singleton;

import dagger.Component;
import website.davidpolania.android.twitterclient.TwitterAppModule;
import website.davidpolania.android.twitterclient.hashtags.ui.HashtagsFragment;
import website.davidpolania.android.twitterclient.lib.di.LibsModule;

/**
 * Created by David Polania.
 */

@Singleton @Component(modules = {HashtagsModule.class, LibsModule.class, TwitterAppModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}

