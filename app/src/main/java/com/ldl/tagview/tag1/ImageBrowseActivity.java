package com.ldl.tagview.tag1;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.ldl.tagview.R;

import java.util.ArrayList;
import java.util.List;

public class ImageBrowseActivity extends AppCompatActivity {

    private ViewPager viewPagerImgs;

    private List<ImgSimple> imgSimples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browse);

        viewPagerImgs = findViewById(R.id.viewPagerImgs);
        viewPagerImgs.setOffscreenPageLimit(2);
        initData();
        PagerAdapter adapter = new ImgBrowsePagerAdapter(this, imgSimples);
        viewPagerImgs.setAdapter(adapter);
    }

    private void initData() {

        imgSimples = new ArrayList<>();

        ImgSimple imgSimple1 = new ImgSimple();
        imgSimple1.url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539689608201&di=583ef462a9b30a5a6d08546ad381a7b6&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01009959e1da10a80121ae0c2fd0f0.jpg%402o.jpg";
        imgSimple1.scale = 1.6f;

        ArrayList<PointSimple> pointSimples = new ArrayList<>();
        PointSimple pointSimple1 = new PointSimple();
        pointSimple1.width_scale = 0.1f;
        pointSimple1.height_scale = 0.1f;

        PointSimple pointSimple2 = new PointSimple();
        pointSimple2.width_scale = 0.1f;
        pointSimple2.height_scale = 0.15f;
        pointSimple2.setType(1);


        PointSimple pointSimple3 = new PointSimple();
        pointSimple3.width_scale = 0.1f;
        pointSimple3.height_scale = 0.2f;

        PointSimple pointSimple4 = new PointSimple();
        pointSimple4.width_scale = 0.638f;
        pointSimple4.height_scale = 0.74f;

        PointSimple pointSimple5 = new PointSimple();
        pointSimple5.width_scale = 0.486f;
        pointSimple5.height_scale = 0.364f;
        pointSimple5.setType(1);

        pointSimples.add(pointSimple1);
        pointSimples.add(pointSimple2);
        pointSimples.add(pointSimple3);
        pointSimples.add(pointSimple4);
        pointSimples.add(pointSimple5);

        imgSimple1.pointSimples = pointSimples;


        ImgSimple imgSimple2 = new ImgSimple();
        imgSimple2.url = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3441821599,2880843621&fm=26&gp=0.jpg";
        imgSimple2.scale = 1f;

        ArrayList<PointSimple> pointSimples2 = new ArrayList<>();
        PointSimple pointSimple7 = new PointSimple();
        pointSimple7.width_scale = 0.36f;
        pointSimple7.height_scale = 0.75f;

        PointSimple pointSimple8 = new PointSimple();
        pointSimple8.width_scale = 0.64f;
        pointSimple8.height_scale = 0.5f;


        PointSimple pointSimple9 = new PointSimple();
        pointSimple9.width_scale = 0.5f;
        pointSimple9.height_scale = 0.1f;


        pointSimples2.add(pointSimple7);
        pointSimples2.add(pointSimple8);
        pointSimples2.add(pointSimple9);

        imgSimple2.pointSimples = pointSimples2;

        ImgSimple imgSimple3 = new ImgSimple();
        imgSimple3.url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539752347940&di=164ecb5c05083d65d62c64fcea8d68df&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01986958837303a801219c77d8057f.jpg%401280w_1l_2o_100sh.jpg";
        imgSimple3.scale = 1.6f;

        ArrayList<PointSimple> pointSimples3 = new ArrayList<>();
        PointSimple pointSimple11 = new PointSimple();
        pointSimple11.width_scale = 0.1f;
        pointSimple11.height_scale = 0.3f;

        PointSimple pointSimple12 = new PointSimple();
        pointSimple12.width_scale = 0.3f;
        pointSimple12.height_scale = 0.5f;


        PointSimple pointSimple13 = new PointSimple();
        pointSimple13.width_scale = 0.5f;
        pointSimple13.height_scale = 0.8f;


        pointSimples3.add(pointSimple11);
        pointSimples3.add(pointSimple12);
        pointSimples3.add(pointSimple13);

        imgSimple3.pointSimples = pointSimples3;

        imgSimples.add(imgSimple1);
        imgSimples.add(imgSimple2);
        imgSimples.add(imgSimple3);
    }
}
