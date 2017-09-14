package com.example.root.tb_01;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;

/**
 *用于画首页
 */

public class HomepageFragment extends android.support.v4.app.Fragment{

    private View viewContent;
    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_homepage,container,false);
        initConentView(viewContent);
        initData();

        return viewContent;
    }

    public void initConentView(View viewContent) {
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    public void initData() {
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.home_item_tab);

        //创建一个viewpager的adapter
        HomepageFragmentAdapter adapter = new HomepageFragmentAdapter(getChildFragmentManager(), Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        this.tab_essence.setupWithViewPager(this.vp_essence);


    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        String[] titles = getResources().getStringArray(R.array.home_item_tab);
//        //创建一个viewpager的adapter
//        HomepageFragmentAdapter adapter = new HomepageFragmentAdapter(getFragmentManager(), Arrays.asList(titles));
//        this.vp_essence.setAdapter(adapter);
//    }


}
