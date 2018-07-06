package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.SightAdapter;
import com.example.a99544.uidemo.gson.Province;
import com.example.a99544.uidemo.gson.Sight;
import com.example.a99544.uidemo.util.ResourcesUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/*
选择景点
 */

public class SelectSpotActivity extends BaseActivity {

    public static final String TYPE = "type";
    private SightAdapter adapter;
    private OkHttpClient mOkHttpClient=new OkHttpClient();
    private Intent intent ;//= getIntent();
    private List<Sight> sightList=new ArrayList<Sight>();

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_choosespot);
        intent = getIntent();
        Button nextTwo = (Button) findViewById(R.id.sec_choose_next);
        nextTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SightAdapter.mList.size() > 0){
                    Intent intent = new Intent(SelectSpotActivity.this,ChuGaoActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(SelectSpotActivity.this,"别急，您还没有选择景点。",Toast.LENGTH_SHORT).show();

            }
        });

        TextView title = (TextView) findViewById(R.id.title);
        title.setText("选择景点");

        /*
        显示待选择景点
         */
        initSights();
        //StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);//使用瀑布流布局
        mRecyclerView = (RecyclerView) findViewById(R.id.spot_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SightAdapter(sightList);
        mRecyclerView.setAdapter(adapter);
        //Toast.makeText(SelectSpotActivity.this,"长度："+sightList.size(),Toast.LENGTH_LONG).show();

    }
    private void initSights(){


        switch (intent.getIntExtra(TYPE,0)){
            case 0:break;
            case 1:
                //getAsynHttp("http://tuyouchuanglv.duapp.com/tuyouchuanglv/getSight?themeId=4");
                //Toast.makeText(SelectSpotActivity.this,"类型："+intent.getIntExtra(TYPE,0)+intent.getIntExtra(GoalActivity.THEME_ID,0),Toast.LENGTH_SHORT).show();
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                             OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .url("http://tuyouchuanglv.duapp.com/tuyouchuanglv/getSight?themeId=" + intent.getIntExtra(GoalActivity.THEME_ID,0))
                                    .build();

                            Response response = client.newCall(request).execute();
                            String rData = response.body().toString();
                            if(response.code() == 200){
                                String responseData = response.body().toString();
                                Gson gson = new Gson();
                                //Toast.makeText(SelectSpotActivity.this,"length:"+responseData.length(),Toast.LENGTH_LONG).show();
                                List<Sight> list = gson.fromJson(responseData, new TypeToken<List<Sight>>(){}.getType());
                                sightList.addAll(list);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(SelectSpotActivity.this,"length:"+sightList.size(),Toast.LENGTH_LONG).show();
                                        adapter.notifyDataSetChanged();
                                    }
                                });


                            }

                                //initSights();
                            refresh(rData);



                        } catch (Exception e) {
                            //initSights();
                            e.printStackTrace();
                        }
                       // refresh(rData);
                    }
                }).start();*/
                staticInit();

                break;
            case 2:
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpClient client = new OkHttpClient();
                            RequestBody requestBody = new FormBody.Builder()
                                    .add("province",intent.getStringExtra(MainActivity.AREA_NAME))
                                    .build();
                            Request request = new Request.Builder()
                                    .url("http://tuyouchuanglv.duapp.com/tuyouchuanglv/getSight")
                                    .post(requestBody)
                                    .build();
                            Response response = client.newCall(request).execute();
                            String responseData = response.body().toString();
                            Gson gson = new Gson();
                            List<Sight> list = gson.fromJson(responseData,new TypeToken<List<Sight>>(){}.getType());
                            sightList.addAll(list);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
*/
                staticInit2();
                break;
        }


        /*
        通过省或主题id来请求数据
         */

    }

    private void refresh(final String data){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SelectSpotActivity.this,"length:"+sightList.size()+data,Toast.LENGTH_LONG).show();
                //if(sightList.size()>1)
                    adapter.notifyDataSetChanged();
               // else
                    initSights();
            }
        });
    }

    private void staticInit2(){

        Intent intent = getIntent();
        String data;
        String key = intent.getStringExtra("sight_id");
        if(key.equals("1")){
            data = "[{\"city\":\"河北省\",\"dayToPlay\":\"1\",\"id\":1,\"name\":\"天河山\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"tianheshan\"}]";
        }
        else if(key.equals("2")){
            data = "[{\"city\":\"河南省\",\"dayToPlay\":\"1\",\"id\":2,\"name\":\"汝南梁祝墓\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"runanliangzhumu\"}]";
        }
        else if(key.equals("3")){
            data = "[{\"city\":\"海南省\",\"dayToPlay\":\"1-2\",\"id\":3,\"name\":\"三亚\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"sanya\"}]";
        }
        else if(key.equals("4")){
            data = "[{\"city\":\"福建省\",\"dayToPlay\":\"1-2\",\"id\":4,\"name\":\"鼓浪屿\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"gulangyu\"}]";
        }
        else if(key.equals("5678")){
            data = "[{\"city\":\"四川省若尔盖县\",\"dayToPlay\":\"1\",\"id\":5,\"name\":\"花湖\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"huahu\"},{\"city\":\"四川省\",\"dayToPlay\":\"1\",\"id\":6,\"name\":\"黄河第一湾\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"huanghediyiwan\"},{\"city\":\"四川省乐山市\",\"dayToPlay\":\"1-2\",\"id\":7,\"name\":\"乐山大佛\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"leshandafo\"},{\"city\":\"四川省\",\"dayToPlay\":\"1-2\",\"id\":8,\"name\":\"塔公草原\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"tagongcaoyuan\"}]";
        }
        else {
            Toast.makeText(SelectSpotActivity.this,"当前区域暂无推荐，看下别的景点吧！",Toast.LENGTH_SHORT).show();
            data = "[{\"city\":\"四川省若尔盖县\",\"dayToPlay\":\"1\",\"id\":5,\"name\":\"花湖\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"huahu\"},{\"city\":\"四川省\",\"dayToPlay\":\"1\",\"id\":6,\"name\":\"黄河第一湾\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"huanghediyiwan\"},{\"city\":\"四川省乐山市\",\"dayToPlay\":\"1-2\",\"id\":7,\"name\":\"乐山大佛\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"leshandafo\"},{\"city\":\"四川省\",\"dayToPlay\":\"1-2\",\"id\":8,\"name\":\"塔公草原\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"tagongcaoyuan\"},{\"city\":\"河北省\",\"dayToPlay\":\"1\",\"id\":1,\"name\":\"天河山\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"tianheshan\"},{\"city\":\"河南省\",\"dayToPlay\":\"1\",\"id\":2,\"name\":\"汝南梁祝墓\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"runanliangzhumu\"},{\"city\":\"海南省\",\"dayToPlay\":\"1-2\",\"id\":3,\"name\":\"三亚\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"sanya\"},{\"city\":\"福建省\",\"dayToPlay\":\"1-2\",\"id\":4,\"name\":\"鼓浪屿\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"gulangyu\"}]";
        }
        Gson gson = new Gson();
        List<Sight> list = gson.fromJson(data, new TypeToken<List<Sight>>(){}.getType());
        sightList.addAll(list);
    }

    private void staticInit(){
        Intent intent = getIntent();
        int i = intent.getIntExtra(GoalActivity.THEME_ID,0);
        String data;
        if(i == 4){
            data = "[{\"city\":\"河北省\",\"dayToPlay\":\"1\",\"id\":1,\"name\":\"天河山\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"tianheshan\"},{\"city\":\"河南省\",\"dayToPlay\":\"1\",\"id\":2,\"name\":\"汝南梁祝墓\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"runanliangzhumu\"},{\"city\":\"海南省\",\"dayToPlay\":\"1-2\",\"id\":3,\"name\":\"三亚\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"sanya\"},{\"city\":\"福建省\",\"dayToPlay\":\"1-2\",\"id\":4,\"name\":\"鼓浪屿\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"gulangyu\"}]";

        }
        else
        {
            data = "[{\"city\":\"四川省若尔盖县\",\"dayToPlay\":\"1\",\"id\":5,\"name\":\"花湖\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"huahu\"},{\"city\":\"四川省\",\"dayToPlay\":\"1\",\"id\":6,\"name\":\"黄河第一湾\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"huanghediyiwan\"},{\"city\":\"四川省乐山市\",\"dayToPlay\":\"1-2\",\"id\":7,\"name\":\"乐山大佛\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"leshandafo\"},{\"city\":\"四川省\",\"dayToPlay\":\"1-2\",\"id\":8,\"name\":\"塔公草原\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"tagongcaoyuan\"},{\"city\":\"河北省\",\"dayToPlay\":\"1\",\"id\":1,\"name\":\"天河山\",\"peopleType\":\"适合类型:好事多磨型\",\"pic\":\"tianheshan\"},{\"city\":\"河南省\",\"dayToPlay\":\"1\",\"id\":2,\"name\":\"汝南梁祝墓\",\"peopleType\":\"适合类型:欢喜冤家型\",\"pic\":\"runanliangzhumu\"},{\"city\":\"海南省\",\"dayToPlay\":\"1-2\",\"id\":3,\"name\":\"三亚\",\"peopleType\":\"适合类型:甜蜜,热恋型\",\"pic\":\"sanya\"},{\"city\":\"福建省\",\"dayToPlay\":\"1-2\",\"id\":4,\"name\":\"鼓浪屿\",\"peopleType\":\"适合类型:文艺,甜蜜型\",\"pic\":\"gulangyu\"}]";
            Toast.makeText(SelectSpotActivity.this,"当前主题暂无推荐，看下别的景点吧！",Toast.LENGTH_SHORT).show();
        }
        Gson gson = new Gson();
        List<Sight> list = gson.fromJson(data, new TypeToken<List<Sight>>(){}.getType());
        sightList.addAll(list);
        //Toast.makeText(SelectSpotActivity.this,"鼓浪屿图片ID"+ ResourcesUtils.getDrableId(getBaseContext(),"gulangyu"),Toast.LENGTH_LONG).show();
    }

    private void getAsynHttp(final String url) {

        Request.Builder requestBuilder = new Request.Builder().url(url);
        //可以省略，默认是GET请求
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    Gson gson = new Gson();
                    List<Sight> list = gson.fromJson(response.body().toString(), new TypeToken<List<Sight>>(){}.getType());
                    sightList.addAll(list);

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getApplicationContext(), "请求成功"+sightList.size(), Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }


}
