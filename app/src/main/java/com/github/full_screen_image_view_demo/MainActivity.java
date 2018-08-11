package com.github.full_screen_image_view_demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.tntkhang.fullscreenimageview.library.FullScreenImageViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivContain1 = findViewById(R.id.iv_contain1);
        ImageView ivContain2 = findViewById(R.id.iv_contain2);
        ImageView ivContain3 = findViewById(R.id.iv_contain3);

        final Uri uri = Uri.parse("android.resource://" + getPackageName() + "/drawable/android1");
        final Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/drawable/android3");

        final ArrayList<String> uriString = new ArrayList<>();
        uriString.add(uri.toString());
        uriString.add(uri2.toString());
        uriString.add(uri.toString());

        ivContain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickAction(uriString, 0);
            }
        });
        ivContain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickAction(uriString, 1);
            }
        });
        ivContain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickAction(uriString, 2);
            }
        });
    }

    private void onImageClickAction(ArrayList<String> uriString, int pos) {
        Intent fullImageIntent = new Intent(MainActivity.this, FullScreenImageViewActivity.class);
        fullImageIntent.putExtra(FullScreenImageViewActivity.URI_LIST_DATA, uriString);
        fullImageIntent.putExtra(FullScreenImageViewActivity.IMAGE_FULL_SCREEN_CURRENT_POS, pos);
        startActivity(fullImageIntent);

    }
}
