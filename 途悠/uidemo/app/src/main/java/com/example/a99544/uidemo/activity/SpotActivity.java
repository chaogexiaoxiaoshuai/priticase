package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.SpotAdapter;
import com.example.a99544.uidemo.model.Spot;

import java.util.ArrayList;
import java.util.List;
/*
景点选择，暂时弃用
 */
public class SpotActivity extends BaseActivity {

    private List<Spot> spotList=new ArrayList<Spot>();

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_choosespot);
        /*
        TextView title=(TextView)findViewById(R.id.title);
        title.setText("选择景点");

        TextView spots=(TextView)findViewById(R.id.spots);
        //spots.setText("test");


       StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);//使用瀑布流布局
        mRecyclerView = (RecyclerView) findViewById(R.id.rv2);
        mRecyclerView.setLayoutManager(layoutManager);
        initSpot();
        SpotAdapter adapter = new SpotAdapter(spotList);
        mRecyclerView.setAdapter(adapter);

        Button next=(Button)findViewById(R.id.spot_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SpotActivity.this,DateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initSpot(){
        Spot bingmayong=new Spot("兵马俑",R.mipmap.ic_launcher000,"兵马俑");
        spotList.add(bingmayong);
        Spot huaqingchi=new Spot("华清池",R.mipmap.ic_launcher000,"华清池");
        spotList.add(huaqingchi);
        Spot dayangta=new Spot("大雁塔",R.mipmap.ic_launcher000,"大雁塔");
        spotList.add(dayangta);
        Spot zhonglou=new Spot("钟楼",R.mipmap.ic_launcher000,"钟楼");
        spotList.add(zhonglou);
        Spot gulou=new Spot("鼓楼",R.mipmap.ic_launcher000,"鼓楼");
        spotList.add(gulou);
        Spot chengqiang=new Spot("城墙",R.mipmap.ic_launcher000,"城墙");
        spotList.add(chengqiang);
    }*/
    }

}
