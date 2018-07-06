package com.example.a99544.uidemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a99544.uidemo.R;

/**
 * Created by 99544 on 2017/5/15/015.
 */

public class FriendsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View friendsLayout=inflater.inflate(R.layout.friends_layout,container,false);
        return friendsLayout;
    }
}

