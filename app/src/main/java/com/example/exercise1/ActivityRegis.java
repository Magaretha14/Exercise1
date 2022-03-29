package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRegis extends AppCompatActivity {
    //Deklarasi variabel dengan tipe data EditText
    EditText edrnama, edremail, edrpass, edrrepass;

    //Deklarasi variabel dengan tipe data button
    Button btnregis;

    String rnama, remail;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        edrnama = findViewById(R.id.edRNama);
        edremail = findViewById(R.id.edREmail);
        edrpass = findViewById(R.id.edRPassword);
        edrrepass = findViewById(R.id.edRRepass);
        btnregis = findViewById(R.id.btRegis);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rnama = edrnama.getText().toString();
                remail = edremail.getText().toString();

                if (rnama.isEmpty() && remail.isEmpty())
                {
                    edrnama.setError("Masukan Nama");
                    edremail.setError("Masukan Email");
                }
                else if (edrpass.getText().toString().equals(edrrepass.getText().toString())){
                    Toast.makeText(ActivityRegis.this,"Registrasi Berhasil", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("name", rnama.trim());

                    Intent i = new Intent(ActivityRegis.this,ActivityTask.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(ActivityRegis.this, "Password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
