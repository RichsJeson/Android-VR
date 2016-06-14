package com.android.richsjeson.vr.panowidget;

import android.content.Context;
import android.util.AttributeSet;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

/**
 * Created by richsjeson on 16/6/14.
 */
public class VsPanoramaView extends VrPanoramaView implements VrPanorCycleListener{

    public VsPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        VrPanoCycle.addPanoCycle(this);
    }

    public VsPanoramaView(Context context) {
        super(context);
        VrPanoCycle.addPanoCycle(this);
    }


    @Override
    public void onResume() {
        this.resumeRendering();
    }

    @Override
    public void onDestory() {
        this.shutdown();
    }

    @Override
    public void onPause() {
        this.pauseRendering();
    }
}
