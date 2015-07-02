package com.example.adrew.wifi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ADrew on 7/2/15.
 */

    public class CustomAdapter extends BaseAdapter {

        String items[];
        LayoutInflater mInflater;

        public CustomAdapter(Context context, String[] items) {
            mInflater = LayoutInflater.from(context);
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if(convertView ==null)
            {
                convertView = mInflater.inflate(R.layout.list_item,parent,false);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.textView1);
                holder.iv = (ImageView) convertView.findViewById(R.id.imageView1);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv.setText(items[position]);
            // use holder.iv to set whatever image you want according to the position
            return convertView;
        }

        static class ViewHolder
        {
            ImageView iv;
            TextView tv;
        }
    }

