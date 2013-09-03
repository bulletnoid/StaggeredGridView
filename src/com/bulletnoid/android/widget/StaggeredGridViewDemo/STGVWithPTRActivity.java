package com.bulletnoid.android.widget.StaggeredGridViewDemo;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.bulletnoid.android.widget.StaggeredGridView.StaggeredGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshStaggeredGridView;

public class STGVWithPTRActivity extends Activity {
    PullToRefreshStaggeredGridView ptrstgv;
    STGVAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_stgv_with_ptr);

        ptrstgv = (PullToRefreshStaggeredGridView) findViewById(R.id.ptrstgv);

        mAdapter = new STGVAdapter(this, getApplication());

        ptrstgv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ptrstgv.getRefreshableView().setHeaderView(new Button(this));
        View footerView;
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.layout_loading_footer, null);
        ptrstgv.getRefreshableView().setFooterView(footerView);
        ptrstgv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        ptrstgv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<StaggeredGridView>() {
            @Override
            public void onRefresh(PullToRefreshBase<StaggeredGridView> refreshView) {
                mAdapter.getNewItem();
                mAdapter.notifyDataSetChanged();

                ptrstgv.onRefreshComplete();
            }
        });

        ptrstgv.setOnLoadmoreListener(new StaggeredGridView.OnLoadmoreListener() {
            @Override
            public void onLoadmore() {
                new LoadMoreTask().execute();
            }
        });

    }

    public class LoadMoreTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mAdapter.getMoreItem();
            mAdapter.notifyDataSetChanged();
            super.onPostExecute(result);
        }

    }
}