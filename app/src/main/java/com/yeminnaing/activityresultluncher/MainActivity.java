package com.yeminnaing.activityresultluncher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_main;
    Button btn_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main=findViewById(R.id.tv_main);
        btn_main=findViewById(R.id.btn_main);

        btn_main.setOnClickListener(view -> {
       Intent intent=new Intent(this,MainActivity2.class);
            activityResultLauncher.launch(intent);
        });


    }
    ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==Activity.RESULT_OK){
                        Intent data = result.getData();
                         String message=data.getStringExtra("message");
                         tv_main.setText(message);
                    }
                }
            }
    );
}