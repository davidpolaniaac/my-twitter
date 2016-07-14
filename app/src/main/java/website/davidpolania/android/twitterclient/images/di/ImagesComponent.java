package website.davidpolania.android.twitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import website.davidpolania.android.twitterclient.images.ui.ImagesFragment;
import website.davidpolania.android.twitterclient.lib.di.LibsModule;

/**
 * Created by David Polania.
 */

@Singleton @Component(modules = {ImagesModule.class, LibsModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    //ImagesPresenter getPresenter();
}

