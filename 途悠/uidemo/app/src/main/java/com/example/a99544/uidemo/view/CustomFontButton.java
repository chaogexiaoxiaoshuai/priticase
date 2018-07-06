package com.example.a99544.uidemo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * 方正硬笔行书
 * Created by 99544 on 2017/5/14/014.
 */

public class CustomFontButton extends AppCompatButton {

    public CustomFontButton(Context context) {
        super(context);
        init(context);
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        Typeface newFont = Typeface.createFromAsset(context.getAssets(), "fonts/FZYBXS.TTF");
        setTypeface(newFont);
    }

}
