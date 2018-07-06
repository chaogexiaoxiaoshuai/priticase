package com.example.a99544.uidemo.adapter;

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
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.gson.Sight;
import com.example.a99544.uidemo.util.ResourcesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99544 on 2017/10/23.
 */

public class SightAdapter extends RecyclerView.Adapter<SightAdapter.ViewHolder> {

    private List<Sight> mSightList;

    public static List<Integer> mList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        View sightView;
        Button sightAdd;
        ImageView sightImage;
        TextView sightName;
        TextView sightCity;
        TextView sightDesc;
        TextView sightPeop;


        public ViewHolder(View view) {
            super(view);
            sightView = view;
            sightAdd = (Button) view.findViewById(R.id.sight_add);
            sightImage = (ImageView) view.findViewById(R.id.sight_image);
            sightName = (TextView) view.findViewById(R.id.sight_name);
            sightDesc = (TextView) view.findViewById(R.id.sight_desc);
            sightCity = (TextView) view.findViewById(R.id.sight_city);
            sightPeop = (TextView) view.findViewById(R.id.sight_peop);
        }
    }

    public SightAdapter(List<Sight> sightList) {
        mSightList = sightList;
    }

    @Override
    public SightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sight_item, parent, false);
        final SightAdapter.ViewHolder holder = new SightAdapter.ViewHolder(view);
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
    public void onBindViewHolder(final SightAdapter.ViewHolder holder, final int position) {
        Sight sight= mSightList.get(position);
        Glide.with(MyApplication.getContext()).load(ResourcesUtils.getDrableId(MyApplication.getContext(),sight.getPic())).into(holder.sightImage);
        holder.sightName.setText(sight.getName());
        //holder.sightDesc.setText(sight.getDesc());
        holder.sightPeop.setText(sight.getPeopleType());
        holder.sightCity.setText(sight.getCity());
        holder.sightAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mList.contains(mSightList.get(position).getId()))
                {
                    mList.remove(mList.indexOf(mSightList.get(position).getId()));
                    holder.sightAdd.setBackgroundResource(R.drawable.plus);
                    Toast.makeText(MyApplication.getContext(),"您取消了："+mSightList.get(position).getName(),Toast.LENGTH_SHORT).show();

                }
                else{
                    mList.add(mSightList.get(position).getId());
                    holder.sightAdd.setBackgroundResource(R.drawable.ic_checked);
                    Toast.makeText(MyApplication.getContext(),"您选择了："+mSightList.get(position).getName(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mSightList.size();
    }

}
