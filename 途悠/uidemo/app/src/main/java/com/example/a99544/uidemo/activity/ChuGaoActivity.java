package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.adapter.DraftStragetyAdapter;
import com.example.a99544.uidemo.adapter.SightAdapter;
import com.example.a99544.uidemo.adapter.SightStragetyAdapter;
import com.example.a99544.uidemo.gson.Sight;
import com.example.a99544.uidemo.gson.SightStragety;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
/*
攻略初稿，为两条线路共用
 */

public class ChuGaoActivity extends BaseActivity {

    private List<SightStragety> mFullList = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private DraftStragetyAdapter adapter;

    public static List<SightStragety> sightList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_two);

        TextView gonglue = (TextView)findViewById(R.id.gonglue1);
        gonglue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChuGaoActivity.this,LvChuangActivity.class);
                startActivity(intent);
            }
        });



        TextView title = (TextView)findViewById(R.id.title);
        title.setText("攻略初稿");

        initDraft();
        //StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);//使用瀑布流布局
        mRecyclerView = (RecyclerView) findViewById(R.id.chugao_recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DraftStragetyAdapter(sightList);
        mRecyclerView.setAdapter(adapter);
    }

    private void initDraft(){

        String data = "[{\"address\":\"河北省邢台市\",\"dayToPlay\":\"\",\"id\":1,\"labels\":[],\"mark\":\"天河山位于河北省邢台市，是中国爱情山，中国七夕文化之乡，牛郎织女传说的原生地。天河山是国家AAAA级景区，国家重点风景名胜区、国家地质公园,风景区屹立在晋冀交界处的太行山最绿的地方，总面积30平方公里。\\r\\n天河山距邢台市区50公里，远离都市喧嚣，这里奇峰林立，峡谷幽峻，植被丰茂，林木葱郁；群瀑飞雪，清泉鸣筝，水源丰沛，是著名的“太行水乡”；松涛阵阵，牛羊成群，又称“云顶草原”。早在新石器时代，天河山地区就有人类居住。抗日战争时期，天河山是八路军主要根据地之一。129师医院，冀南银行（中国人民银行前身）等革命遗址，至今保存完好。\\r\\n天河山一带广泛流传着牛郎织女的故事，并拥有大量的文化遗存。经多位专家考证，这里就是牛郎织女故事的原生地。2005年，天河山在国家工商总局注册为“中国爱情山”。2006年，天河山被中国民俗学会命名为“七夕”文化研究基地，被中国民间文艺家协会命名为“中国七夕文化之乡”。2015年我国中原地区第一座山间滑雪场——天河山冰雪大世界建成。 \",\"name\":\"天河山\",\"phone\":\"\",\"pic\":\"tianheshan\",\"province\":\"河北\",\"ticketPrice\":58},{\"address\":\"河南省驻马店市汝南县\",\"dayToPlay\":\"\",\"id\":2,\"labels\":[\"自然\",\"人文\",\"陶冶\",\"历史\"],\"mark\":\" 梁祝墓是梁祝故里的一个主要景点。梁祝故里是梁山伯与祝英台爱情故事的发生地,位于汝南马乡镇。故里遗址现有梁祝墓、梁庄、祝庄、马庄、红罗山书院、鸳鸯池、十八里相送故道、曹桥(草桥)及梁祝师父葬地邹佟墓等。相传,在我国西晋时期,青年学子梁山伯辞家攻读,途遇女扮男装的学子祝英台,两人一见如故,志趣相投,遂于草桥结拜为兄弟,后同到红罗山书院就读。在书院两人朝夕相处,感情日深。三年后,英台返家,山伯十八里相送,二人依依惜别。山伯经师母指点,带上英台留下的蝴蝶玉扇坠到祝家求婚遭拒绝,回家后悲愤交加,一病不起,不治身亡。英台闻山伯为己而死,悲痛欲绝。不久,马家前来迎娶,英台被迫含愤上轿。行至山伯墓前,英台执意下轿,哭拜亡灵,因过度悲痛而死亡,后被葬在山伯墓东侧。\\r\\n一千多年来,梁祝爱情故事久传不衰。这一东方版的《罗密欧与朱丽叶》,不知被多少文艺作品作为经典爱情题材竞相传扬。小提琴协奏典《梁祝》可谓人间仙乐,千古绝唱,听来荡气回肠,余音不绝,多年来一直蜚声海内外。以这一故事为背景的地方戏、民间小调、评书小段、剪纸、绘画以致民风民俗流传甚广。逢年过节,当地群众都会到梁祝墓焚香烧纸,举行各种文娱活动,以示纪念。\\r\\n 1997年中央电视台“文艺采风”栏目又以《千古绝唱出中原》为题对梁祝故里进行了较为详细的报道,该台著名节目主持人周涛与军事天地节目主持人张莉曾来此采访。\\r\\n 2005年12月，汝南县被中国民间文艺家协会命名为“中国梁祝之乡”。2006年6月，汝南梁祝传说又被列入国家首批非物质文化遗产名录。为了更好地保护和开发梁祝文化，扩大驻马店和汝南在全国的知名度,汝南县特申请马乡镇更名为梁祝镇。2007年4月3日，河南省民政厅下发文件：“经省人民政府批准，同意汝南县马乡镇更名为梁祝镇”。原马乡镇行政区域，整体划归梁祝镇管辖。这是我国首个也将会是唯一一个以梁祝命名的地方行政区。\\r\\n 7月19日，梁祝故里河南省汝南马乡镇更名为梁祝镇揭牌庆典仪式在当地举行。来自全省各地研究梁祝文化的专家学者，驻马店市、汝南县有关方面的领导，外地客商和当地干群2000余人冒雨参加了庆典仪式。\\r\\n\",\"name\":\"汝南梁祝墓\",\"phone\":\"\",\"pic\":\"runanliangzhumu\",\"province\":\"河南\",\"ticketPrice\":Free},{\"address\":\"海南省三亚市\",\"dayToPlay\":\"\",\"id\":3,\"labels\":[\"沙滩\",\"热恋\",\"自然\",\"浪漫\"],\"mark\":\"三亚（Sanya）位于海南岛的最南端，具有热带海滨风景特色的国际旅游城市 ，中国海滨城市，是中国空气质量最好的城市之一、全国最长寿地区（平均寿命80岁）。 三亚市别称鹿城，又被称为“东方夏威夷”，位居中国四大一线旅游城市“三威杭厦”之首，拥有全岛最美丽的海滨风光。\\r\\n三亚市东邻陵水县，西接乐东县，北毗保亭县，南临南海。陆地总面积1919.58平方千米，海域总面积6000平方千米，其中规划市区面积约37平方公里。东西长91.6公里，南北宽51公里，2016年常住人口为58.23万人，聚居了汉、黎、苗、回等20多个民族。三亚是海南省南部的中心城市和交通通信枢纽，也是中国东南沿海对外开放黄金海岸线上最南端的对外贸易重要口岸之一。 \",\"name\":\"三亚\",\"phone\":\"\",\"pic\":\"sanya\",\"province\":\"海南\",\"ticketPrice\":Free},{\"address\":\"福建省厦门市思明区\",\"dayToPlay\":\"\",\"id\":4,\"labels\":[],\"mark\":\"鼓浪屿（英文：Kulangsu） 原名“圆沙洲”，别名“圆洲仔”，南宋时期命“五龙屿”，明朝改称“鼓浪屿”。因岛西南方海滩上有一块两米多高、中有洞穴的礁石，每当涨潮水涌，浪击礁石，声似擂鼓，人们称“鼓浪石”，鼓浪屿因此而得名。因涨潮水涌，浪击礁石，声似擂鼓而得名。鼓浪屿街道短小，纵横交错，是厦门最大的一个屿。\\r\\n鼓浪屿全岛的绿地覆盖率超过40%，植物种群丰富，各种乔木、灌木、藤木、地被植物共90余科，1000余种。代表景点有：日光岩、菽庄花园、皓月园、毓园、鼓浪石、鼓浪屿钢琴博物馆、郑成功纪念馆、海底世界、天然海滨浴场、海天堂构等。\\r\\n鼓浪屿风景名胜区获得国家5A级旅游景区、全国重点文物保护单位、中国最美五大城区等荣誉。2017年7月8日，“鼓浪屿：国际历史社区” 被列入世界遗产名录，成为中国第52项世界遗产项目。\",\"name\":\"鼓浪屿\",\"phone\":\"\",\"pic\":\"gulangyu\",\"province\":\"福建\",\"ticketPrice\":Free},{\"address\":\"四川省若尔盖县\",\"dayToPlay\":\"\",\"id\":5,\"labels\":[\"自然\",\"生态\",\"诗意\",\"朦胧\"],\"mark\":\"花湖位于四川若尔盖和甘肃郎木寺之间的213国道旁，是热尔大坝草原上的一个天然海子。热尔大坝是我国仅次于呼伦贝尔大草原的第二大草原，海拔3468米。花湖经典的时间是在五六月份，湖畔五彩缤纷，好像云霞委地，而湖中则开满了水妖一样的绚丽花朵，这种植物看起来平淡无奇，在雨水充沛的八月把纯蓝的湖水染成淡淡的藕色，时深时浅，像少女思春时低头的一抹酡红。\\r\\n\",\"name\":\"花湖\",\"phone\":\"\",\"pic\":\"huahu\",\"province\":\"四川\",\"ticketPrice\":750},{\"address\":\"四川省若尔盖县唐克乡\",\"dayToPlay\":\"\",\"id\":6,\"labels\":[\"自然\",\"奇观\",\"壮丽\",\"磅礴\"],\"mark\":\"当黄河冲出巴彦克拉山谷之后，一改咆哮千里之势，在阿尼玛泽山和西泽山之间绕了一个443公里的大弯，形成了黄河第一曲——玛曲。站在玛曲的黄河岸边，看黄河凝重的流淌，那一刻的心情很难表述。黄河在玛曲草原的绵长回转，在高原人的心中却是人们对母亲河的留恋，之后，黄河母亲听到儿女的呼唤，百折回头又进入了高原大地。遂有了“天下黄河九曲十八弯”的首曲奇观。\",\"name\":\"黄河第一弯\",\"phone\":\"\",\"pic\":\"huanghediyiwan\",\"province\":\"四川\",\"ticketPrice\":100},{\"address\":\"四川省\",\"dayToPlay\":\"\",\"id\":7,\"labels\":[],\"mark\":\"乐山大佛，又名凌云大佛，位于四川省乐山市南岷江东岸凌云寺侧，濒大渡河、青衣江和岷江三江汇流处。大佛为弥勒佛坐像，通高71米，是中国最大的一尊摩崖石刻造像。\\r\\n乐山大佛开凿于唐代开元元年（713年），完成于贞元十九年（803年），历时约九十年。\\r\\n乐山大佛和凌云山、乌尤山、巨形卧佛等景点组成的乐山大佛景区属于国家5A级旅游景区。\",\"name\":\"乐山大佛\",\"phone\":\"\",\"pic\":\"leshandafo\",\"province\":\"四川\",\"ticketPrice\":165},{\"address\":\"四川省\",\"dayToPlay\":\"\",\"id\":8,\"labels\":[],\"mark\":\"塔公草原位于四川省甘孜藏族自治州康定市塔公镇境内，距康定市区113公里，海拔3730米的高原地带，川藏公路穿境而过。交通方便，是甘孜州最著名的草原。\\r\\n自康定沿川藏线西行，翻越折多山，过新都桥后北行37.3公里到达塔公寺。沿线的河流、草原、森林、山体、寺庙、藏房建筑和浓郁的藏乡风情构成该景区。\\r\\n游客在高原地区容易发生高原反应，建议带上抗高反药物。\\r\\n\",\"name\":\"塔公草原\",\"phone\":\"\",\"pic\":\"tagongcaoyuan\",\"province\":\"四川\",\"ticketPrice\":Free}]";
        Gson gson = new Gson();
        List<SightStragety> list = gson.fromJson(data, new TypeToken<List<SightStragety>>(){}.getType());
        mFullList.addAll(list);
        for(int i = 0; i < SightAdapter.mList.size();i++){
            for(int j = 0; j < mFullList.size();j++)
            {
                if(SightAdapter.mList.get(i) == mFullList.get(j).getId())
                    sightList.add(mFullList.get(j));
            }
        }
    }
}
