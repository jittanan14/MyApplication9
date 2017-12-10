package com.gwamelody.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.gwamelody.myapplication.Adapter.ListAdapter;
import com.gwamelody.myapplication.Model.Animals;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button add;
    private Button delete;
    private ListView mListView;
   private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.ListName);
        add = (Button) findViewById(R.id.Addbutton2);
        delete = (Button) findViewById(R.id.Deletebutton);


       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent  = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
               finish();
           }
       });
       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
               finish();
           }
       });

        DBHelper mDB = new DBHelper(this);
       ArrayList <Animals> animal=mDB.getAnimal();

        adapter = new ListAdapter(this,R.layout.item,animal);
        mListView.setAdapter(adapter);

    }
}
