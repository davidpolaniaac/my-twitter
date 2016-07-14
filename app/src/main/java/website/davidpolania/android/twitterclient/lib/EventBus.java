package website.davidpolania.android.twitterclient.lib;

/**
 * Created by David Polania.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
