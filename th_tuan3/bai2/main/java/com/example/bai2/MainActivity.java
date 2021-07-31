package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone, etemail;
    private Button btnSave;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String NAME = "nameKey";
    public static final String PHONE = "phoneKey";
    public static final String EMAIL = "emailKey";
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUI();
    }

    private void loadUI() {
        etName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etemail = (EditText) findViewById(R.id.et_email);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //nạp thông tin đã lưu lại trước đó

        loadSharedPrefs(sharedPreferences);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo editor từ sharedPrefs
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //lưu trữ các giá trị nhập liệu

                editor.putString(NAME, etName.getText().toString());
                editor.putString(PHONE, etPhone.getText().toString());
                editor.putString(EMAIL, etemail.getText().toString());
                editor.commit();
            }
        });

    }

    private void loadSharedPrefs(SharedPreferences sharedPreferences) {
        String name = sharedPreferences.getString(NAME, "");
        String phone = sharedPreferences.getString(PHONE, "");
        String email = sharedPreferences.getString(EMAIL, "");
        etName.setText(name);
        etPhone.setText(phone);
        etemail.setText(email);
    }
}