package com.github.tntkhang.fullscreenimageview.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class FullScreenImageViewActivity extends AppCompatActivity {

    public static final String URI_LIST_DATA = "URI_LIST_DATA";
    public static final String IMAGE_FULL_SCREEN_CURRENT_POS = "IMAGE_FULL_SCREEN_CURRENT_POS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_touch_image_view);

        findViewById(R.id.ic_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ViewPager viewPager = findViewById(R.id.view_pager);

        ArrayList<String> imagePaths = getIntent().getStringArrayListExtra(URI_LIST_DATA);

        int currentPos = getIntent().getIntExtra(IMAGE_FULL_SCREEN_CURRENT_POS, 0);

        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager, imagePaths);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPos);
    }
}
