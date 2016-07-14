package website.davidpolania.android.twitterclient.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.twitter.sdk.android.Twitter;

import butterknife.Bind;
import butterknife.ButterKnife;
import website.davidpolania.android.twitterclient.R;
import website.davidpolania.android.twitterclient.hashtags.ui.HashtagsFragment;
import website.davidpolania.android.twitterclient.images.ui.ImagesFragment;
import website.davidpolania.android.twitterclient.login.ui.LoginActivity;
import website.davidpolania.android.twitterclient.main.adapters.MainSectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.container) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Fragment[] fragments = new Fragment[] {new ImagesFragment(),
                                             new HashtagsFragment()};

        String[] titles = new String[] {getString(R.string.main_header_images),
                                        getString(R.string.main_header_hashtags)};

        setSupportActionBar(toolbar);
        setTitle(String.format(getString(R.string.hello_user),Twitter.getSessionManager().getActiveSession().getUserName()));

        MainSectionsPagerAdapter adapter = new MainSectionsPagerAdapter(getSupportFragmentManager(),
                                                                        fragments,
                                                                        titles);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        Twitter.logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
