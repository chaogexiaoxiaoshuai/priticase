package com.example.a99544.uidemo.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.ProvinceAdapter;
import com.example.a99544.uidemo.adapter.SightAdapter;
import com.example.a99544.uidemo.adapter.SightStragetyAdapter;
import com.example.a99544.uidemo.app.MyApplication;
import com.example.a99544.uidemo.gson.Province;
import com.example.a99544.uidemo.gson.SightStragety;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/*
完整攻略
 */

public class LvChuangActivity extends BaseActivity {

    private LocalBroadcastManager mLocalBroadcastManager;

    private LocalReceiver mLocalReceiver;

    private IntentFilter mIntentFilter;

    private RecyclerView mRecyclerView;

    public static ArrayList<Integer> yourChoices = new ArrayList<>();

    private List<SightStragety> mSightStragetyList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_one);

        mIntentFilter = new IntentFilter();
        mLocalReceiver = new LocalReceiver();
        mIntentFilter.addAction("com.example.broadcast.LOCAL_BROADCAST");
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.registerReceiver(mLocalReceiver,mIntentFilter);

        //Toast.makeText(MyApplication.getContext(), SightAdapter.mList.size()+"",Toast.LENGTH_SHORT).show();


        TextView title = (TextView)findViewById(R.id.title);

        title.setText("您的旅创");

        Button save = (Button)findViewById(R.id.save_plan);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SightAdapter.mList.clear();
                ChuGaoActivity.sightList.clear();
                Toast.makeText(MyApplication.getContext(),"攻略已保存",Toast.LENGTH_SHORT).show();
            }
        });

        Button back = (Button)findViewById(R.id.back_1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SightAdapter.mList.clear();
                ChuGaoActivity.sightList.clear();
                Intent intent = new Intent(LvChuangActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);//使用瀑布流布局
        mRecyclerView = (RecyclerView) findViewById(R.id.total_gonglue);
        mRecyclerView.setLayoutManager(layoutManager);
        initStragety();
        SightStragetyAdapter adapter = new SightStragetyAdapter(mSightStragetyList);
        mRecyclerView.setAdapter(adapter);
    }

    private void initStragety(){
        //String data = "[{\"address\":\"山西省xxx\",\"dayToPlay\":\"\",\"id\":1,\"labels\":[],\"mark\":\"天河山是一个...\",\"name\":\"天河山\",\"phone\":\"\",\"pic\":\"tianheshan\",\"province\":\"山西\",\"ticketPrice\":0}]";
        //Gson gson = new Gson();
        //List<SightStragety> list = gson.fromJson(data, new TypeToken<List<SightStragety>>(){}.getType());
        mSightStragetyList.addAll(ChuGaoActivity.sightList);
    }

    public  void showMultiChoiceDialog() {
        final String[] items = { "白云旅行社，联系电话：13772024362","星光旅行社，联系电话：18602435553","缘梦旅行社，联系电话：13772154823"};
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[]={false,false,false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog =
                new AlertDialog.Builder(LvChuangActivity.this);
        multiChoiceDialog.setTitle("请选择旅行社");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            yourChoices.add(which);
                        } else {
                            yourChoices.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = yourChoices.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[yourChoices.get(i)] + " ";
                        }
                        Toast.makeText(LvChuangActivity.this,
                                "你选择了" + str,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        multiChoiceDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            showMultiChoiceDialog();
        }
    }
}
