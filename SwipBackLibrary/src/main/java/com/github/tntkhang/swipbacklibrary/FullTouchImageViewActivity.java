package com.github.tntkhang.swipbacklibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;

public class FullTouchImageViewActivity extends SwipeBackActivity {
    public static final String EXTRA_IMAGE_FULL_SCREEN_URL = "EXTRA_IMAGE_FULL_SCREEN_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_touch_image_view);

        TouchImageView imageView = findViewById(R.id.touch_image_view);
        setDragDirectMode(SwipeBackLayout.DragDirectMode.VERTICAL);

//        byte[] byteArray = getIntent().getByteArrayExtra(EXTRA_IMAGE_FULL_SCREEN_URL);
//        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


        Bitmap bitmap = this.getIntent().getParcelableExtra(EXTRA_IMAGE_FULL_SCREEN_URL);

        Glide.with(this)
                .load(bitmap) // works for Uri or Uri
                .into(imageView);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
