package com.bulletnoid.android.widget.StaggeredGridViewDemo;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class STGVAdapter extends BaseAdapter {
    private Context mContext;
    private Application mAppContext;
    private DataSet mData = new DataSet();
    private ArrayList<Item> mItems = new ArrayList<Item>();

    private int newPos = 19;

    public STGVAdapter(Context context, Application app) {
        mContext = context;
        mAppContext = app;
        getMoreItem();
    }

    public void getMoreItem() {
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.url = mData.url[i];
            item.width = mData.width[i];
            item.height = mData.height[i];
            mItems.add(item);
        }
    }

    public void getNewItem() {
        Item item = new Item();
        item.url = mData.url[newPos];
        item.width = mData.width[newPos];
        item.height = mData.height[newPos];
        mItems.add(0, item);
        newPos = (newPos - 1) % 19;
    }

    @Override
    public int getCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        final Item item = mItems.get(position);

        String url = item.url;

        if (convertView == null) {
            Holder holder = new Holder();
            view = View.inflate(mContext, R.layout.cell_stgv, null);
            holder.img_content = (STGVImageView) view.findViewById(R.id.img_content);
            holder.tv_info = (TextView) view.findViewById(R.id.tv_info);

            view.setTag(holder);
        } else {
            view = convertView;
        }

        Holder holder = (Holder) view.getTag();

        /**
         * StaggeredGridView has bugs dealing with child TouchEvent
         * You must deal TouchEvent in the child view itself
         **/
        holder.img_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.tv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.tv_info.setText(position + " : " + item.width + "/" + item.height);

        holder.img_content.mHeight = item.height;
        holder.img_content.mWidth = item.width;

        Picasso.with(mAppContext).load(url).into(holder.img_content);
        return view;
    }

    class Holder {
        STGVImageView img_content;
        TextView tv_info;
    }

}
