package com.suozhang.hotel.moudle.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.orhanobut.logger.Logger;
import com.suozhang.hotel.R;
import com.suozhang.hotel.moudle.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.nav_view)
    NavigationView rNavView;
    @BindView(R.id.navigation)
    BottomNavigationView rNavigation;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

       // rNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void updateViews() {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
              //  addFragment(R.id.content, new NewsListFragment());
                return true;
            case R.id.navigation_dashboard:
                Logger.e("test");
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    }
}
