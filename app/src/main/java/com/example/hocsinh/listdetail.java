package com.example.hocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static com.example.hocsinh.MainActivity.adapterss;
import static com.example.hocsinh.MainActivity.hocsinhs;

public class listdetail extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdetail);
        listView=(ListView)findViewById(R.id.lvdt);
        listView.setAdapter(adapterss);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(listdetail.this,hsDetail.class);
                intent.putExtra("index",i);
                startActivity(intent);
            }
        });
    }
}