package com.example.user.bidit.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.user.bidit.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private FrameLayout mContainer;
    private boolean mCreated = false;
    private CategoryFragment mCategoryFragment = new CategoryFragment();
    private android.app.FragmentManager mFragmentManager;
    private android.app.FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        setNavigationBar();
        updateScreen(mCategoryFragment);
        updateNavBar();

    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_account:
                break;
            case R.id.nav_balance:
                break;
            case R.id.nav_history:
                break;
            case R.id.nav_favorite:
                break;
            case R.id.nav_my_items:
                break;
            case R.id.nav_log_out:
                mCreated = true;
                break;
            case R.id.nav_create_account:
                mCreated = false;
                Intent intent = new Intent(MainActivity.this, EmailPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_help:
                break;
            case R.id.nav_about_us:
                break;

        }
        updateNavBar();
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initViews() {
        mToolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mContainer = findViewById(R.id.container_main);
        mFragmentManager = getFragmentManager();
    }

    public void setNavigationBar() {
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

    }

    public void updateScreen(Fragment fragment) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container_main, fragment);
        mFragmentTransaction.commit();

    }

    public void updateNavBar() {
        if (mCreated) {
            mNavigationView.getMenu().setGroupVisible(R.id.menu_group_if_created, false);
            mNavigationView.getMenu().findItem(R.id.nav_create_account).setVisible(true);
        } else {
            mNavigationView.getMenu().setGroupVisible(R.id.menu_group_if_created, true);
            mNavigationView.getMenu().findItem(R.id.nav_create_account).setVisible(false);
        }
    }
}
