package com.ceniza.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadlineListFragment extends Fragment {

    private String[] headlines = {
            "European Court of Justice annuls USD1.7B fine on Google",
            "New XEC Covid variant starting to spread",
            "Pangasinan celebrates IPs in museum’s anniversary",
            "Reduced DMW budget for 2025 to hurt programs for OFWs: solon",
            "PDEA files raps vs. ‘top priority’ drug suspect in Camiguin bust",
            "P34-M shabu seized in Tagbilaran City sting op",
            "Cops identify suspects in Maguindanao Sur town exec’s murder",
            "Cops seize P1.3-M shabu in Bacolod City",
            "Bicol cops seize P9-M illegal drugs, nab 144 suspects in August",
            "DSWD-Bicol readies P220-M relief items amid bad weather "


    };

    private int[] imageIds = {
            R.drawable.news_image_1,
            R.drawable.news_image_2,
            R.drawable.news_image_3,
            R.drawable.news_image_4,
            R.drawable.news_image_5,
            R.drawable.news_image_6,
            R.drawable.news_image_7,
            R.drawable.news_image_8,
            R.drawable.news_image_9,
            R.drawable.news_image_10,
    };

    public HeadlineListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_headline_list, container, false);

        ListView listView = view.findViewById(R.id.headline_list);
        NewsListAdapter adapter = new NewsListAdapter(getActivity(), headlines, imageIds);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedHeadline = headlines[position];
                int selectedImageId = imageIds[position];
                ((MainActivity) getActivity()).showNewsContent(selectedHeadline, selectedImageId);
            }
        });

        return view;
    }
}