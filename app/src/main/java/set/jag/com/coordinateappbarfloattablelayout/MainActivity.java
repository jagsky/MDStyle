package set.jag.com.coordinateappbarfloattablelayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import set.jag.com.coordinateappbarfloattablelayout.fragment.Fragment1;

/*
* @Description  实现顶部ViewPager滑动效果
* */
public class MainActivity extends AppCompatActivity {
    private TabLayout mTab1;
    private ViewPager mContentVp;
    private List<String> mList;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*第一步：获取控件
        * */
        mTab1 = (TabLayout) findViewById(R.id.tab);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);
        //初始化内容
        intContent();
        //初始化tab
        intab();
    }

    /*
    * @Description  初始化界面内容，添加控件
    * */
    private void intContent() {
        //创建三个String，用于显示tab的导航栏
        mList = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            mList.add("tab" + i);
        }
        //创建fragment集合，添加fragment
        tabFragments = new ArrayList<>();
        /*for (String s : mList) {
            tabFragments.add(TabContentFragment.newInstance(s));
        }*/
        tabFragments.add(Fragment1.newInstance(mList.get(1), mList.get(1)));
        tabFragments.add(Fragment1.newInstance(mList.get(2), mList.get(2)));
        tabFragments.add(Fragment1.newInstance(mList.get(0), mList.get(0)));
        //这个方法的意思是 PagerAdapter在创建的时候要绑定Fragment
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        //Viewger的适配器
        mContentVp.setAdapter(contentAdapter);
    }

    /*@Description  初始化tab,在tab中添加滑动兰栏,并且把数据添加进去
    * setupWithViewPager 这个方法可以将Tab与viewpager绑定在一起
    * */
    private void intab() {
        mTab1.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTab1.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        mTab1.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(mTab1, 10);
        mTab1.setupWithViewPager(mContentVp);


    }

    class ContentPagerAdapter extends FragmentPagerAdapter {
        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position);
        }


    }
}
