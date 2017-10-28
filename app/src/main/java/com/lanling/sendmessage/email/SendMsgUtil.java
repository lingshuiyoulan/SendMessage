package com.lanling.sendmessage.email;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;

/**
 * The Class
 *
 * @author Lanling
 *         on 2017/10/28
 */
public class SendMsgUtil {
    public static void sendMessage(String message) {
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);

        Email email = new Email("smtp.163.com");//这里以网易邮箱为例子
        email.setNeedAuth(true);
        email.setSubject("短信通知");//邮件主题
        email.setBody(message);//邮件正文
        email.setTo("1530231611@qq.com");//收件人地址
        email.setFrom("17797754554@163.com");//发件人地址
        email.setNamePass("lingshuiyoulan@163.com", "ruoshui0118");//发件人地址和密码 **改为相应邮箱密码
        email.sendout();
    }
}
