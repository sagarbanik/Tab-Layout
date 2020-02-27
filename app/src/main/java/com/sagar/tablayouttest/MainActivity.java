package com.sagar.tablayouttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.sagar.tablayouttest.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        //tabLayout.addTab(new TabLayout.Tab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        /*Fragment1 fragment1 = new Fragment1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment1).commit();*/

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tabPosition = tab.getPosition();
                viewPager.setCurrentItem(tabPosition);



                /*switch (tabPosition){

                    case 0:
                        Fragment1 fragment1 = new Fragment1();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment1).commit();
                        break;

                    case 1:
                        Fragment2 fragment2 = new Fragment2();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.fragmentContainer,fragment2).commit();
                        break;

                    case 2:
                        Fragment3 fragment3 = new Fragment3();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        fragmentManager3.beginTransaction().replace(R.id.fragmentContainer,fragment3).commit();
                        break;

                    default:
                        break;

                }*/

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
