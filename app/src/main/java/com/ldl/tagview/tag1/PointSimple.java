package com.ldl.tagview.tag1;

/**
 * Created by lining on 2016/7/14.
 */
public class PointSimple {

    // 标记点相对于横向的宽度的比例
    public double width_scale;
    // 标记点相对于横向的高度的比例
    public double height_scale;

    private int type = 0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
