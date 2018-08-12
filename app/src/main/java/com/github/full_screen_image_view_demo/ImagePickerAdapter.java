package com.github.full_screen_image_view_demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.tntkhang.fullscreenimageview.library.FullScreenImageViewActivity;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerAdapter extends RecyclerView.Adapter<ImagePickerAdapter.ViewHolder> {

    private List<Uri> mItems;
    private Context context;
    private RecyclerView recyclerView;

    public ImagePickerAdapter(RecyclerView recyclerView, Context context, List<Uri> items) {
        this.context = context;
        mItems = items;
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_image_picker_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item = mItems.get(position);

        Glide.with(context)
                .load(holder.item)
                .into(holder.ivItem);

        holder.ivItem.setOnClickListener(view -> {
            Intent fullImageIntent = new Intent(context, FullScreenImageViewActivity.class);
            ArrayList<String> uriString = new ArrayList<>();
            for (Uri uri : mItems) {
                uriString.add(uri.toString());
            }
            fullImageIntent.putExtra(FullScreenImageViewActivity.URI_LIST_DATA, uriString);
            fullImageIntent.putExtra(FullScreenImageViewActivity.IMAGE_FULL_SCREEN_CURRENT_POS, position);
            context.startActivity(fullImageIntent);
        });
        holder.ivCancel.setOnClickListener(view -> removeItem(holder.item));
    }

    public void updateListItem(List<Uri> data) {
        mItems.clear();
        mItems.addAll(data);
        notifyDataSetChanged();
    }

    public void addItem(Uri uri) {
        mItems.add(uri);
        notifyItemInserted(mItems.size());
        recyclerView.scrollToPosition(mItems.size());
    }

    public void removeItem(Uri item) {
        int index = mItems.indexOf(item);
        mItems.remove(item);
        notifyItemRemoved(index);
    }

    public List<Uri> getAllImages() {
        return mItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItem;
        ImageView ivCancel;
        public Uri item;

        public ViewHolder(View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
            ivCancel = itemView.findViewById(R.id.iv_cancel);
        }
    }


}
                                