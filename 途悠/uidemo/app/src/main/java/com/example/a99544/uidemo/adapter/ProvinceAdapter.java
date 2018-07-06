package com.example.a99544.uidemo.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.activity.GoalActivity;
import com.example.a99544.uidemo.activity.MainActivity;
import com.example.a99544.uidemo.activity.SelectSpotActivity;
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.gson.Province;
import com.example.a99544.uidemo.model.City;
import com.example.a99544.uidemo.util.ResourcesUtils;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder>{

    private List<Province> mProvinceList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View provinceView;
        ImageView provinceImage;
        TextView provinceName;
        //Button button;

        public ViewHolder(View view) {
            super(view);
            provinceView = view;
            provinceImage = (ImageView) view.findViewById(R.id.city_image);
            provinceName = (TextView) view.findViewById(R.id.city_name);
        }
    }

    public ProvinceAdapter(List<Province> provinceList) {
        mProvinceList = provinceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.provinceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), SelectSpotActivity.class);
                int position = holder.getAdapterPosition();
                intent.putExtra(MainActivity.AREA_NAME,mProvinceList.get(position).getName());
                if(mProvinceList.get(position).getName().equals("河北省"))
                {
                    intent.putExtra("sight_id","1");
                }
                else if(mProvinceList.get(position).getName().equals("河南省")){
                    intent.putExtra("sight_id","2");
                }
                else if(mProvinceList.get(position).getName().equals("海南省")){
                    intent.putExtra("sight_id","3");
                }
                else if(mProvinceList.get(position).getName().equals("四川省")){
                    intent.putExtra("sight_id","5678");
                }
                else if("福建省".equals(mProvinceList.get(position))){
                    intent.putExtra("sigth_id","4");
                }
                else{
                    intent.putExtra("sight_id","0");
                }
                intent.putExtra(SelectSpotActivity.TYPE,2);
                v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(), "you clicked view " + city.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        /*holder.cityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                City city = mCityList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + city.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Province province = mProvinceList.get(position);
        Glide.with(MyApplication.getContext()).load(ResourcesUtils.getDrableId(MyApplication.getContext(),province.getPic())).into(holder.provinceImage);
        //holder.cityImage.setImageResource(city.getImageId());
        holder.provinceName.setText(province.getName());
    }

    @Override
    public int getItemCount() {
        return mProvinceList.size();
    }

}