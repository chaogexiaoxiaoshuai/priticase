package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a99544.uidemo.R;

/*
完整攻略，即将弃用
 */

public class LvChuang2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_last_one);

        TextView title = (TextView)findViewById(R.id.title);
        title.setText("您的旅创");

        Button back = (Button)findViewById(R.id.back_2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LvChuang2Activity.this,StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
