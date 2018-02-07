package com.wuzp.didi.di_tech_sd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wuzp.didi.di_tech_sd.rx.RxActivity;

/**
 * mainActivity just for my self tech improve test
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goActivity();
    }

    private void goActivity() {
        startActivity(new Intent(this, RxActivity.class));
    }
}
