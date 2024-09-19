package com.ceniza.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsContentFragment extends Fragment {

    public NewsContentFragment() {

    }

    public static NewsContentFragment newInstance(String headline, int imageId) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putString("headline", headline);
        args.putInt("imageId", imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);

        TextView contentTextView = view.findViewById(R.id.news_content);
        ImageView contentImageView = view.findViewById(R.id.news_image);

        if (getArguments() != null) {
            String headline = getArguments().getString("headline");
            int imageId = getArguments().getInt("imageId");

            contentTextView.setText("Content for: " + headline);
            contentImageView.setImageResource(imageId);
        }

        return view;
    }
}