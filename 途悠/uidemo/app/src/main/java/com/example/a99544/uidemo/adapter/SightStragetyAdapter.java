package com.example.a99544.uidemo.adapter;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
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
import com.example.a99544.uidemo.activity.LvChuangActivity;
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.gson.Sight;
import com.example.a99544.uidemo.gson.SightStragety;
import com.example.a99544.uidemo.util.ResourcesUtils;

import java.util.List;

/**
 * Created by 99544 on 2017/10/24.
 */

public class SightStragetyAdapter extends RecyclerView.Adapter<SightStragetyAdapter.ViewHolder> {

    private LocalBroadcastManager mLocalBroadcastManager;

    private List<SightStragety> mSightStragetyList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View sightStragetyView;
        //Button sightAdd;
        ImageView sightStragetyImage;
        TextView sightStragetyName;
        TextView sightStragetyAddress;
        TextView sightStragetyDesc;
        TextView sightStragetyNumber;
        ImageView map;
        ImageView guide;
        ImageView commit;


        public ViewHolder(View view) {
            super(view);
            sightStragetyView = view;
            //sightAdd = (Button) view.findViewById(R.id.sight_add);
            sightStragetyImage = (ImageView) view.findViewById(R.id.total_image);
            sightStragetyName = (TextView) view.findViewById(R.id.total_name);
            sightStragetyDesc = (TextView) view.findViewById(R.id.total_desc);
            sightStragetyAddress = (TextView) view.findViewById(R.id.total_address);
            sightStragetyNumber = (TextView) view.findViewById(R.id.total_number);
            map = (ImageView) view.findViewById(R.id.total_map);
            guide = (ImageView) view.findViewById(R.id.guide);
            commit = (ImageView) view.findViewById(R.id.hot_commit);
        }
    }

    public SightStragetyAdapter(List<SightStragety> sightStragetyList) {
        mSightStragetyList = sightStragetyList;
    }

    @Override
    public SightStragetyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.total, parent, false);
        final SightStragetyAdapter.ViewHolder holder = new SightStragetyAdapter.ViewHolder(view);
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
    public void onBindViewHolder(SightStragetyAdapter.ViewHolder holder, final int position) {

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(MyApplication.getContext());


        holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"功能暂未开放",Toast.LENGTH_SHORT).show();
            }
        });
        holder.guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcast.LOCAL_BROADCAST");
                mLocalBroadcastManager.sendBroadcast(intent);
            }
        });
        holder.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"功能暂未开放",Toast.LENGTH_SHORT).show();
            }
        });

        SightStragety sightStragety= mSightStragetyList.get(position);
        Glide.with(MyApplication.getContext()).load(ResourcesUtils.getDrableId(MyApplication.getContext(),sightStragety.getPic())).into(holder.sightStragetyImage);
        holder.sightStragetyName.setText(sightStragety.getName());
        //holder.sightDesc.setText(sight.getDesc());
        holder.sightStragetyAddress.setText(sightStragety.getAddress());
        holder.sightStragetyNumber.setText(sightStragety.getPhone());
        holder.sightStragetyDesc.setText(sightStragety.getMark());
        /*holder.sightAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"你选择了："+mSightList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mSightStragetyList.size();
    }

}
