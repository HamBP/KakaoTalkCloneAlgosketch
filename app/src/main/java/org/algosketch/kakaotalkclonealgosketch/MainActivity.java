package org.algosketch.kakaotalkclonealgosketch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    static final int NUM_PAGES = 4;
    ViewPager2 viewPager;
    FragmentStateAdapter viewPagerAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.content_viewpager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabs);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setIcon(R.drawable.tab_selector_friends);
                                break;
                            case 1:
                                tab.setIcon(R.drawable.tab_selector_chat);
                                break;
                            case 2:
                                tab.setIcon(R.drawable.tab_selector_hashtag);
                                break;
                            case 3:
                                tab.setIcon(R.drawable.tab_selector_etc);
                                break;
                            default:
                                tab.setText("TAB");
                        }
                    }
                }
        ).attach();
    }

    class ViewPagerAdapter extends FragmentStateAdapter {
        ViewPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FriendsFragment();
                case 1:
                case 2:
                case 3:
                default:
                    return new TestFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}