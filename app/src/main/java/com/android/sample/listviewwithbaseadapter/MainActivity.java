package com.android.sample.listviewwithbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.sample.listviewwithbaseadapter.adapter.CustomListAdapter;
import com.android.sample.listviewwithbaseadapter.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView itemsListView  = (ListView)findViewById(R.id.list_view_items);

        //create adapter object
        CustomListAdapter adapter = new CustomListAdapter(this, generateItemsList());

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);
    }

    /**
     * Util function to generate list of items
     *
     * @return ArrayList
     */
    private ArrayList<Item> generateItemsList() {
        String itemNames[] = getResources().getStringArray(R.array.items_name);
        String itemDescriptions[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < itemNames.length; i++) {
            list.add(new Item(itemNames[i], itemDescriptions[i]));
        }

        return list;
    }
}
