package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a99544.uidemo.R;

/*
攻略初稿，即将弃用
 */

public class ChuGao2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_choosespot);

        TextView next = (TextView)findViewById(R.id.gonglue2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChuGao2Activity.this,LvChuang2Activity.class);
                startActivity(intent);
            }
        });



        TextView title = (TextView)findViewById(R.id.title);
        title.setText("攻略初稿");
    }
}
