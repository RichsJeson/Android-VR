package com.android.richsjeson.vr.panowidget;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richsjeson on 16/6/14.
 */
public class MainActivity extends Activity implements VrPanoRecycleAdapter.OnScroll{

    private RecyclerView rcvVrPano;
    private VrPanoRecycleAdapter adapter;
    private List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        rcvVrPano= (RecyclerView) this.findViewById(R.id.rcv_vrpano);
        adapter=new VrPanoRecycleAdapter(this,list);
        rcvVrPano.setAdapter(adapter);
        rcvVrPano.setLayoutManager(new LinearLayoutManager(this));

        List<String> lists=new ArrayList<String>();

        lists.add("1.jpg");
        lists.add("2.jpg");
        lists.add("1.jpg");
        lists.add("2.jpg");
        lists.add("1.jpg");
        lists.add("2.jpg");
        lists.add("1.jpg");
        list.addAll(lists);
        adapter.notifyDataSetChanged();
        adapter.setOnScroll(this);
        rcvVrPano.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VrPanoCycle.onDestory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        VrPanoCycle.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        VrPanoCycle.onPause();
    }

    @Override
    public void scroll(final int position, final VrPanoramaView view) {
        view.getRootView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    VrPanoramaView.Options panoOptions = null;  // It's safe to use null VrPanoramaView.Options.
                    InputStream istr = null;

                    AssetManager assetManager = getApplicationContext().getAssets();
                    try {
                        istr = assetManager.open(list.get(position));
                        panoOptions = new VrPanoramaView.Options();
                        panoOptions.inputType = VrPanoramaView.Options.TYPE_MONO;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    view.loadImageFromBitmap(BitmapFactory.decodeStream(istr), panoOptions);
                }
            },200);
    }
}
