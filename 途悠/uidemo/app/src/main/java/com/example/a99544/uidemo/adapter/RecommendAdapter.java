package com.example.a99544.uidemo.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a99544.uidemo.R;

import com.example.a99544.uidemo.activity.SpotActivity;
import com.example.a99544.uidemo.activity.StartActivity;
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.model.Recommend;
import com.example.a99544.uidemo.model.Spot;


import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder>{

    private List<Recommend> mRecommendList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View recommendView;
        ImageView userImage;
        ImageView spotImage;
        TextView userId;


        public ViewHolder(View view) {
            super(view);
            recommendView = view;
            userId=(TextView)view.findViewById(R.id.user_id) ;
            userImage=(ImageView)view.findViewById(R.id.user_image) ;
            //spotButton=(Button)view.findViewById(R.id.spot_button);
            spotImage = (ImageView) view.findViewById(R.id.recommend_spot_image);
            //potName = (TextView) view.findViewById(R.id.spot_name);
            //spotDescriprion=(TextView)view.findViewById(R.id.spot_description);
        }
    }

    public RecommendAdapter(List<Recommend> recommendList) {
        mRecommendList = recommendList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend, parent, false);
        final ViewHolder holder = new ViewHolder(view);
       /* holder.spotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                TextView spots=(TextView)view.findViewById(R.id.spots);
            }
        });*/

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recommend recommend= mRecommendList.get(position);
        Glide.with(MyApplication.getContext()).load(recommend.getSpotImagerId()).into(holder.spotImage);
        Glide.with(MyApplication.getContext()).load(recommend.getUserImageId()).into(holder.userImage);
        //holder.spotImage.setImageResource(recommend.getSpotImagerId());
        //holder.userImage.setImageResource(recommend.getUserImageId());
        holder.userId.setText(recommend.getUserid());
       // holder.spotDescriprion.setText(spot.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRecommendList.size();
    }

}