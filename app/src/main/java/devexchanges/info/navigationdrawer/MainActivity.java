package devexchanges.info.navigationdrawer;

import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import devexchanges.info.materialdesignnavigationdrawer.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listView;
    private ArrayList<SocialNetwork> socialNetworks;
    private ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socialNetworks = new ArrayList<>();
        findViewById();
        setSupportActionBar(toolbar);

        initDrawerLayout();
    }

    private void findViewById() {
        listView = (ListView) findViewById(R.id.list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    }

    private void initDrawerLayout() {
        setListViewData();
        setListViewHeader();
        //Mount listview with adapter
        adapter = new ListViewAdapter(this, R.layout.item_listview, socialNetworks);
        listView.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private void setListViewHeader() {
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header_listview, listView, false);
        listView.addHeaderView(header, null, false);
    }

    private void setListViewData() {
        socialNetworks.add(new SocialNetwork(R.mipmap.zalo_small, R.mipmap.zalo_big, "Zalo", "VIETNAM"));
        socialNetworks.add(new SocialNetwork(R.mipmap.fb_small, R.mipmap.fb_big, "Facebook", "USA"));
        socialNetworks.add(new SocialNetwork(R.mipmap.tw_small, R.mipmap.tw_big, "Twitter", "USA"));
        socialNetworks.add(new SocialNetwork(R.mipmap.pin_small, R.mipmap.pin_big, "Pinterest", "USA"));
        socialNetworks.add(new SocialNetwork(R.mipmap.gp_small, R.mipmap.gp_big, "Google+", "USA"));
        socialNetworks.add(new SocialNetwork(R.mipmap.baidu_small, R.mipmap.baidu_big, "Baidu", "CHINA"));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Replace fragment to Main layout
     * @param socialNetwork
     */
    public void updateMainLayout(SocialNetwork socialNetwork) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container, ContentFragment.newInstance(socialNetwork));
        transaction.commit();

        //close navigation drawer after replace fragment
        drawerLayout.closeDrawers();
    }
}