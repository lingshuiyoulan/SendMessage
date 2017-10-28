package com.lanling.sendmessage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lanling.sendmessage.R;

public class MainActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_welcome);
        tv.setText("欢迎使用来电短信通知功能");
    }

}
