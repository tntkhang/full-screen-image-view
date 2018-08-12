package com.github.full_screen_image_view_demo;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class ViewImagePicker extends RelativeLayout {
    private RecyclerView recyclerView;
    private ImageView imageBtnCamera;
    private ImagePickerAdapter adapter;

    public ViewImagePicker(Context context) {
        super(context);
        initView(context, null);
    }

    public ViewImagePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ViewImagePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_image_picker, this, true);

        recyclerView = findViewById(R.id.rv_images);
        imageBtnCamera = findViewById(R.id.iv_camera);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setAdapter(List<Uri> items) {
        adapter = new ImagePickerAdapter(recyclerView, getContext(), items);
        recyclerView.setAdapter(adapter);
    }
    public void updateAdapterItem(List<Uri> items) {
        adapter.updateListItem(items);
    }
    public void addItem(Uri uri) {
        adapter.addItem(uri);
        recyclerView.scrollToPosition(adapter.getItemCount());
    }

    public List<Uri> getListImages(){
        return adapter.getAllImages();
    }

    public void setCameraClickAction(FragmentManager fm) {
        imageBtnCamera.setOnClickListener(view ->
            RxImagePicker.with(fm)
                    .requestImage(Sources.CAMERA)
                    .subscribe(this::onPickSuccess, this::onPickFail)
        );
    }

    private void onPickSuccess(Uri result) {
        addItem(result);
    }

    private void onPickFail(Throwable throwable) {
        Toast.makeText(getContext(), String.format("Error: %s", throwable), Toast.LENGTH_SHORT).show();
    }

}
