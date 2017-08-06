package org.wangchenlong.wcl_onboarding_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_b_center) Button mBCenter;
    @Bind(R.id.main_b_placeholder) Button mBPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBCenter.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CenterActivity.class)));

        mBPlaceholder.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, PlaceholderActivity.class)));
    }
}
