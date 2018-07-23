package com.example.huangcl.tablayoutandviewpagerdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List fragmentList= new ArrayList<>();
    private List titleList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        initFragmentList();
        initTitleList();
        initViewAndFunction();
    }

    private void initViewAndFunction() {

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragmentList() {
        for(int i=0;i<4;++i)
            fragmentList.add(new MyFragment("fragment"+(i+1)));
    }

    private void initTitleList() {
        for(int i=0;i<4;++i)
            titleList.add("title"+(i+1));
    }
}
