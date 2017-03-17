package com.suozhang.hotel.moudle.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.SparseArray;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.suozhang.hotel.R;
import com.suozhang.hotel.moudle.base.BaseActivity;
import com.suozhang.hotel.moudle.newss.main.NewsListFragment;
import com.suozhang.hotel.moudle.photo.main.PhotoMainFragment;
import com.suozhang.hotel.moudle.video.main.VideoMainFragment;

import butterknife.BindView;


/**
 * 程序入口
 */
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    @BindView(R.id.container)
    LinearLayout mContainer;

    private int mItemId = 0;
    //存储fragment集合
    private SparseArray<String> mSparseArray = new SparseArray<String>();

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

        mSparseArray.put(R.id.navigation_news, "News");
        mSparseArray.put(R.id.navigation_photos, "Photo");
        mSparseArray.put(R.id.navigation_video, "Video");
       // mNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void updateViews() {
//  mNavigation.set
        addFragment(R.id.container,new NewsListFragment(),"News");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_news:
                replaceFragment(R.id.container, new NewsListFragment(), mSparseArray.get(R.id.navigation_news));
                break;
            case R.id.navigation_photos:
                replaceFragment(R.id.container, new PhotoMainFragment(), mSparseArray.get(R.id.navigation_photos));
                break;
            case R.id.navigation_video:
                replaceFragment(R.id.container, new VideoMainFragment(), mSparseArray.get(R.id.navigation_video));
                break;
        }
        mItemId = 0;
        return true;
    }


}
