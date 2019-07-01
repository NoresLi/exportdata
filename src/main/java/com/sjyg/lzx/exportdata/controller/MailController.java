package com.sjyg.lzx.exportdata.controller;

import com.sjyg.lzx.exportdata.StartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author lzx
 * @create 2019-06-27
 */
@Controller
public class MailController {

    @Autowired
    private JavaMailSenderImpl mailSender;

    Logger logger = LoggerFactory.getLogger(MailController.class);

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    @RequestMapping(value="sendSimpleMail")
    public String sendSimpleMail() throws MessagingException
    {
        String filePath = "C:\\LZX\\Document\\orderFile\\ZipFile.zip";
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom(Sender);
        messageHelper.setTo("891283358@qq.com");
        messageHelper.setSubject("订单数据");
        messageHelper.setText("订单数据");
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        messageHelper.addAttachment(fileName, file);
        mailSender.send(mimeMessage);
        logger.info("邮件发送成功");
        return "邮件发送成功";
    }
}
