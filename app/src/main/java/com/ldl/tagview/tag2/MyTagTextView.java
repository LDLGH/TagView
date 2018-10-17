package com.ldl.tagview.tag2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.licrafter.tagview.DIRECTION;
import com.licrafter.tagview.views.ITagView;

import org.jetbrains.annotations.NotNull;

public class MyTagTextView extends android.support.v7.widget.AppCompatTextView implements ITagView {

    private DIRECTION mDirection;

    public MyTagTextView(Context context) {
        super(context);
    }

    public MyTagTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTagTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextColor(Color.WHITE);
        setTextSize(13f);
    }

    @NotNull
    @Override
    public DIRECTION getDirection() {
        return mDirection;
    }

    @Override
    public void setDirection(DIRECTION direction) {
        mDirection = direction;
    }
}
