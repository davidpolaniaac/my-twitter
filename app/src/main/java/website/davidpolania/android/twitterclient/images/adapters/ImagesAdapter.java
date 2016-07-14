package website.davidpolania.android.twitterclient.images.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import website.davidpolania.android.twitterclient.R;
import website.davidpolania.android.twitterclient.images.entities.Image;
import website.davidpolania.android.twitterclient.images.ui.OnItemClickListener;
import website.davidpolania.android.twitterclient.lib.ImageLoader;

/**
 * Created by David Polania.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private List<Image> items;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;

    public ImagesAdapter(List<Image> items,
                         OnItemClickListener clickListener,
                         ImageLoader imageLoader) {
        this.items = items;
        this.clickListener = clickListener;
        this.imageLoader = imageLoader;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image tweet = items.get(position);
        holder.setClickListener(tweet, clickListener);
        holder.txtTweet.setText(tweet.getTweetText());
        holder.txtFavs.setText(String.valueOf(tweet.getFavoriteCount()));
        imageLoader.load(holder.imgMedia, tweet.getImageURL());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Image> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet) TextView txtTweet;
        @Bind(R.id.imgMedia) ImageView imgMedia;
        @Bind(R.id.txtFavs)  TextView txtFavs;

        private View view;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }

        public void setClickListener(final Image tweet,
                                     final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(tweet);
                }
            });

        }
    }
}
