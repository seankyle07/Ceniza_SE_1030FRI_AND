package com.ceniza.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class NewsListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] headlines;
    private final int[] imageIds;

    public NewsListAdapter(@NonNull Context context, String[] headlines, int[] imageIds) {
        super(context, R.layout.news_list_item, headlines);
        this.context = context;
        this.headlines = headlines;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.news_list_item, parent, false);
        }

        TextView headlineTextView = convertView.findViewById(R.id.headline_text);
        ImageView thumbnailImageView = convertView.findViewById(R.id.headline_image);

        headlineTextView.setText(headlines[position]);
        thumbnailImageView.setImageDrawable(ContextCompat.getDrawable(context, imageIds[position]));

        return convertView;
    }
}