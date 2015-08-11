package com.siddhanta.wallpaperchangerversion2;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Sidd.c on 11/8/2015.
 */
public class myListener implements OnPageChangeListener{

    OnPageChangeListener pageListener;
    Context cont;


    public myListener(myListener listener){
        pageListener=listener;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        pageListener = listener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this.cont,"Selected something ALUUUUU " + position,Toast.LENGTH_SHORT).show();
    }


}