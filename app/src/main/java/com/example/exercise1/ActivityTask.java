package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityTask extends AppCompatActivity {
    EditText edtask, edjenis, edtime;
    FloatingActionButton btnfloat;
    TextView tnama;

    String stask, sjenis, stime;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnSubmit) {
            stask = edtask.getText().toString();
            sjenis = edjenis.getText().toString();
            stime = edtime.getText().toString();

            if (stask.isEmpty() && sjenis.isEmpty() && stime.isEmpty()) {
                Toast.makeText(ActivityTask.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            else if (stask.isEmpty()) {
                edtask.setError("wajib diisi!!");
            } else if (sjenis.isEmpty()) {
                edjenis.setError("wajib diisi!!");
            } else if (stime.isEmpty()) {
                edtime.setError("wajib diisi!!");
            }
            else {
                Toast.makeText(ActivityTask.this, "Berhasil", Toast.LENGTH_SHORT).show();
                Bundle bl = new Bundle();
                bl.putString("Task", stask.trim());
                bl.putString("Jenis", sjenis.trim());
                bl.putString("Time", stime.trim());

                Intent i = new Intent(ActivityTask.this, activity_tampiltask.class);
                i.putExtras(bl);
                startActivity(i);
            }
        } else {
            Intent i = new Intent(ActivityTask.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tnama = findViewById(R.id.tvNama3);
        edtask = findViewById(R.id.edTask);
        edjenis = findViewById(R.id.edJenisTask);
        edtime = findViewById(R.id.edTimeTask);
        btnfloat = findViewById(R.id.btnFloat);

        Bundle bu = getIntent().getExtras();
        String tname = bu.getString("name");
        tnama.setText(tname);

        btnfloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ve) {
                stask = edtask.getText().toString();
                sjenis = edjenis.getText().toString();
                stime = edtime.getText().toString();

                if (stask.isEmpty() && sjenis.isEmpty() && stime.isEmpty()) {
                    Toast.makeText(ActivityTask.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else if (stask.isEmpty()) {
                    edtask.setError("wajib diisi!!");
                } else if (sjenis.isEmpty()) {
                    edjenis.setError("wajib diisi!!");
                } else if (stime.isEmpty()) {
                    edtime.setError("wajib diisi!!");
                }
                else {
                    Toast.makeText(ActivityTask.this, "Berhasil", Toast.LENGTH_SHORT).show();
                    Bundle bu = new Bundle();
                    bu.putString("Task", stask.trim());
                    bu.putString("Jenis", sjenis.trim());
                    bu.putString("Time", stime.trim());

                    Intent i = new Intent(ActivityTask.this, activity_tampiltask.class);
                    i.putExtras(bu);
                    startActivity(i);
                }
            }
        });
    }
}
