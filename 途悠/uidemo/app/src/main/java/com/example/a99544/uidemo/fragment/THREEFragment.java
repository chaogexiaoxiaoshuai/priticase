package com.example.a99544.uidemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.activity.SplashActivity;
import com.example.a99544.uidemo.activity.StartActivity;

public class THREEFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.three, container, false);
		Button button = (Button)v.findViewById(R.id.into);
		ImageView imageView = (ImageView) v.findViewById(R.id.three);
		Glide.with(v.getContext()).load(R.drawable.toutu3).into(imageView);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getContext(), StartActivity.class);
				startActivity(intent);
				getActivity().finish();
			}

		});
		return v;
	}
}
