package com.lanling.sendmessage.email;

import android.util.Log;

/**
 * @author lanling
 *         on 2017/8/6.
 */

public class SendMsgUtil {
    public static final String TAG = "MsgUtil";

    public static void sendMessage(final String msg) {
        Log.i(TAG, "开始发送邮件");
        // 这个类主要是设置邮件
        new Thread(new Runnable() {
            @Override
            public void run() {
                MailSenderInfo mailInfo = new MailSenderInfo();
                mailInfo.setMailServerHost("smtp.163.com");
                mailInfo.setMailServerPort("25");
                mailInfo.setValidate(true);
                mailInfo.setUserName("17797754554@163.com");
                mailInfo.setPassword("ruoshui0118");// 您的邮箱密码
                mailInfo.setFromAddress("17797754554@163.com");
                mailInfo.setToAddress("1530231611@qq.com");
                mailInfo.setSubject("短信通知");
                mailInfo.setContent(msg);
                // 这个类主要来发送邮件
                SimpleMailSender sms = new SimpleMailSender();
                boolean isSuccess = false;
                isSuccess = sms.sendTextMail(mailInfo);// 发送文体格式
//                isSuccess = sms.sendHtmlMail(mailInfo);//发送html格式
                if (isSuccess) {
                    Log.i(TAG, "发送成功");
                } else {
                    Log.i(TAG, "发送失败");
                }
            }
        }).start();
    }
}
