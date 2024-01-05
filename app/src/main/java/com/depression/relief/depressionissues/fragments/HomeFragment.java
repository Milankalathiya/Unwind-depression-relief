package com.depression.relief.depressionissues.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.depression.relief.depressionissues.R;
import com.depression.relief.depressionissues.adapters.ViewPagerAdapter;
import com.depression.relief.depressionissues.ai.ChatbotActivity;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView questionrecycle;
    ImageView chatbot;
    private ViewPager2 viewPager2;
    private WormDotsIndicator dotsIndicator;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager2 = view.findViewById(R.id.viewPager2);
        dotsIndicator = view.findViewById(R.id.dotsIndicator);
        questionrecycle = view.findViewById(R.id.questionrecycle);
        chatbot = view.findViewById(R.id.chatbot);

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext().getApplicationContext(), ChatbotActivity.class);
                startActivity(intent);
            }
        });

        setupViewPager();
        dotsIndicator.setViewPager2(viewPager2);

        return view;
    }

    private void setupViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ProgressFragment());
        fragmentList.add(new ChartDataFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, fragmentList);
        viewPager2.setAdapter(adapter);
    }
}