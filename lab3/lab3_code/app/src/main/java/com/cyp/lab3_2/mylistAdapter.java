package com.cyp.lab3_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */

public class mylistAdapter extends BaseAdapter {
    private Context context;
    private List<item2> cargood;
    public mylistAdapter(Context context, List<item2> cargood) {
        this.context = context;
        this.cargood=cargood;
    }

    @Override
    public int getCount() {
        if (cargood != null) {
            return cargood.size();
        } else return 0;
    }
    @Override
    public Object getItem(int i) {
        if (cargood == null) {
            return null;
        } else {
            return cargood.get(i);
        }
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View convertView;
        ViewHolder holder;
        if (view == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item2, null);
            holder = new ViewHolder();
            holder.cycle=(TextView)convertView.findViewById(R.id.cycle2);
            holder.goodname= (TextView) convertView.findViewById(R.id.goodname2);
            holder.goodprice = (TextView) convertView.findViewById(R.id.goodprice2);
            convertView.setTag(holder);
        } else {
            convertView = view;
            holder = (ViewHolder) convertView.getTag();
        }
        holder.cycle.setText(cargood.get(position).getName().substring(0,1).toUpperCase());
        holder.goodname.setText(cargood.get(position).getName());
        holder.goodprice.setText(cargood.get(position).getPrice());
        return convertView;
    }
    private class ViewHolder {
        public TextView cycle;
        public TextView goodname;
        public TextView goodprice;
    }

}
