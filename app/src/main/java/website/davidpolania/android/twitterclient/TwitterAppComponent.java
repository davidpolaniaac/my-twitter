package website.davidpolania.android.twitterclient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by David Polania.
 */

@Singleton @Component(modules = {TwitterAppModule.class})
public interface TwitterAppComponent {
}

