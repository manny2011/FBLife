package com.group.yztcedu.fblife.main.carbarn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.main.carbarn.entity.SeriesBean;
import com.group.yztcedu.fblife.main.carbarn.entity.Vehicle;
import com.group.yztcedu.fblife.main.carbarn.entity.VehicleModel;
import com.group.yztcedu.fblife.main.login.LoginActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class GarageFragment extends BaseFragment implements GarageContract.View {
    private List<Vehicle> mList;
    PinyinCompatator compatator;
    ListView listView;
    PopupWindow popupWindow;
    FrameLayout frameLayout;
    private Toolbar toolbar;
    private PopupAdapter popupAdapter;
    GarageContract.Presenter presenter;
    private HashMap<String, String> params;
    private List<SeriesBean> modelList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.garage_fragment_layout, null);
        listView = (ListView) view.findViewById(R.id.garage_default_list_view);
        frameLayout = (FrameLayout) view.findViewById(R.id.garage_container);
        toolbar = (Toolbar) view.findViewById(R.id.garage_toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setNavigationIcon(R.mipmap.men);
        //如果toolbar是布局文件自带的,不用再调用setSupportActionBar;
        //如果toolbar是代码中自定义的,必须要调用此方法.添加到视图中;
        //要处理radiobutton的点击与二次点击事件;
        compatator = new PinyinCompatator();
        presenter=new GaragePresenter(this);
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        mList = initData();
        initSortedKey();
        Collections.sort(mList, compatator);
        VehicleAdapter adapter = new VehicleAdapter(getContext(), mList);
        listView.setAdapter(adapter);
        initView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点击某个listview中的position,右侧弹出一个popupwindow,显示一个listview;
                //将其所对应的位置上的对象,所对应的英文名字传过去,给popupwindow;
                modelList= new ArrayList<>();
                params = new HashMap<>();
                initParams(mList.get(i).getBrand());
                presenter.getData(params);
                initPopupWindow();
                popupWindow.showAtLocation(frameLayout, Gravity.RIGHT, 0, 30);
            }
        });
    }

    private void initParams(String name) {
        params.put("datatype","json");
        params.put("words",name);
    }

    private void initView() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.garage_popupwindow_layout, null);
        ListView listView = (ListView) view.findViewById(R.id.garage_popup_listview);

        //将listview作为popupwindow的内容添加到其中去,然后再给listview添加内容适配器;
        popupWindow = new PopupWindow(view, 600, 920);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.popupwindow));
        popupWindow.setFocusable(true);
        //设置popwindow显示位置
        popupWindow.setOutsideTouchable(false);
        popupAdapter = new PopupAdapter(getContext(),0,modelList);
        listView.setAdapter(popupAdapter);
        //popwindow点击其他地方消失
//        popupWindow.isShowing();


    }

    private void initSortedKey() {
        for (int i = 0; i < mList.size(); i++) {
            String name = mList.get(i).getName();
            String pinyin = CharacterParser.getInstance().getSelling(name).toUpperCase();
            if (pinyin.substring(0, 1).matches("[A-Z]")) {
                mList.get(i).setSortedKey(pinyin.toUpperCase().substring(0, 1));
            } else {
                mList.get(i).setSortedKey("#");
            }

        }
    }

    @Override
    public void onSuccess(VehicleModel model) {
        Log.i("TAG",model.getSeries().get(0).getName());
        popupAdapter.addAll(model.getSeries());
        popupAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailed(String s) {
        Log.i("TAG",s);
    }

    public List<Vehicle> initData() {
        List<Vehicle> list = new ArrayList<>();
        Vehicle vehicle0 = new Vehicle("奥迪", "audi");
        Vehicle vehicle1 = new Vehicle("阿斯顿*马丁", "astonmartin");
        Vehicle vehicle2 = new Vehicle("本田", "honda");
        Vehicle vehicle3 = new Vehicle("保时捷", "porsche");
        Vehicle vehicle4 = new Vehicle("宝马", "bmw");
        Vehicle vehicle5 = new Vehicle("奔驰", "mercedesbenz");
        Vehicle vehicle6 = new Vehicle("北汽制造", "baw");
        Vehicle vehicle7 = new Vehicle("比亚迪", "byd");
        Vehicle vehicle8 = new Vehicle("标致", "peugeot");
        Vehicle vehicle9 = new Vehicle("别克", "buick");
        Vehicle vehicle10 = new Vehicle("北汽幻速", "huansu");
        Vehicle vehicle11 = new Vehicle("北汽威旺", "weiwang");
        Vehicle vehicle12 = new Vehicle("奔腾", "faw-benteng");
        Vehicle vehicle13 = new Vehicle("北京", "baicmotor");
        Vehicle vehicle14 = new Vehicle("宝骏", "baojun");
        Vehicle vehicle15 = new Vehicle("宾利", "bentley");
        Vehicle vehicle16 = new Vehicle("宝沃", "borgward");
        Vehicle vehicle17 = new Vehicle("长城", "greatwall");
        Vehicle vehicle18 = new Vehicle("长安", "changan");
        Vehicle vehicle19 = new Vehicle("Conquest Vehicles", "conquestvehicles");
        Vehicle vehicle20 = new Vehicle("成功汽车", "victory");
        Vehicle vehicle21 = new Vehicle("昌河", "changhe");
        Vehicle vehicle22 = new Vehicle("大众", "volkswagen");
        Vehicle vehicle23 = new Vehicle("道奇", "dodge");
        Vehicle vehicle24 = new Vehicle("东风", "dfmc");
        Vehicle vehicle25 = new Vehicle("东风风神", "dffs");
        Vehicle vehicle26 = new Vehicle("DS", "ds");
        Vehicle vehicle27 = new Vehicle("东南", "soueastmotor");
        Vehicle vehicle28 = new Vehicle("东风风度", "dffd");
        Vehicle vehicle29 = new Vehicle("丰田", "toyota");
        Vehicle vehicle30 = new Vehicle("菲亚特", "fiat");
        Vehicle vehicle31 = new Vehicle("福特", "ford");
        Vehicle vehicle32 = new Vehicle("福迪", "foday");
        Vehicle vehicle33 = new Vehicle("福田", "foton");
        Vehicle vehicle34 = new Vehicle("广汽传祺", "trumpchi");
        Vehicle vehicle35 = new Vehicle("广汽吉奥", "gonow");
        Vehicle vehicle36 = new Vehicle("GMC", "gmc");
        Vehicle vehicle37 = new Vehicle("观致", "qoros");
        Vehicle vehicle38 = new Vehicle("海马", "haima");
        Vehicle vehicle39 = new Vehicle("悍马", "hummer");
        Vehicle vehicle40 = new Vehicle("华泰", "hawtai");
        Vehicle vehicle41 = new Vehicle("黄海", "huanghai");
        Vehicle vehicle42 = new Vehicle("哈弗", "haval");
        Vehicle vehicle43 = new Vehicle("海格", "higer");
        Vehicle vehicle44 = new Vehicle("恒天", "chtc");
        Vehicle vehicle45 = new Vehicle("红旗", "hongqi");
        Vehicle vehicle46 = new Vehicle("Jeep", "jeep");
        Vehicle vehicle47 = new Vehicle("江铃", "jmc");
        Vehicle vehicle48 = new Vehicle("吉利", "geely");
        Vehicle vehicle49 = new Vehicle("江淮", "jac");
        Vehicle vehicle50 = new Vehicle("吉利英伦", "engloncar1");
        Vehicle vehicle51 = new Vehicle("金杯", "jinbei");
        Vehicle vehicle52 = new Vehicle("江铃集团轻汽", "jmcgl");
        Vehicle vehicle53 = new Vehicle("捷豹", "jaguar");
        Vehicle vehicle54 = new Vehicle("凯迪拉克", "cadillac");
        Vehicle vehicle55 = new Vehicle("卡威", "kawei");
        Vehicle vehicle56 = new Vehicle("开瑞", "karry");
        Vehicle vehicle57 = new Vehicle("铃木", "suzuki");
        Vehicle vehicle58 = new Vehicle("陆风", "landwind");
        Vehicle vehicle59 = new Vehicle("猎豹汽车", "leopaard");
        Vehicle vehicle60 = new Vehicle("路虎", "landrover");
        Vehicle vehicle61 = new Vehicle("林肯", "lincoln");
        Vehicle vehicle62 = new Vehicle("力帆", "lifan");
        Vehicle vehicle63 = new Vehicle("雷诺", "renault");
        Vehicle vehicle64 = new Vehicle("LEXUS雷克萨斯", "lexus");
        Vehicle vehicle65 = new Vehicle("莲花汽车", "lotus");
        Vehicle vehicle66 = new Vehicle("马自达", "mazda");
        Vehicle vehicle67 = new Vehicle("MINI", "mini");
        Vehicle vehicle68 = new Vehicle("MG", "morrisgarages");
        Vehicle vehicle69 = new Vehicle("纳智捷", "luxgen");
        Vehicle vehicle70 = new Vehicle("讴歌", "acura");
        Vehicle vehicle71 = new Vehicle("欧宝", "opel");
        Vehicle vehicle72 = new Vehicle("奇瑞", "chery");
        Vehicle vehicle73 = new Vehicle("起亚", "kia");
        Vehicle vehicle74 = new Vehicle("启辰", "venucia");
        Vehicle vehicle75 = new Vehicle("瑞麒", "riich");
        Vehicle vehicle76 = new Vehicle("荣威", "roewe");
        Vehicle vehicle77 = new Vehicle("日产", "nissan");
        Vehicle vehicle78 = new Vehicle("斯巴鲁", "subaru");
        Vehicle vehicle79 = new Vehicle("双龙", "ssangyong");
        Vehicle vehicle80 = new Vehicle("三菱", "mitsubishi");
        Vehicle vehicle81 = new Vehicle("双环", "hbsh");
        Vehicle vehicle82 = new Vehicle("斯柯达", "skoda");
        Vehicle vehicle83 = new Vehicle("威麟", "rely");
        Vehicle vehicle84 = new Vehicle("沃尔沃", "volvo");
        Vehicle vehicle85 = new Vehicle("五十铃", "isuzu");
        Vehicle vehicle86 = new Vehicle("雪铁龙", "citroen");
        Vehicle vehicle87 = new Vehicle("雪佛兰", "chevrolet");
        Vehicle vehicle88 = new Vehicle("现代", "hyundai");
        Vehicle vehicle89 = new Vehicle("枭龙", "xiaolong");
        Vehicle vehicle90 = new Vehicle("野马汽车", "yema");
        Vehicle vehicle91 = new Vehicle("永源", "jonway");
        Vehicle vehicle92 = new Vehicle("一汽", "faw");
        Vehicle vehicle93 = new Vehicle("英菲尼迪", "infiniti");
        Vehicle vehicle94 = new Vehicle("英致", "enranger");
        Vehicle vehicle95 = new Vehicle("中华", "zhonghua");
        Vehicle vehicle96 = new Vehicle("中兴", "zx");
        Vehicle vehicle97 = new Vehicle("众泰", "zotye");
        list.add(vehicle0);
        list.add(vehicle1);
        list.add(vehicle2);
        list.add(vehicle3);
        list.add(vehicle4);
        list.add(vehicle5);
        list.add(vehicle6);
        list.add(vehicle7);
        list.add(vehicle8);
        list.add(vehicle9);
        list.add(vehicle10);
        list.add(vehicle11);
        list.add(vehicle12);
        list.add(vehicle13);
        list.add(vehicle14);
        list.add(vehicle15);
        list.add(vehicle16);
        list.add(vehicle17);
        list.add(vehicle18);
        list.add(vehicle19);
        list.add(vehicle20);
        list.add(vehicle21);
        list.add(vehicle22);
        list.add(vehicle23);
        list.add(vehicle24);
        list.add(vehicle25);
        list.add(vehicle26);
        list.add(vehicle27);
        list.add(vehicle28);
        list.add(vehicle29);
        list.add(vehicle30);
        list.add(vehicle31);
        list.add(vehicle32);
        list.add(vehicle33);
        list.add(vehicle34);
        list.add(vehicle35);
        list.add(vehicle36);
        list.add(vehicle37);
        list.add(vehicle38);
        list.add(vehicle39);
        list.add(vehicle40);
        list.add(vehicle41);
        list.add(vehicle42);
        list.add(vehicle43);
        list.add(vehicle44);
        list.add(vehicle45);
        list.add(vehicle46);
        list.add(vehicle47);
        list.add(vehicle48);
        list.add(vehicle49);
        list.add(vehicle50);
        list.add(vehicle51);
        list.add(vehicle52);
        list.add(vehicle53);
        list.add(vehicle54);
        list.add(vehicle55);
        list.add(vehicle56);
        list.add(vehicle57);
        list.add(vehicle58);
        list.add(vehicle59);
        list.add(vehicle60);
        list.add(vehicle61);
        list.add(vehicle62);
        list.add(vehicle63);
        list.add(vehicle64);
        list.add(vehicle65);
        list.add(vehicle66);
        list.add(vehicle67);
        list.add(vehicle68);
        list.add(vehicle69);
        list.add(vehicle70);
        list.add(vehicle71);
        list.add(vehicle72);
        list.add(vehicle73);
        list.add(vehicle74);
        list.add(vehicle75);
        list.add(vehicle76);
        list.add(vehicle77);
        list.add(vehicle78);
        list.add(vehicle79);
        list.add(vehicle80);
        list.add(vehicle81);
        list.add(vehicle82);
        list.add(vehicle83);
        list.add(vehicle84);
        list.add(vehicle85);
        list.add(vehicle86);
        list.add(vehicle87);
        list.add(vehicle88);
        list.add(vehicle89);
        list.add(vehicle90);
        list.add(vehicle91);
        list.add(vehicle92);
        list.add(vehicle93);
        list.add(vehicle94);
        list.add(vehicle95);
        list.add(vehicle96);
        list.add(vehicle97);
        return list;
    }
}
