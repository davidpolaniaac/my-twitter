package website.davidpolania.android.twitterclient.hashtags;

/**
 * Created by David Polania.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository hashtagsRepository;

    public HashtagsInteractorImpl(HashtagsRepository hashtagsRepository) {
        this.hashtagsRepository = hashtagsRepository;
    }

    @Override
    public void getHashtagItemsList() {
        hashtagsRepository.getHashtags();
    }
}
