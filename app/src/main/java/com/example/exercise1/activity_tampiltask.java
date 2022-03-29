package com.example.exercise1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_tampiltask extends AppCompatActivity{
    TextView dtask, djenis, dtime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampiltask);

        dtask = findViewById(R.id.edTampiltask);
        djenis = findViewById(R.id.edTampiljentask);
        dtime = findViewById(R.id.edTampiltimetask);

        Bundle bu = getIntent().getExtras();

        String dTask = bu.getString("Task");
        String dJenis = bu.getString("Jenis");
        String dTime = bu.getString("Time");

        dtask.setText(dTask);
        djenis.setText(dJenis);
        dtime.setText(dTime);
    }
}
