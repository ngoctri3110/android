package com.example.baicao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class mayvoimay extends AppCompatActivity {
    int manghinhbai[]={
            R.drawable.ah,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.jh,R.drawable.qh,R.drawable.kh,
            R.drawable.ad,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.jd,R.drawable.qd,R.drawable.kd,
            R.drawable.ac,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.jc,R.drawable.qc,R.drawable.kc,
            R.drawable.as,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.js,R.drawable.qs,R.drawable.ks,
    };

    Button btn_batdau, btn_ketthuc;
    EditText et_time;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayvoimay);


        ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
        TextView tv_ketqua_may = (TextView) findViewById(R.id.textView_kq1);

        ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
        ImageView iv6 = (ImageView) findViewById(R.id.imageView6);
        TextView tv_ketqua_nguoi = (TextView) findViewById(R.id.textView_kq2);


        btn_batdau = (Button) findViewById(R.id.button_choi);
        btn_ketthuc = (Button) findViewById(R.id.button_ketthuc);
        et_time = (EditText) findViewById(R.id.editText_time);
        btn_batdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new CountDownTimer(Integer.parseInt(et_time.getText().toString()) *1000,2000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int value[] = new int[6];
                        value = layBaSoNgauNhien(0, 51);

                        int iv_may[] = new int[3];
                        iv_may[0] = value[0];
                        iv1.setImageResource(manghinhbai[iv_may[0]]);
                        iv_may[1] = value[1];
                        iv2.setImageResource(manghinhbai[iv_may[1]]);
                        iv_may[2] = value[2];
                        iv3.setImageResource(manghinhbai[iv_may[2]]);
                        tv_ketqua_may.setText(tinhKetQua(iv_may));

                        int iv_nguoi[] = new int[3];
                        iv_nguoi[0] = value[3];
                        iv4.setImageResource(manghinhbai[iv_nguoi[0]]);
                        iv_nguoi[1] = value[4];
                        iv5.setImageResource(manghinhbai[iv_nguoi[1]]);
                        iv_nguoi[2] = value[5];
                        iv6.setImageResource(manghinhbai[iv_nguoi[2]]);
                        tv_ketqua_nguoi.setText(tinhKetQua(iv_nguoi));
                    }

                    @Override
                    public void onFinish() {
                        CountDownTimer t1 = new CountDownTimer(2000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                et_time.setText("Hết giờ rồi!");
                            }
                            @Override
                            public void onFinish() {
                                et_time.setText("");
                            }
                        }.start();
                    }
                }.start();
            }
        });
        btn_ketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });


    }


    private String tinhKetQua(int[] value){
        String ketqua = "";
        if(tinhSoBaiTay(value) == 3){
            ketqua = "Kết quả: 3 tây";
        }else {
            int tong = 0;
            for(int i = 0; i < value.length; i++){
                if(value[i] % 13 < 10)
                    tong += value[i] % 13 + 1;
            }
            if(tong % 10 == 0)
                ketqua = "Kết quả bù, trong đó có " + tinhSoBaiTay(value) +  " tây.";
            else
                ketqua = "Kết quả là " + (tong % 10) + " nút, trong đó có " + tinhSoBaiTay(value) + " tây.";
        }
        return ketqua;
    }
    //----------------------------------------------------------------------------
    private int tinhSoBaiTay(int a[]){
        int k = 0;
        for(int i = 0; i < a.length; i++){
            if((a[i] % 13 >= 10) && (a[i]) % 13 < 13 )
                k++;
        }
        return k;
    }
    //----------------------------------------------------------------------------
    private int[] layBaSoNgauNhien(int min, int max){
        int baso[] = new int[6];
        int i = 0;
        baso[i++] = random(min, max);
        do{
            int k = random(min, max);
            if(!kiemTraTrung(k,baso))
                baso[i++] = k;
        }while (i<6);
        return baso;
    }
    //----------------------------------------------------------------------------
    private boolean kiemTraTrung(int k , int a[]){
        for(int i = 0; i < a.length; i++)
            if(a[i] == k)
                return true;
        return false;
    }
    //----------------------------------------------------------------------------
    private int random(int min, int max){
        return min + (int) (Math.random() * ((max-min) + 1));
    }
}