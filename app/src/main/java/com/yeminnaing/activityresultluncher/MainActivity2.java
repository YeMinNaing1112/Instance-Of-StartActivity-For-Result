package com.yeminnaing.activityresultluncher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText et_main2;
    Button btn_main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et_main2 = findViewById(R.id.et_main2);
        btn_main2 = findViewById(R.id.btn_main2);
        btn_main2.setOnClickListener(view -> {
            String message = et_main2.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("message", message);
            setResult(Activity.RESULT_OK, intent);
            finish();

        });
    }
}