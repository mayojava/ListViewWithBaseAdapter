package com.android.sample.listviewwithbaseadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.sample.listviewwithbaseadapter.R;
import com.android.sample.listviewwithbaseadapter.model.Item;


import java.util.ArrayList;

/**
 * Custom list adapter, implementing BaseAdapter
 */
public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    public CustomListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total item in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns the item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_row_items, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item currentItem = (Item) getItem(position);
        viewHolder.itemName.setText(currentItem.getItemName());
        viewHolder.itemDescription.setText(currentItem.getItemDescription());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView itemName;
        TextView itemDescription;

        public ViewHolder(View view) {
            itemName = (TextView)view.findViewById(R.id.text_view_item_name);
            itemDescription = (TextView) view.findViewById(R.id.text_view_item_description);
        }
    }
}
