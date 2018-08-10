package com.github.swipebackdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.tntkhang.swipbacklibrary.FullTouchImageViewActivity;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivContain = findViewById(R.id.iv_contain);

//        final byte[] byteArray = resourceToByteArray();
        final Bitmap tntkhangBmp = BitmapFactory.decodeResource(getResources(), R.drawable.tntkhang);

        ivContain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fullImageIntent = new Intent(MainActivity.this, FullTouchImageViewActivity.class);
                fullImageIntent.putExtra(FullTouchImageViewActivity.EXTRA_IMAGE_FULL_SCREEN_URL, tntkhangBmp);
                startActivity(fullImageIntent);
            }
        });
    }

    private byte[] resourceToByteArray() {
        final Bitmap tntkhangBmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        tntkhangBmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
