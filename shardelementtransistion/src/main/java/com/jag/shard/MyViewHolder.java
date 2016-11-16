package com.jag.shard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wwwch on 2016/11/15.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private TextView mTextView;

    public MyViewHolder(View itemView) {
        super(itemView);
        init(itemView);
    }

    public ImageView getmImageView() {
        return mImageView;
    }

    public void setmImageView(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    public TextView getmTextView() {
        return mTextView;
    }

    public void setmTextView(TextView mTextView) {
        this.mTextView = mTextView;
    }

    private void init(View itemView) {
        mImageView = (ImageView) itemView.findViewById(R.id.iv);
        mTextView = (TextView) itemView.findViewById(R.id.tv);
    }


}
