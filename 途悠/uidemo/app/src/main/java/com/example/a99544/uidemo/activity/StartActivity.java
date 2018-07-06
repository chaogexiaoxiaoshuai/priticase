package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.collector.ActivityCollector;

import com.example.a99544.uidemo.fragment.AddFragment;
import com.example.a99544.uidemo.fragment.DiscoverFragement;
import com.example.a99544.uidemo.fragment.FriendsFragment;
import com.example.a99544.uidemo.fragment.MyRouteFragment;

/*
主界面
 */

public class  StartActivity extends BaseActivity implements View.OnClickListener{

    private DiscoverFragement discoverFragement;

    private FriendsFragment friendsFragment;

    private AddFragment addFragment;

    private MyRouteFragment myRouteFragment;

    private FragmentManager fragmentManager;

    private Button discover;

    private Button friends;

    private Button add;

    private Button myRoute;

    private Button sign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initViews();
        fragmentManager=getFragmentManager();
        setTabSelection(0);
        Button exit=(Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVUser.logOut();
                ActivityCollector.finishAll();
            }
        });
        sign = (Button) findViewById(R.id.singn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        if(AVUser.getCurrentUser() != null){
            sign.setText(AVUser.getCurrentUser().getEmail());
        }
    }

    private void initViews(){

        discover=(Button)findViewById(R.id.start_discover);
        friends=(Button)findViewById(R.id.start_friend);
        add=(Button)findViewById(R.id.start_add);
        myRoute=(Button)findViewById(R.id.start_myroute);

        discover.setOnClickListener(this);
        friends.setOnClickListener(this);
        add.setOnClickListener(this);
        myRoute.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(AVUser.getCurrentUser() != null) {
            sign.setText(AVUser.getCurrentUser().getEmail());
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.start_discover:
                setTabSelection(0);
                break;
            case R.id.start_friend:
                setTabSelection(1);
                break;
            case R.id.start_add:
                setTabSelection(2);
                break;
            case R.id.start_myroute:
                setTabSelection(3);
                break;
        }

    }

    private void setTabSelection(int index){

        clearSelection();

        FragmentTransaction transaction=fragmentManager.beginTransaction();

        hideFragments(transaction);

        switch (index){
            case 0:
                discover.setTextColor(Color.BLACK);
                discover.setTextSize(20);
                if(discoverFragement==null){
                    discoverFragement=new DiscoverFragement();
                    transaction.add(R.id.content,discoverFragement);
                }
                else{
                    transaction.show(discoverFragement);
                }
                break;
            case 1:
                friends.setTextColor(Color.BLACK);
                friends.setTextSize(20);
                if(friendsFragment==null){
                    friendsFragment=new FriendsFragment();
                    transaction.add(R.id.content,friendsFragment);
                }
                else {
                    transaction.show(friendsFragment);
                }
                break;
            case 2:
                add.setTextColor(Color.BLACK);
                add.setTextSize(20);
                if(addFragment==null){
                    addFragment=new AddFragment();
                    transaction.add(R.id.content,addFragment);
                }
                else{
                    transaction.show(addFragment);
                }
                break;
            case 3:
                myRoute.setTextColor(Color.BLACK);
                myRoute.setTextSize(20);
                if(myRouteFragment==null){
                    myRouteFragment=new MyRouteFragment();
                    transaction.add(R.id.content,myRouteFragment);
                }
                else {
                    transaction.show(myRouteFragment);
                }
                break;
        }
        transaction.commit();

    }

    private void clearSelection(){

        discover.setTextColor(Color.WHITE);
        discover.setTextSize(18);
        friends.setTextColor(Color.WHITE);
        friends.setTextSize(18);
        add.setTextColor(Color.WHITE);
        add.setTextSize(18);
        myRoute.setTextColor(Color.WHITE);
        myRoute.setTextSize(18);
    }

    private void hideFragments(FragmentTransaction transaction){

        if(discoverFragement!=null){
            transaction.hide(discoverFragement);
        }
        if(friendsFragment!=null){
            transaction.hide(friendsFragment);
        }
        if (addFragment!=null){
            transaction.hide(addFragment);
        }
        if(myRouteFragment!=null){
            transaction.hide(myRouteFragment);
        }

    }

}
