package com.github.tntkhang.fullscreenimageview.library;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

public class ImageFragment extends Fragment {
    private Uri uri;
    private static final String EXTRA_URI = "EXTRA_URI";

    public static ImageFragment newInstance(Uri uri) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_URI, uri.toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            String path = getArguments().getString(EXTRA_URI);
            uri = Uri.parse(path);
        }
        View view = inflater.inflate(R.layout.full_image_item, container, false);
//        TouchImageView ivContent = view.findViewById(R.id.iv_content);

        if (view instanceof TouchImageView) {
            Glide.with(this)
                    .load(uri)
                    .into((TouchImageView)view);
        }

        return view;
    }

}
