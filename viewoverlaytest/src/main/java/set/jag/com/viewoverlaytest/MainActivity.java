package set.jag.com.viewoverlaytest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @butterknife.InjectView(R.id.btn1)
    Button button;
    @butterknife.InjectView(R.id.fl1)
    FrameLayout fl1;
    @butterknife.InjectView(R.id.button2)
    Button button2;
    @butterknife.InjectView(R.id.greenContainer)
    FrameLayout greenContainer;
    @butterknife.InjectView(R.id.button3)
    Button button3;
    @butterknife.InjectView(R.id.orangeContainer)
    FrameLayout orangeContainer;
    @butterknife.InjectView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        viewSetup();
    }

    private void viewSetup() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final ViewGroup viewGroup = (ViewGroup) button.getParent().getParent();
                viewGroup.getOverlay().add(button);

                ObjectAnimator anim = ObjectAnimator.ofFloat(button, "translationY", viewGroup.getHeight());
                ObjectAnimator rotate = ObjectAnimator.ofFloat(button, "rotation", 0, 360);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setRepeatMode(Animation.REVERSE);
                rotate.setDuration(350);

                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        viewGroup.getOverlay().remove(button);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        viewGroup.getOverlay().remove(button);
                    }
                });

                anim.setDuration(2000);
                AnimatorSet animationSet  =new AnimatorSet();
                animationSet.playTogether(anim,rotate);
                animationSet.start();


            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Normal animation, we only see it when is animating in its original layout container.
                final ViewGroup container = (ViewGroup) button2.getParent().getParent();
                ObjectAnimator anim = ObjectAnimator.ofFloat(button2, "translationY", -container.getHeight());
                anim.setDuration(2000);
                anim.start();
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(button3, "alpha", 1f, 0f);
                fadeOut.setDuration(500);

				/*
				 * Here we add our button to center layout's ViewGroupOverlay
				 * when first fade-out animation ends.
				 */
                final ViewGroup container = (ViewGroup) button2.getParent();
                final ObjectAnimator anim = ObjectAnimator.ofFloat(button3, "translationY", -container.getHeight() * 2);
                anim.setDuration(2000);

                anim.addListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) { }

                    @Override
                    public void onAnimationRepeat(Animator animation) { }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        container.getOverlay().remove(button3);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        container.getOverlay().remove(button3);
                    }
                });

                fadeOut.addListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator arg0) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator arg0) {
                    }

                    @Override
                    public void onAnimationEnd(Animator arg0) {
                        container.getOverlay().add(button3);
                        button3.setAlpha(1f);
                        anim.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator arg0) {
                        container.getOverlay().add(button3);
                        button3.setAlpha(1f);
                        anim.start();
                    }
                });

                fadeOut.start();
            }
        });
    }
}
