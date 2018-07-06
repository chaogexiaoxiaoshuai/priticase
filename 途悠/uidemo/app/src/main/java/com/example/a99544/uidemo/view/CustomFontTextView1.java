package com.example.a99544.uidemo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * 方正苏新诗柳楷
 */

public class CustomFontTextView1 extends AppCompatTextView {


    public CustomFontTextView1(Context context) {
        super(context);
        init(context);
    }

    public CustomFontTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFontTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context) {
    Typeface newFont = Typeface.createFromAsset(context.getAssets(), "fonts/FZSXSLK.TTF");
    setTypeface(newFont);
}



}