package com.example.hocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button next;
 static  ArrayList<hocsinh> hocsinhs;
    static   Adapterss adapterss;
    private ListView listView;
    private EditText edtName;
    private TextView tvOld;
    private Spinner spnOld;
    private CheckBox cbNam;
    private CheckBox cbNu;
    private EditText edtSdt;
    private EditText edtMail;
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private Button btnThoat;
    private int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent();
        setButton();

        hocsinhs=new ArrayList<>();
        adapterss=new Adapterss(this,R.layout.item_lv,hocsinhs);
        listView.setAdapter(adapterss);
        List<Integer> spinners=new ArrayList<>();
        for(int i=18; i<50; i++){
            spinners.add(i);
        }
        final ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(
                this,android.R.layout.simple_spinner_item,spinners
        );

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spnOld.setAdapter(adapter);
        this.spnOld.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int old=adapter.getItem(i);
                tvOld.setText(old+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setButton() {
        cbNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbNam.isChecked()==true){
                    cbNu.setChecked(false);
                }
            }
        });
        cbNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbNu.isChecked()==true){
                    cbNam.setChecked(false);
                }
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=edtName.getText().toString().trim();
                String mold=tvOld.getText().toString().trim();
                if(!mold.isEmpty()){
                    int old=Integer.parseInt(mold);
                    boolean gioitinh=true;
                    if(cbNam.isChecked()==true){
                        gioitinh=true;
                    }
                    else gioitinh=false;
                    String number=edtSdt.getText().toString().trim();
                    String mail=edtMail.getText().toString().trim();
                    if(!name.isEmpty()&&!mold.isEmpty()&&(!cbNu.isChecked()||!cbNam.isChecked())&&!number.isEmpty()&&!mail.isEmpty()){
                        hocsinh hocsinh=new hocsinh(name,old,gioitinh,number,mail,id);
                        hocsinhs.add(hocsinh);
                        edtName.setText("");
                        tvOld.setText("");
                        cbNu.setChecked(false);
                        cbNam.setChecked(true);
                        edtSdt.setText("");
                        edtMail.setText("");
                        adapterss.notifyDataSetChanged();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Nhập thông tin",Toast.LENGTH_SHORT).show();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,listdetail.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final hocsinh hocsinh=hocsinhs.get(i);
                edtName.setText(hocsinh.getName());
                tvOld.setText(hocsinh.getOld()+"");
                boolean mold=hocsinh.isGioitinh();
                if(mold==true){
                    cbNam.setChecked(true);
                    cbNu.setChecked(false);
                }
                else {
                    cbNu.setChecked(true);
                    cbNam.setChecked(false);
                }
                edtSdt.setText(hocsinh.getSdt());
                edtMail.setText(hocsinh.getEmail());
                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=edtName.getText().toString().trim();
                        String mold=tvOld.getText().toString().trim();
                        int old=Integer.parseInt(mold);
                        boolean gioitinh=true;
                        if(cbNam.isChecked()==true){
                            gioitinh=true;
                        }
                        else gioitinh=false;
                        String number=edtSdt.getText().toString().trim();
                        String mail=edtMail.getText().toString().trim();
                        if(!name.isEmpty()){
                            hocsinh.setName(name);
                        }
                        if(!mold.isEmpty()){
                            hocsinh.setOld(old);
                        }
                        hocsinh.setGioitinh(gioitinh);
                        if(!number.isEmpty()){
                            hocsinh.setSdt(number);
                        }
                        if(!mail.isEmpty()){
                            hocsinh.setEmail(mail);
                        }
                        adapterss.notifyDataSetChanged();
                    }
                });

                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hocsinhs.remove(hocsinh);
                        adapterss.notifyDataSetChanged();
                    }

                });
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtName.setText("");
                        tvOld.setText("");
                        cbNu.setChecked(false);
                        cbNam.setChecked(false);
                        edtSdt.setText("");
                        edtMail.setText("");

                    }
                });

            }
        });
    }



    private void addEvent() {
        next=(Button)findViewById(R.id.next);
        listView=(ListView)findViewById(R.id.lv);
        edtName=(EditText) findViewById(R.id.edt_name);
        tvOld=(TextView) findViewById(R.id.tv_old);
        spnOld=(Spinner) findViewById(R.id.spinner);
        cbNam=(CheckBox) findViewById(R.id.cb_nam);
        cbNu=(CheckBox) findViewById(R.id.cb_nu);
        edtSdt=(EditText) findViewById(R.id.edt_numberPhone);
        edtMail=(EditText) findViewById(R.id.edt_email);
        btnThem=(Button) findViewById(R.id.btn_them);
        btnSua=(Button) findViewById(R.id.btn_sua);
        btnXoa=(Button) findViewById(R.id.btn_xoa);
        btnThoat=(Button) findViewById(R.id.btn_thoat);
    }


}