package com.example.a99544.uidemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.activity.GoalActivity;
import com.example.a99544.uidemo.activity.MainActivity;


public class MyRouteFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        TextView menu=(TextView) getActivity().findViewById(R.id.route_menu);
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

        Button goal=(Button)getActivity().findViewById(R.id.goal);
        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GoalActivity.class);
                startActivity(intent);
            }
        });

        Button area=(Button)getActivity().findViewById(R.id.area);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myRouteLayout=inflater.inflate(R.layout.my_route_layout,container,false);
        return myRouteLayout;
    }
}
