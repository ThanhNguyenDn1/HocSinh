package com.example.hocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static com.example.hocsinh.MainActivity.hocsinhs;

public class hsDetail extends AppCompatActivity {
    TextView Ten;
    TextView Tuoi;
    TextView Gt;
    TextView sdt;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_detail);
        Intent intent=this.getIntent();
        int i=intent.getIntExtra("index",0);
        Log.e("AAAA",i+"");
        addEvent();
        hocsinh hs= hocsinhs.get(i);
        Ten.setText(hs.getName());
        Tuoi.setText(hs.getOld()+"");
        Gt.setText(hs.gioitinh==true?"Nam":"Nu");
        sdt.setText(hs.getSdt());
        email.setText((hs.email));
    }
   void addEvent(){
        Ten=(TextView)findViewById(R.id.tendt);
        Tuoi=(TextView)findViewById(R.id.olddt);
        Gt=(TextView)findViewById(R.id.gtdt);
        sdt=(TextView)findViewById(R.id.sdtdt);
        email=(TextView)findViewById(R.id.emaildt);
    }
}