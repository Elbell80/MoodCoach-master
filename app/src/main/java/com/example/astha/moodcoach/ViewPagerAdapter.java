package com.example.astha.moodcoach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images={R.drawable.fin,R.drawable.fin1,R.drawable.fin2,R.drawable.fin3,R.drawable.nv11,R.drawable.fin5,R.drawable.fin6,R.drawable.nv,R.drawable.fin8,R.drawable.fin9,R.drawable.fin10,R.drawable.fin11};


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.imgview);
        imageView.setImageResource(images[position]);

        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp=(ViewPager) container;
        View view=(View) object;
        vp.removeView(view);
    }
}
