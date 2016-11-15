package set.jag.com.coordinate_appbar_float_toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main2Activity extends AppCompatActivity {

    @InjectView(R.id.tb)
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.inject(this);
        tb.setTitle("标题");
        setSupportActionBar(tb);
    }
}
