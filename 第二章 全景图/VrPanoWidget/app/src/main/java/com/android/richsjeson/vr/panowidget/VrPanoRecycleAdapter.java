package com.android.richsjeson.vr.panowidget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.util.List;

/**
 * Created by richsjeson on 16/6/14.
 */
public class VrPanoRecycleAdapter extends RecyclerView.Adapter<VrPanoRecycleAdapter.VrHolder>  {

    private Context context;

    private List<String> list;

    private LayoutInflater mLayoutInflat;

    private OnScroll scroll;

    public VrPanoRecycleAdapter(Context context,List<String> list){

        this.context=context;
        this.list=list;
        mLayoutInflat= LayoutInflater.from(context);
    }

    @Override
    public VrHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mLayoutInflat.inflate(R.layout.item_view,parent,false);
        return new VrHolder(view);
    }

    public void setOnScroll(OnScroll onScroll){
        this.scroll=onScroll;
    }

    @Override
    public void onBindViewHolder(final VrHolder holder,final int position) {

        if(list.size()>0){


            if(scroll != null){
                scroll.scroll(position,holder.vrPanoramaView);
            }

        }

    }

    @Override
    public int getItemCount() {
        if(list != null && list.size()>0){
            return list.size();
        }else{
            return 0;
        }
    }

    public class VrHolder extends RecyclerView.ViewHolder {


        private VrPanoramaView vrPanoramaView;

        public VrHolder(View itemView) {
            super(itemView);
            vrPanoramaView= (VrPanoramaView) itemView.findViewById(R.id.pvs);
        }
    }

    public interface  OnScroll{
         void scroll(int position,VrPanoramaView view);
    }
}
