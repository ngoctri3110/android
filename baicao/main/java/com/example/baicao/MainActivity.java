package com.example.baicao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_mayvoimay, btn_mayvoinguoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_mayvoimay = (Button) findViewById(R.id.btn_may_may);
        btn_mayvoinguoi = (Button) findViewById(R.id.btn_mayvoinguoi);

        btn_mayvoimay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mayvoimay.class);
                startActivity(intent);
            }
        });
        btn_mayvoinguoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, mayvoinguoi.class);
                startActivity(intent1);
            }
        });
    }
}