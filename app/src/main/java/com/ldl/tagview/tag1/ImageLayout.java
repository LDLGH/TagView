package com.ldl.tagview.tag1;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ldl.tagview.R;

import java.util.ArrayList;

public class ImageLayout extends FrameLayout implements View.OnClickListener {

    ArrayList<PointSimple> points;

    FrameLayout layoutPoints;

    ImageView imgBg;

    Context mContext;

    private int layoutWidth = 0;
    private int layoutHeight = 0;
    private String imageUrl = "";

    public ImageLayout(Context context) {
        this(context, null);
    }

    public ImageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        View imgPointLayout = inflate(context, R.layout.layout_imgview_point, this);
        imgBg = imgPointLayout.findViewById(R.id.imgBg);
        layoutPoints = imgPointLayout.findViewById(R.id.layouPoints);
        imgBg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutPoints.getVisibility() == VISIBLE) {
                    layoutPoints.setVisibility(GONE);
                    clearPoint();
                } else {
                    layoutPoints.setVisibility(VISIBLE);
                    if(layoutWidth >0){
                        setImgBg(layoutWidth,layoutHeight,imageUrl);
                    }
                }
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    /**
     *  设置图片和layouPoints的宽高，保证大小一样，可以使标签位置准确
     * */
    public void setImgBg(int width, int height, String imgUrl) {

        layoutWidth = width;
        layoutHeight = height;
        imageUrl = imgUrl;

        ViewGroup.LayoutParams lp = imgBg.getLayoutParams();
        lp.width = width;
        lp.height = height;
        imgBg.setLayoutParams(lp);

        ViewGroup.LayoutParams lp1 = layoutPoints.getLayoutParams();
        lp1.width = width;
        lp1.height = height;
        layoutPoints.setLayoutParams(lp1);
        Glide.with(mContext).load(imgUrl).asBitmap().into(imgBg);
        addPoints(width, height);
    }

    public void setPoints(ArrayList<PointSimple> points) {
        this.points = points;
    }

    /**
     * 在图片中添加Tag
     * */
    private void addPoints(int width, int height) {
        layoutPoints.removeAllViews();

        for (int i = 0; i < points.size(); i++) {
            LinearLayout view = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.layout_img_point, this, false);
            ImageView imgPoint = view.findViewById(R.id.imgPoint);
            TextView tv_tag_left = view.findViewById(R.id.tv_tag_left);
            final TextView tv_tag_right = view.findViewById(R.id.tv_tag_right);
            imgPoint.setTag(i);
            tv_tag_left.setTag(i);
            tv_tag_right.setTag(i);
            imgPoint.setOnClickListener(this);
            AnimationDrawable animationDrawable = (AnimationDrawable) imgPoint.getDrawable();
            animationDrawable.start();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();

            double width_scale = points.get(i).width_scale;
            double height_scale = points.get(i).height_scale;
            //用于判断是否显示左边文字还是右边文字 当小于0.5f显示右边文字
            if (width_scale >= 0.5f) {
                tv_tag_left.setVisibility(VISIBLE);
                tv_tag_left.setOnClickListener(this);
            } else {
                tv_tag_right.setVisibility(VISIBLE);
                tv_tag_right.setOnClickListener(this);
            }
            //设置view在layoutPoints布局中的位置
            // 文字在左边显示需要去除对应的文字宽度，对应的imgPoint能够显示在对应位置
            if (width_scale >= 0.5f) {
                layoutParams.leftMargin = (int) (width * width_scale) - getViewWidth(tv_tag_left);
            } else {
                layoutParams.leftMargin = (int) (width * width_scale);
            }
            layoutParams.topMargin = (int) (height * height_scale);

            layoutPoints.addView(view, layoutParams);

        }
    }

    /**
     * 获取view宽度
     * */
    private int getViewWidth(TextView view){
        view.measure( 0,  0);
        int measuredWidth = view.getMeasuredWidth();
        return measuredWidth;
    }

    private void clearPoint(){
        layoutPoints.removeAllViews();
    }

    @Override
    public void onClick(View view) {
        int pos = (int) view.getTag();
        switch (view.getId()) {
            case R.id.imgPoint:
                Toast.makeText(getContext(), "点击了中心点 pos : " + pos, Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tag_left:
                Toast.makeText(getContext(), "点击了左边内容  pos : " + pos, Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tag_right:
                Toast.makeText(getContext(), "点击了右边内容  pos : " + pos, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
