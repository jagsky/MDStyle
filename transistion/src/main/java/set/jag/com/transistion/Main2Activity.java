package set.jag.com.transistion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main2Activity extends AppCompatActivity implements TextView.OnClickListener {


    @InjectView(R.id.view1)
    TextView view1;
    @InjectView(R.id.view2)
    TextView view2;
    @InjectView(R.id.view3)
    TextView view3;
    @InjectView(R.id.view4)
    TextView view4;
    @InjectView(R.id.activity_main2)
    LinearLayout activityMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.inject(this);
        activityMain2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TransitionManager.beginDelayedTransition(activityMain2, new Explode());
        toggleVisibility(view1, view2, view3, view4);

    }

    private void toggleVisibility(TextView... textViews) {
        for (TextView textView : textViews) {
            boolean isVisible = textView.getVisibility() == View.VISIBLE;
            textView.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
    }
}
