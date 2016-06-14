package com.android.richsjeson.vr.panowidget;

import java.util.ArrayList;

/**
 * Created by richsjeson on 16/6/14.
 */
public class VrPanoCycle {

    private VrPanorCycleListener listener;

    private static ArrayList<VrPanorCycleListener> mVrPanos=new ArrayList<VrPanorCycleListener>();

    public static void addPanoCycle(VrPanorCycleListener listener){

        mVrPanos.add(listener);
    }

    public static void onResume(){
        if(mVrPanos != null && mVrPanos.size()>0){
            for(VrPanorCycleListener listener:mVrPanos){
                listener.onResume();
            }
        }
    }

    public static void onPause(){
        if(mVrPanos != null && mVrPanos.size()>0){
            for(VrPanorCycleListener listener:mVrPanos){
                listener.onPause();
            }
        }
    }

    public static void onDestory(){
        if(mVrPanos != null && mVrPanos.size()>0){
            for(VrPanorCycleListener listener:mVrPanos){
                listener.onDestory();
            }
        }
    }
}
