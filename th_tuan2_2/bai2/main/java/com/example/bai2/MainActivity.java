package com.example.bai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

        private EditText edt1;
        private EditText edt2;
        private CheckBox ckb;
        private Button btnDangNhap, btnThoat;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edt1 = findViewById(R.id.edtTaiKhoan1);
            edt2 = findViewById(R.id.edtTaiKhoan2);
            ckb = findViewById(R.id.ckbLuuThongTin);
            btnDangNhap = findViewById(R.id.btnDangNhap);
            btnThoat = findViewById(R.id.btnThoat);

            btnThoat.setOnClickListener(v ->{
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(getResources().getString(R.string.message_dialog_exit_title));
                builder.setMessage(getResources().getString(R.string.message_dialog_exit));
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton(getResources().getString(R.string.message_dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.message_dialog_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            });
            btnDangNhap.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(getResources().getString(R.string.message_dialog_login_title));
                if(kiemTraDauVao())
                    if(ckb.isChecked())
                        builder.setMessage(getResources().getString(R.string.message_dialog_login_yes));
                    else
                        builder.setMessage(getResources().getString(R.string.message_dialog_login_no));
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton(getResources().getString(R.string.message_dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            });
        }

        private boolean kiemTraDauVao() {
            if(edt1.length() == 0)
                return false;
            if(edt2.length() == 0)
                return false;
            return true;
        }
    }
