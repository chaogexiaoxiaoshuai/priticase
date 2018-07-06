package com.example.a99544.uidemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a99544.uidemo.R;

public class TWOFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View v=inflater.inflate(R.layout.two, container, false);
			ImageView imageView = (ImageView) v.findViewById(R.id.two);
			Glide.with(v.getContext()).load(R.drawable.toutu2).into(imageView);
			return v;
		}

	}


