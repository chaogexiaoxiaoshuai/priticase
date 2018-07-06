package com.example.a99544.uidemo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 99544 on 2017/5/14/014.
 * 方正硬笔行书
 */

public class CustomFontTextView extends AppCompatTextView {

    public CustomFontTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        Typeface newFont = Typeface.createFromAsset(context.getAssets(), "fonts/FZYBXS.TTF");
        setTypeface(newFont);
    }

}