package website.davidpolania.android.twitterclient;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David Polania.
 */
@Module
public class TwitterAppModule {
    Context context;

    public TwitterAppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }
}
