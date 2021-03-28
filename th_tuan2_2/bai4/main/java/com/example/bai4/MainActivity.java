package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    EditText et_ten;
    TextView tv_ketqua;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;

    Button btn_nhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ten = (EditText) findViewById(R.id.edittext_ten);
        tv_ketqua = (TextView) findViewById(R.id.textview_hien);

        myList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                myList);
        setListAdapter(adapter);

        btn_nhap = (Button) findViewById(R.id.btn_nhap);
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(et_ten.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String)getListAdapter().getItem(position);
        tv_ketqua.setText("position: " + position +"; value: " + item+"");

    }
}