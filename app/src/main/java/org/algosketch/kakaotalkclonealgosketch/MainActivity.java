package org.algosketch.kakaotalkclonealgosketch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("friends");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_selector_friends, null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec = host.newTabSpec("chatting");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_selector_chat, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("issues");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_selector_hashtag, null));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);

        spec = host.newTabSpec("etc");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_selector_etc, null));
        spec.setContent(R.id.tab_content4);
        host.addTab(spec);
    }

}