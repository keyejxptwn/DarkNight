package com.keyejxptwn.darknight;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnSwitch;
    private RecyclerView recyclerView;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSwitch = findViewById(R.id.btn_switch);
        recyclerView = findViewById(R.id.rv_list);
        btnSwitch.setOnClickListener(this);
        mode = AppCompatDelegate.getDefaultNightMode();
        if (mode == MODE_NIGHT_YES) {
            btnSwitch.setText(getResources().getString(R.string.text_light));
        } else if (mode == MODE_NIGHT_NO) {
            btnSwitch.setText(getResources().getString(R.string.text_night));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 20;
            }
        });
        recyclerView.setAdapter(new DataAdapter(this));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_switch:
                AppCompatDelegate.setDefaultNightMode(mode == MODE_NIGHT_YES ? MODE_NIGHT_NO : MODE_NIGHT_YES);
                break;
        }
    }
}
