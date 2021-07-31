package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp_Dm;
    Button btn_nhap;
    EditText et_ma, et_name;
    ListView lv_sp;

    ArrayList<Catalog> arraySpinner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner = null;

    ArrayList<Product> arrayListView = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getWidgetsControl();
       fakeDataCatalog();
       addEventsForFormWidgets();
    }
    private void getWidgetsControl() {
        sp_Dm = (Spinner) findViewById(R.id.spinner_Dm);
        et_ma = (EditText) findViewById(R.id.edittext_maSp);
        et_name = (EditText) findViewById(R.id.edittext_Tensp);
        btn_nhap = (Button) findViewById(R.id.button_nhap);
        lv_sp = (ListView) findViewById(R.id.lv_sp);

        adapterSpinner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_list_item_1, arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Dm.setAdapter(adapterSpinner);

        adapterListView = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,arrayListView);
        lv_sp.setAdapter(adapterListView);
    }


    private void fakeDataCatalog() {
        Catalog ca1 = new Catalog("1", "SamSung");
        Catalog ca2 = new Catalog("2", "Xiaomi");
        Catalog ca3 = new Catalog("3", "Iphone");
        arraySpinner.add(ca1);
        arraySpinner.add(ca2);
        arraySpinner.add(ca3);
        adapterSpinner.notifyDataSetChanged();
    }
    private void addEventsForFormWidgets() {

        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductForCatalog();
            }
        });
        sp_Dm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadListProductByCatalog(arraySpinner.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void addProductForCatalog() {
        Product p = new Product();
        p.setId(et_ma.getText() + "");
        p.setName(et_name.getText() + "");
        Catalog ca = (Catalog) sp_Dm.getSelectedItem();
        ca.addProduct(p);

        loadListProductByCatalog(ca);

    }

    private void loadListProductByCatalog(Catalog ca) {
        arrayListView.clear();
        arrayListView.addAll(ca.getListProduct());
        adapterSpinner.notifyDataSetChanged();
    }

}