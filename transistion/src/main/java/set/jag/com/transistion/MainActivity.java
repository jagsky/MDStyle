package set.jag.com.transistion;

import android.app.Activity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    private RelativeLayout mRelativeLayout;
    private TransitionManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mRelativeLayout = (RelativeLayout)findViewById(R.id.)
    }
}
