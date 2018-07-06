package com.example.a99544.uidemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.gson.SightStragety;
import com.example.a99544.uidemo.util.ResourcesUtils;

import java.util.List;

/**
 * Created by 99544 on 2017/10/24.
 */

public class DraftStragetyAdapter extends RecyclerView.Adapter<DraftStragetyAdapter.ViewHolder> {

    private List<SightStragety> mDraftStragetyList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View draftStragetyView;
        //Button sightAdd;
        ImageView draftStragetyImage;
        TextView draftStragetyName;
        TextView draftStragetyAddress;
        TextView draftStragetyDesc;
        TextView draftStragetyPrice;


        public ViewHolder(View view) {
            super(view);
            draftStragetyView = view;
            //sightAdd = (Button) view.findViewById(R.id.sight_add);
            draftStragetyImage = (ImageView) view.findViewById(R.id.draft_image);
            draftStragetyName = (TextView) view.findViewById(R.id.draft_name_province);
            draftStragetyDesc = (TextView) view.findViewById(R.id.draft_mark);
            draftStragetyAddress = (TextView) view.findViewById(R.id.draft_address);
            draftStragetyPrice = (TextView) view.findViewById(R.id.draft_price);
        }
    }

    public DraftStragetyAdapter(List<SightStragety> draftStragetyList) {
        mDraftStragetyList = draftStragetyList;
    }

    @Override
    public DraftStragetyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.draft_item, parent, false);
        final DraftStragetyAdapter.ViewHolder holder = new DraftStragetyAdapter.ViewHolder(view);
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
    public void onBindViewHolder(DraftStragetyAdapter.ViewHolder holder, final int position) {
        SightStragety sightStragety= mDraftStragetyList.get(position);
        Glide.with(MyApplication.getContext()).load(ResourcesUtils.getDrableId(MyApplication.getContext(),sightStragety.getPic())).into(holder.draftStragetyImage);
        holder.draftStragetyName.setText(sightStragety.getName()+"("+sightStragety.getProvince()+")");
        //holder.sightDesc.setText(sight.getDesc());
        holder.draftStragetyAddress.setText(sightStragety.getAddress());
        holder.draftStragetyPrice.setText(sightStragety.getTicketPrice() + "");
        holder.draftStragetyDesc.setText(sightStragety.getMark());
        /*holder.sightAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"你选择了："+mSightList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mDraftStragetyList.size();
    }

}
