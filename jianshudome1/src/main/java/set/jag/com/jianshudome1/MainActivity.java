package set.jag.com.jianshudome1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tab)
    TabLayout tab;
    @InjectView(R.id.vp)
    ViewPager vp;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    MyAdapter myAdapter;
    List<Fragment> fragments;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        tab.addTab(tab.newTab().setText("text1"));
        tab.addTab(tab.newTab().setText("text2"));
        tab.addTab(tab.newTab().setText("text3"));
        tab.addTab(tab.newTab().setText("text4"));
        tab.addTab(tab.newTab().setText("text5"));
        tab.addTab(tab.newTab().setText("text6"));
        tab.addTab(tab.newTab().setText("text7"));
        tab.addTab(tab.newTab().setText("text8"));
        tab.addTab(tab.newTab().setText("text9"));
        tab.addTab(tab.newTab().setText("text10"));
        tab.addTab(tab.newTab().setText("text11"));
        ViewCompat.setElevation(tab, 10);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        addFargment();
        tab.setupWithViewPager(vp);

    }

    private void addFargment() {
        fragments = new ArrayList<Fragment>();
        arrayList = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i, "text" + i);
            fragments.add(BlankFragment1.newInstance("fragment" + i, "fragment" + i));
        }
        myAdapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdapter);
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}
