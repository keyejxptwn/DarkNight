package com.keyejxptwn.darknight;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnSwitch;
    private int themes = 0;//默认浅色模式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSwitch = findViewById(R.id.btn_switch);
        btnSwitch.setOnClickListener(this);
        int mode = AppCompatDelegate.getDefaultNightMode();
        if (mode == MODE_NIGHT_YES) {
            btnSwitch.setText(getResources().getString(R.string.text_night));
        } else if (mode == MODE_NIGHT_NO) {
            btnSwitch.setText(getResources().getString(R.string.text_light));
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_switch:
                if (themes == 0) {
                    themes = 1;
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
                } else if (themes == 1) {
                    themes = 0;
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
                    btnSwitch.setText(getResources().getString(R.string.text_light));
                }
                break;
        }
    }
}
