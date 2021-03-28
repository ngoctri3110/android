package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private EditText et_ten;
    private Button btnNhap;
    private TextView tv_hien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ten = (EditText) findViewById(R.id.edittext_ten);

        myList = new ArrayList<String>();
        list = (ListView) findViewById(R.id.listview_ten);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        list.setAdapter(adapter);

        btnNhap = (Button) findViewById(R.id.btn_nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(et_ten.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });

        //xử lý xự kiện cho listview
        tv_hien = (TextView) findViewById(R.id.textview_hien);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "position: " + position;
                msg += "; value: " + parent.getItemAtPosition(position).toString();

                tv_hien.setText(msg);
            }
        });

    }
}