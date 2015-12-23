package com.nshirahama.viewpagersample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.nshirahama.viewpagersample.fragments.MainFragment;
import com.nshirahama.viewpagersample.fragments.SettingFragment;

/**
 * Created by naruki on 23/12/15.
 */
public class MainActivity extends Activity {
    private ViewPager mPager;
    private SettingFragment mSettingPage;
    private MainFragment mMainPage;

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        mPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getFragmentManager());
        mMainPage = new MainFragment();
        mSettingPage = new SettingFragment();
        adapter.addFragment(mMainPage);
        adapter.addFragment(mSettingPage);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //--Empty placeholder
            }

            @Override
            public void onPageSelected(int position) {
                //--Empty placeholder
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //--Empty placeholder
            }
        });
        mPager.setAdapter(adapter);
    }
}
