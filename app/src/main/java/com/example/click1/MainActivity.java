package com.example.click1;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int count;
    private final String KEY_COUNT = "KEY_COUNT";
    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);

        } else {
            sPref = getPreferences(MODE_PRIVATE);
            count = Integer.parseInt(sPref.getString(KEY_COUNT, "0"));
        }
        TextView countTextView = findViewById(R.id.count_textView);
        countTextView.setText(getString(R.string.count_of_click_string, count));

        Button button = findViewById(R.id.increment_button);
        button .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView countTextView = findViewById(R.id.count_textView);
        countTextView.setText(getString(R.string.count_of_click_string, ++count));
        Button crumbs = findViewById(R.id.crumbs_btn);
        crumbs.setVisibility(View.VISIBLE);
        Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        crumbs.startAnimation(animationTranslate);
        crumbs.setVisibility(View.INVISIBLE);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        Button incrementButton = findViewById(R.id.increment_button);
        incrementButton.startAnimation(animation);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_COUNT, count);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "add");
        MenuItem menuItem = menu.getItem(0);
        menuItem.setIcon(R.drawable.cookie2);
        menuItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(KEY_COUNT, count);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(KEY_COUNT, String.valueOf(count));
        ed.commit();

        super.onStop();

    }
}