package com.cyp.lab3_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */

public abstract class CommonAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mcontext;
    private int mlayoutId;
    private List<item> mdata;
    public OnItemClickListener mOnItemClickListener;
    public ViewHolder Holder;
    public CommonAdapter(Context context,int layoutId,List<item>data){
        mcontext=context;
        mdata=data;
        mlayoutId=layoutId;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent,int viewType){
        ViewHolder viewHolder= ViewHolder.get(mcontext,parent,mlayoutId);
        return viewHolder;
    }
    public void onBindViewHolder(final ViewHolder holder, final int position){
        convert(holder,mdata.get(position));
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View v){
                    mOnItemClickListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
    }
    public abstract void convert(ViewHolder holder,item item);

    @Override
    public int getItemCount(){
        return mdata.size();
    }



    public interface OnItemClickListener{
       void onClick(int position);
       Boolean onLongClick(int position);
   }
   public void setOnItemClickListener(OnItemClickListener onItemClickListener){
       this.mOnItemClickListener=onItemClickListener;
   }
}
