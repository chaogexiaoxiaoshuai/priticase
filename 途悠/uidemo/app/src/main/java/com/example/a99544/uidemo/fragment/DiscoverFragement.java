package com.example.a99544.uidemo.fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.RecommendAdapter;
import com.example.a99544.uidemo.model.Recommend;
import java.util.ArrayList;
import java.util.List;


public class DiscoverFragement extends Fragment {
    @Nullable
    private List<Recommend> recommendList=new ArrayList<Recommend>();

    private RecyclerView mRecyclerView;

    private Button reference;

    private Button friendShare;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);//使用瀑布流布局
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.start_recyclerview);
        mRecyclerView.setLayoutManager(layoutManager);
        initRecommend();
        RecommendAdapter adapter = new RecommendAdapter(recommendList);
        mRecyclerView.setAdapter(adapter);


        reference = (Button)getActivity().findViewById(R.id.start_recommend);

        reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                reference.setTextColor(Color.rgb(250,207,57));
                friendShare.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
                friendShare.setTextColor(Color.rgb(0,0,0));
            }
        });

        friendShare = (Button)getActivity().findViewById(R.id.start_friendshare);
        friendShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendShare.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                friendShare.setTextColor(Color.rgb(250,207,57));
                reference.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
                reference.setTextColor(Color.rgb(0,0,0));
            }
        });

        TextView menu = (TextView)getActivity().findViewById(R.id.discover_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout start=(LinearLayout)getActivity().findViewById(R.id.start_drawer);

                DrawerLayout drawerLayout=(DrawerLayout)getActivity().findViewById(R.id.drawer_layout);
                if(drawerLayout.isDrawerOpen(start)){
                    drawerLayout.closeDrawer(start);
                }
                else
                    drawerLayout.openDrawer(start);
            }
        });

        reference.setTextColor(Color.rgb(250,207,57));
        friendShare.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);

        super.onActivityCreated(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View discoverLayout=inflater.inflate(R.layout.discover_layout,container,false);

        return discoverLayout;
    }


    private void initRecommend(){

        for(int i=0;i<10;i++){
            Recommend tuyoulvchuang=new Recommend("途悠旅创",R.mipmap.ic_launcher000,R.drawable.erhai,"这是测试");
            recommendList.add(tuyoulvchuang);
        }
    }
}
