package com.gwamelody.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gwamelody.myapplication.Model.Animals;

public class Main2Activity extends AppCompatActivity {

    DBHelper mDB;
    EditText engName,thailName,detail;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mDB = new DBHelper(this);

        engName = (EditText) findViewById(R.id.engNameID);
        thailName = (EditText) findViewById(R.id.thaiNameID);
        detail = (EditText)  findViewById(R.id.detailID);
        add = (Button) findViewById(R.id.addButtonID);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDB.addAnimal(new Animals(engName.getText().toString(),thailName.getText().toString(),R.drawable.cat,detail.getText().toString()));
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
