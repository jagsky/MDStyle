package set.jag.com.tablayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    @InjectView(R.id.tab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        tab.addTab(tab.newTab().setText("Tab1"));

        tab.addTab(tab.newTab().setText("Tab2"));
        tab.addTab(tab.newTab().setText("Tab3"));
    }
}
