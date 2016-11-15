package set.jag.com.viewpagerdome1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @butterknife.InjectView(R.id.vp)
    ViewPager vp;
    @butterknife.InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    //第一步 使用layouinflater添加子布局，放到View集合中
    //第二部：设置ViewPager的适配器
    //第三步：将适配器设置给ViewPager
    private View view1, view2, view3;
    ArrayList<View> views = new ArrayList<View>();
    BaseAdapter baseAdapter = new BaseAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        view1 = LayoutInflater.from(this).inflate(R.layout.pager_item1, null);
        view2 = LayoutInflater.from(this).inflate(R.layout.pager_item2, null);
        view3 = LayoutInflater.from(this).inflate(R.layout.pager_item3, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        vp.setAdapter(baseAdapter);
    }

    class BaseAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /*删除自定的下标的View*/
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
    }
}
