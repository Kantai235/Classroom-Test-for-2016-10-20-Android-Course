package com.example.kantai.smallexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.mainImageButton:
                intent.setClass(this, dockerView.class);
                break;

            case R.id.mainImageView:
                intent.setClass(this, aboutMeView.class);
                break;
        }
        startActivity(intent);
        finish();
    }
}
