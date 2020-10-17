package org.algosketch.kakaotalkclonealgosketch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainLayout;
    ViewPager contentViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_linear_layout);
        contentViewPager = findViewById(R.id.content_viewpager);

        contentViewPager.setAdapter(new ContentViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(contentViewPager);
    }

    class ContentViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments = new ArrayList<Fragment>();
        private String titles[] = new String[] {"friends", "chatting", "hashtag", "etc"};

        public ContentViewPagerAdapter(FragmentManager fm) {
            super(fm);
            //fragments.add(); TODO : 각 프레그먼트 구현 후 추가하기
            //fragments.add();
            //fragments.add();
            //fragments.add();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return this.titles[position];
        }
    }
}