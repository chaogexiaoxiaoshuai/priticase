package com.example.a99544.uidemo.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.ProvinceAdapter;
import com.example.a99544.uidemo.gson.Province;
import com.example.a99544.uidemo.gson.Sight;
import com.example.a99544.uidemo.model.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
选择地域
 */

public class MainActivity extends BaseActivity {

    public static final String AREA_NAME = "area_name";

    private List<Province> provinceList=new ArrayList<Province>();

    private RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title=(TextView)findViewById(R.id.title) ;
        title.setText("选择地域");
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);//使用瀑布流布局
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(layoutManager);
        initProvinces();
        ProvinceAdapter adapter = new ProvinceAdapter(provinceList);
        mRecyclerView.setAdapter(adapter);

    }

    private void initProvinces() {

        /*try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://tuyouchuanglv.duapp.com/tuyouchuanglv/getCity")
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.toString();
            Gson gson = new Gson();
            provinceList = gson.fromJson(responseData,new TypeToken<List<Province>>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String data = "[{\"name\":\"河北省\",\"pic\":\"hebeisheng\"},{\"name\":\"河南省\",\"pic\":\"henansheng\"},{\"name\":\"海南省\",\"pic\":\"hainansheng\"},{\"name\":\"四川省\",\"pic\":\"sichuansheng\"},{\"name\":\"广东省\",\"pic\":\"guangdongsheng\"},{\"name\":\"黑龙江省\",\"pic\":\"heilongjiangsheng\"},{\"name\":\"湖北省\",\"pic\":\"hubeisheng\"},{\"name\":\"吉林省\",\"pic\":\"jilinsheng\"},{\"name\":\"辽宁省\",\"pic\":\"liaoningsheng\"},{\"name\":\"内蒙古\",\"pic\":\"neimenggu\"},{\"name\":\"陕西省\",\"pic\":\"shaanxisheng\"},{\"name\":\"山东省\",\"pic\":\"shandongsheng\"},{\"name\":\"上海市\",\"pic\":\"shanghaishi\"},{\"name\":\"山西省\",\"pic\":\"shanxisheng\"},{\"name\":\"西藏\",\"pic\":\"xizang\"},{\"name\":\"浙江省\",\"pic\":\"zhejiangsheng\"}]";
        //String data = "[{\"province\":\"成都\",\"pic\":\"chengdu\"},{\"province\":\"哈尔滨\",\"pic\":\"haerbin\"},{\"province\":\"呼伦贝尔\",\"pic\":\"hulunbeier\"},{\"province\":\"拉萨\",\"pic\":\"lasa\"}]";
        Gson gson = new Gson();
        List<Province> list = gson.fromJson(data, new TypeToken<List<Province>>(){}.getType());
        provinceList.addAll(list);


        //City beijing=new City("北京",R.drawable.beijing);
        //cityList.add(beijing);
        //City tianjin=new City("天津",R.drawable.tianjin);
        //cityList.add(tianjin);
        /*
        if(cityList == null) {
            City hebei = new City("河北", R.drawable.qinhuangdao);
            cityList.add(hebei);
            City sichuan = new City("四川", R.drawable.sichuan);
            cityList.add(sichuan);
            City neimenggu = new City("内蒙古", R.drawable.hulunbeier);
            cityList.add(neimenggu);
            City liaoning = new City("辽宁", R.drawable.shenyang);
            cityList.add(liaoning);
            City jilin = new City("吉林", R.drawable.jilin);
            cityList.add(jilin);
            City haerbin = new City("哈尔滨", R.drawable.haerbin);
            cityList.add(haerbin);
            City chongqing = new City("重庆", R.drawable.chongqing);
            cityList.add(chongqing);
            City chengdu = new City("成都", R.drawable.chengdu);
            cityList.add(chengdu);

        }*/
    }
}
