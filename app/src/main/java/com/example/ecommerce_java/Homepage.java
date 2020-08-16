package com.example.ecommerce_java;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.ecommerce_java.databinding.FragmentHomepageBinding;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homepage extends Fragment {

    CarouselView carouselView;

    private DrawerLayout drawerLayout;
    AppBarConfiguration appBarConfiguration;

    private FragmentHomepageBinding fragmentHomepageBinding;
//    ARRAY of int
    int[] sampleImages = {R.drawable.first, R.drawable.second, R.drawable.third};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


//image listener
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };

//        object for fragment inflation


            fragmentHomepageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false);
//        View v =  inflater.inflate(R.layout.fragment_homepage, container, false);


//
        carouselView = fragmentHomepageBinding.carouselView;
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
//        returning object
        setHasOptionsMenu(true);
        return fragmentHomepageBinding.getRoot();

    }






}
