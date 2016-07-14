package website.davidpolania.android.twitterclient.images;

import javax.inject.Inject;

/**
 * Created by David Polania.
 */
public class ImagesInteractorImpl implements ImagesInteractor {
    private final ImagesRepository imagesRepository;

    @Inject
    public ImagesInteractorImpl(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Override
    public void getImageItemsList() {
        this.imagesRepository.getImages();

    }
}
