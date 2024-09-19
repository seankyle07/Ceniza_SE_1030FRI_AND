package com.ceniza.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new HeadlineListFragment());
            transaction.commit();
        } else {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new HeadlineListFragment(), "LIST_FRAGMENT");
            transaction.replace(R.id.content_fragment_container, new NewsContentFragment(), "CONTENT_FRAGMENT");
            transaction.commit();
        }
    }

    public void showNewsContent(String headline, int imageId) {
        NewsContentFragment contentFragment = NewsContentFragment.newInstance(headline, imageId);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, contentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_fragment_container, contentFragment)
                    .commit();
        }
    }
}