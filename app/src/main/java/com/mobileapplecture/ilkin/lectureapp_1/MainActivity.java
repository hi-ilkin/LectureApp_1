package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kullanici ismi-sifre bilgileri
        final String input_userName = "";
        final String input_pass = "";

        // giris yapin olan kullanicinin kisisel bilgileri
        final String name = "İlkin";
        final String surname = "Hüseynli";

        final Button btn_clr_content = (Button) findViewById(R.id.btn_temizle);
        final Button btn_send = (Button) findViewById(R.id.btn_gonder);

        final TextView txt_kullaniciAdi = (TextView) findViewById(R.id.txt_kullaniciAdi);
        final TextView txt_sifre = (TextView) findViewById(R.id.txt_sifre);

        // Sil butonuna tiklandiginda aktif olur, girdileri temizler
        btn_clr_content.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                txt_kullaniciAdi.setText("");
                txt_sifre.setText("");

            }
        });

        // Gonder butonuno tiklandiginda, girdilerin dogrulugunu kontrol edip, ona gore bir sonuc uretir
        btn_send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // kullanici ismi-sifre dogruluk kontrolu
                if (txt_kullaniciAdi.getText().toString().equals(input_userName) && txt_sifre.getText().toString().equals(input_pass)) {
                    Toast.makeText(MainActivity.this, R.string.msg_login_successful, Toast.LENGTH_SHORT).show();

                    // explicit intent olusturma ve gerekli degerleri gonderme
                    Intent informationIntent = new Intent(MainActivity.this, InformationActivity.class);

                    informationIntent.putExtra("key_name", name);
                    informationIntent.putExtra("key_surname", surname);
                    startActivity(informationIntent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left );

                    // hatali giris
                } else {
                    Toast.makeText(MainActivity.this, R.string.msg_failed_login, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



/*

    public void clr_content(View view){
        TextView txt_kullaniciAdi = (TextView) findViewById(R.id.txt_kullaniciAdi);
    TextView txt_sifre = (TextView) findViewById(R.id.txt_sifre);
        txt_kullaniciAdi.setText("");
        txt_sifre.setText("");
}*/


}
