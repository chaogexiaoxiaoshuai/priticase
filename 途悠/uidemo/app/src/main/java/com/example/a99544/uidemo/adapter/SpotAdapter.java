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
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.model.Spot;


import java.util.List;

/*
同Spot一同废弃
 */

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ViewHolder>{

    private List<Spot> mSpotList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View spotView;
        Button spotButton;
        ImageView spotImage;
        TextView spotName;
        TextView spotDescriprion;


        public ViewHolder(View view) {
            super(view);
            spotView = view;
            spotButton=(Button)view.findViewById(R.id.spot_button);
            spotImage = (ImageView) view.findViewById(R.id.spot_image);
            spotName = (TextView) view.findViewById(R.id.spot_name);
            spotDescriprion=(TextView)view.findViewById(R.id.spot_description);
        }
    }

    public SpotAdapter(List<Spot> spotList) {
        mSpotList = spotList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spot, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.spotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                TextView spots=(TextView)view.findViewById(R.id.spots);
                //spots.setText("test");
                //spots.setText(mSpotList.get(position).getName());
            }
        });
        /*holder.spotView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), SpotActivity.class);
                v.getContext().startActivity(intent);
                int position = holder.getAdapterPosition();
                Spot spot = mSpotList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + spot.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.spotImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Spot spot = mSpotList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + spot.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Spot spot= mSpotList.get(position);
        Glide.with(MyApplication.getContext()).load(spot.getImageId()).into(holder.spotImage);
        //holder.spotImage.setImageResource(spot.getImageId());
        holder.spotName.setText(spot.getName());
        holder.spotDescriprion.setText(spot.getDescription());
    }

    @Override
    public int getItemCount() {
        return mSpotList.size();
    }

}