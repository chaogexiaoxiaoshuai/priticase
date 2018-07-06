package com.example.a99544.uidemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a99544.uidemo.R;
/*
日期选择，暂时弃用
 */

public class DateActivity extends BaseActivity {

    private Button go=null;
    private Button back=null;
    private TextView dateSelect=null;
    private DatePicker datePicker=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        TextView title=(TextView)findViewById(R.id.title);
        title.setText("选择旅行时间");

        go=(Button)findViewById(R.id.date_go) ;
        back=(Button)findViewById(R.id.date_back);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.date_go).setBackgroundColor(Color.RED);
                findViewById(R.id.date_back).setBackgroundColor(Color.WHITE);
            }
        });

       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.date_back).setBackgroundColor(Color.RED);
                findViewById(R.id.date_go).setBackgroundColor(Color.WHITE);
            }
        });

        datePicker=(DatePicker)findViewById(R.id.date_picker);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DateActivity.this,"ya ha ha",Toast.LENGTH_SHORT);
                dateSelect=(TextView)findViewById(R.id.date_text);
                dateSelect.setText(dateSelect.getText()+"返回时间："+datePicker.getMonth()+"月"+datePicker.getDayOfMonth()+"日");
            }
        });

        Button next=(Button)findViewById(R.id.date_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DateActivity.this,PreferenceActicity.class);
                startActivity(intent);
            }
        });
    }
}
