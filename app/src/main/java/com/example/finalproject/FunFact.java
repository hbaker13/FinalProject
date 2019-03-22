package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FunFact extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfact);

        listView = (ListView) findViewById(R.id.listView);
        adapter = ArrayAdapter.createFromResource(this,R.array.funfact_info,R.layout.list_item_facts);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.me);
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
