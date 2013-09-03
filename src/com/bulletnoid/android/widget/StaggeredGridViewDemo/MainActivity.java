package com.bulletnoid.android.widget.StaggeredGridViewDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btn_stgv;
    Button btn_stgv_ptr;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        btn_stgv = (Button) findViewById(R.id.btn_stgv);
        btn_stgv_ptr = (Button) findViewById(R.id.btn_stgv_ptr);

        btn_stgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, STGVActivity.class);
                startActivity(i);
            }
        });

        btn_stgv_ptr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, STGVWithPTRActivity.class);
                startActivity(i);
            }
        });
    }
}