package com.lanling.sendmessage.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.lanling.sendmessage.service.MyService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class SmsReciver extends BroadcastReceiver {
    public static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        String number = "";
        String content = "";
        String receiveTime = "";
        StringBuilder message = new StringBuilder();
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            assert smsObj != null;
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                number = msg.getOriginatingAddress();
                content += "\t" + msg.getDisplayMessageBody();
                receiveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(msg.getTimestampMillis()));
                //在这里写自己的逻辑
                Log.d(TAG, receiveTime);
                Log.d(TAG, "getOriginatingAddress:" + number);
                Log.d(TAG, "getMessageBody:" + msg.getDisplayMessageBody());
            }

            message.append("发送人:").append("\t").append(number).append("\n").append("\n");
            message.append("内容:").append("\t").append(content).append("\n").append("\n");
            message.append("时间:").append("\t").append(receiveTime).append("\n");
            intent.putExtra("message", message.toString());
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
//            intent.setClass(context, MsgActivity.class);
//            context.startActivity(intent);
            intent.setClass(context, MyService.class);
            context.startService(intent);
        }
    }

}
