package set.jag.com.fragmentshardelementtest;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 网格的RecyclerView
 * <p/>
 * Created by wangchenlong on 15/11/5.
 */
public class GridFragment extends Fragment {

    private ArrayList<Pair<Integer, Integer>> mData;

    @Bind(R.id.grid_rv_recycler)
    RecyclerView mRvRecycler;

    //1.利用填充器添加对应的布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    //2.初始化属性，并在填充布局后为RecycleView设置适配器和布局形式
    //所以就要写一个适配器，而这个适配器的image需要使用点击事件，所以就要写一个接口处理点击事件，并且在适配器中引用
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();

        mRvRecycler.setAdapter(new MyGridAdapter(mData, mListener));
        mRvRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3)); // 一行两个
    }

    /**
     * 点击事件, 转换元素的动画, SharedElement共享元素
     * 关键addSharedElement(holder.getImageView(), getResources().getString(R.string.image_transition))
     * 绑定ViewHolder的图片和DetailFragment的跳转.
     */
    private MyViewOnClickListener mListener = new MyViewOnClickListener() {
        @Override
        public void onClickedView(MyGridViewHolder holder, int position) {
            DetailFragment detailFragment = DetailFragment.newInstance(position);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //设置显示图片的进入的动画
                detailFragment.setSharedElementEnterTransition(new DetailTransition());
                //
                setExitTransition(new Fade());
                detailFragment.setEnterTransition(new Fade());
                detailFragment.setSharedElementReturnTransition(new DetailTransition());
            }

            getActivity().getSupportFragmentManager().beginTransaction()
                    .addSharedElement(holder.getImageView(), getResources().getString(R.string.image_transition))
                    .replace(R.id.main_cl_container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        }
    };

    // 初始化数据
    private void initData() {
        mData = new ArrayList<>();

        mData.add(Pair.create(R.string.taeyeon, R.mipmap.taeyeon));
        mData.add(Pair.create(R.string.jessica, R.mipmap.jessica));
        mData.add(Pair.create(R.string.sunny, R.mipmap.sunny));
        mData.add(Pair.create(R.string.tiffany, R.mipmap.tiffany));
        mData.add(Pair.create(R.string.yuri, R.mipmap.yuri));
        mData.add(Pair.create(R.string.yoona, R.mipmap.yoona));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
