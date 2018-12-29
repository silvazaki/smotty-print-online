package com.starcom.smotty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class dialog_order_create_success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_order_success);
    }

    public void selesai(View view) {
        onBackPressed();
    }
}
