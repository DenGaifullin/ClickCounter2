package com.example.click1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private final String KEY_COUNT = "KEY_COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView detaleTextView = findViewById(R.id.detail_text_view);

        detaleTextView.setText(getString(R.string.count_of_click_string, getIntent().getExtras().getInt(KEY_COUNT)));
    }
}