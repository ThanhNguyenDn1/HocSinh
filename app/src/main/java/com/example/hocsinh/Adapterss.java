package com.example.hocsinh;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapterss  extends ArrayAdapter<hocsinh> {
    private Context context;
    private int resource;
    private List<hocsinh> hocsinhs;
    public Adapterss(@NonNull Context context, int resource, @NonNull List<hocsinh> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.hocsinhs=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewOlder viewOlder;
        if(convertView==null){
            viewOlder=new viewOlder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_lv,parent,false);
            viewOlder.name=(TextView) convertView.findViewById(R.id.tv_name);
            viewOlder.number=(TextView) convertView.findViewById(R.id.tv_number);
          
            convertView.setTag(viewOlder);
        }
        else {
            viewOlder=(viewOlder) convertView.getTag();
        }

        hocsinh hocsinh=hocsinhs.get(position);
        viewOlder.name.setText(hocsinh.getName());
        viewOlder.number.setText(hocsinh.getSdt());

    return convertView;
    }
    public  class  viewOlder{
     TextView name;
     TextView number;

    }
}
