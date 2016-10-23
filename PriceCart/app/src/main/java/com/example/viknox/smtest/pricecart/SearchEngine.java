package com.example.viknox.smtest.pricecart;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by x230 on 10/23/2016.
 */
public class SearchEngine extends Activity {
    // List view
    private ListView lv;

    // Listview Adapter, generates item in listview
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    public void reset(){
        SearchEngine.this.lv.setVisibility(View.GONE);
    }
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Listview Data to be changed with getting list from productTable, PName, PQuant: >1
        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};


        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                SearchEngine.this.adapter.getFilter().filter(cs);
                SearchEngine.this.lv.setVisibility(View.VISIBLE);
                //TODO: create a loop that resets the the list view back to invisible, when there is no data in
                // search input

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                SearchEngine.this.lv.setVisibility(View.GONE);
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {

                // TODO Auto-generated method stub
            }
        });


        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);

    }
}
