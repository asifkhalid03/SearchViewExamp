package com.example.searchviewexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView mySearchView;
    ListView mylist;

    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySearchView = (SearchView) findViewById(R.id.searchv);
        mylist = (ListView) findViewById(R.id.listview);

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");





        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        mylist.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });




    }
}
