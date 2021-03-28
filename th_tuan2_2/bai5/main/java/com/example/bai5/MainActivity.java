package com.example.bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_name;
    Button btnNhap;
    RadioGroup radGroup;
    ListView lvDanhSach;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter = null;

    Employee employee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.edittext_manv);
        et_name = (EditText) findViewById(R.id.edittext_tennv);
        btnNhap = (Button) findViewById(R.id.btn_nhap);
        radGroup = (RadioGroup) findViewById(R.id.radiogroup);
        lvDanhSach = (ListView) findViewById(R.id.lvNhanVien);

        arrayAdapter = new ArrayAdapter<Employee>(this,
                android.R.layout.simple_list_item_1, arrEmployee);
        lvDanhSach.setAdapter(arrayAdapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhap();
            }
        });
    }

    private void nhap() {
        int radID = radGroup.getCheckedRadioButtonId();
        String id = et_id.getText() + "";
        String name = et_name.getText() + "";
        if(radID == R.id.radio_chinhthuc){
            employee = new EmployeeFullTime();
        }
        else{
            employee = new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);

        arrayAdapter.notifyDataSetChanged();
    }
}