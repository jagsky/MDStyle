package set.jag.com.tablayout_fangjingdong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tab)
    TabLayout tab;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.vp_content)
    ViewPager vpContent;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    //三个子tab显示的文字
    private String[] title = {"商品", "详情", "评论"};
    MyFragmentPagerAdaPter myFragmentPagerAdaPter;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //初始化界面信息
        initContent();
    }


    private void initContent() {
        initViewPager();
        initToolbar();
    }

    private void initToolbar() {
        //初始化Toolbar
        setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //初始化标题Tab
        //设置tab下标的颜色
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        tab.setTabTextColors(getResources().getColor(R.color.darkturquoise), getResources().getColor(R.color.aquamarine));
        tab.addTab(tab.newTab().setText("商品"));
        tab.addTab(tab.newTab().setText("详情"));
        tab.addTab(tab.newTab().setText("评论"));
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(vpContent);

    }


    private void initViewPager() {
        fragments = new ArrayList<Fragment>();
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment2.newInstance());
        fragments.add(Fragment3.newInstance());
        myFragmentPagerAdaPter = new MyFragmentPagerAdaPter(getSupportFragmentManager());
        vpContent.setAdapter(myFragmentPagerAdaPter);
    }

    class MyFragmentPagerAdaPter extends FragmentPagerAdapter {
        //在构造器中会绑定 Fragment管理器
        public MyFragmentPagerAdaPter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //这个方法返回一个pager的标题栏字符串
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
