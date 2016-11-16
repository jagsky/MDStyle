package com.jag.shard;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    @InjectView(R.id.activity_main)
    CoordinatorLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
}
