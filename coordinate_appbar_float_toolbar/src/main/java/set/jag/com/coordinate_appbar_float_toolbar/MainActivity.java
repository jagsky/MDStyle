package set.jag.com.coordinate_appbar_float_toolbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/*
* 实现一个导航栏可折叠的Toolbar
* */
public class MainActivity extends AppCompatActivity {

    @butterknife.InjectView(R.id.tab)
    TabLayout tab;
    @butterknife.InjectView(R.id.appbar)
    AppBarLayout appbar;
    /*@butterknife.InjectView(R.id.viewpager)
    ViewPager viewpager;*/
    @butterknife.InjectView(R.id.fab)
    FloatingActionButton fab;
    @butterknife.InjectView(R.id.activity_main)
    CoordinatorLayout activityMain;
    @butterknife.InjectView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        toolbar.setTitle("标题");
        setSupportActionBar(toolbar);

    }


}
