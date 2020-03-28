package com.example.reader.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.reader.R;
import com.example.reader.Utils.FastBlur;
import com.example.reader.adapter.MyPagerAdapter;
import com.example.reader.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;


public class HotFragment extends Fragment {
    private ViewPager myViewPager;
    private ArrayList<View> aList;
    private MyPagerAdapter myPagerAdapter;
    int [] images = {R.mipmap.yzwb,R.mipmap.rmrb,R.mipmap.xdkb};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot, container, false);//实例化根视图，只能实例化一次

        myViewPager = view.findViewById(R.id.paper_gallery);
        myViewPager.setPageTransformer(true, new ZoomOutPageTransformer());//设置viewPager的切换动画


        aList = new ArrayList<>();
        for(int image:images){
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(image);
            aList.add(imageView);
        }
        myPagerAdapter = new MyPagerAdapter(aList);


        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setCurrentItem((int)(aList.size()/2));
        return view;//
    }
}
