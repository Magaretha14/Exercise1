package com.example.exercise1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    TextView edregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        ednama=findViewById(R.id.edNama);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        edregis = (TextView) findViewById(R.id.edRegis);
        edregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityRegis.class));
            }
        });

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vi) {
                //menyimpan input user di edittext email kedalam variabel nama
                nama = ednama.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                if (nama.equals("Puput") && password.equals("iniPuput")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();
                    b.putString("name", nama.trim());
                    b.putString("pw", password.trim());

                    Intent i = new Intent(MainActivity.this, ActivityTask.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else if (nama.isEmpty()){
                    ednama.setError("Masukkan Nama");
                }
                else if (password.isEmpty()){
                    edpassword.setError("Masukkan Password");
                }
                else if(nama.equals("Puput") && password.equals(password)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                }
                else if(nama.equals(nama) && password.equals("iniPuput")){
                    Toast.makeText(MainActivity.this, "Nama Salah", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Nama dan Password Salah", Toast.LENGTH_LONG).show();
                }

            }


        });

    }
}