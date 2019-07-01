package com.sjyg.lzx.exportdata;

import com.sjyg.lzx.exportdata.controller.MailController;
import com.sjyg.lzx.exportdata.controller.OrderController;
import com.sjyg.lzx.exportdata.mailUtil.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lzx
 * @create 2019-06-28
 */
@Component
@EnableScheduling
public class StartService {

    @Autowired
    OrderController orderController;
    @Autowired
    FileUtil fileUtil;
    @Autowired
    MailController mailController;

    Logger logger = LoggerFactory.getLogger(StartService.class);

    @Scheduled(cron = "0 0 7 ? * SAT")
    //@Scheduled(cron = "0/50 * * * * ?")
    public void run() throws Exception {
        //获取开始时间和结束时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date startD = c.getTime();
        String startTime = format.format(startD);
        c.add(Calendar.DATE,+6);
        Date endD = c.getTime();
        String endTime = format.format(endD);
        //开始导出数据
        logger.info("=========导出开始==========");
        boolean b1 = orderController.getOrderInfoByMerchant(startTime,endTime);
        if(!b1){
            logger.warn("每周商家订单文件导出失败！请查看");
        }
        boolean b2 = orderController.getOrderInfoByHorseMan(startTime,endTime);
        if(!b2){
            logger.warn("每周骑手接单量文件导出失败！请查看");
        }
        boolean b3 = orderController.getOrderInfoByHorseManTimeOut(startTime,endTime);
        if(!b3){
            logger.warn("每周骑手超时订单文件导出失败！请查看");
        }
        boolean b4 = orderController.getOrderInfoByHour(startTime,endTime);
        if(!b4){
            logger.warn("每周每个小时订单量文件导出失败！请查看");
        }
        logger.info("=========导出结束==========");
        //打包数据
        String fileName1 = "orderWorkBook"+startTime+"~"+endTime+".xls";
        File[] srcFiles ={new File("C:\\LZX\\Document\\orderFile\\"+fileName1)};
        File zipFile = new File("C:\\LZX\\Document\\orderFile\\ZipFile.zip");
        // 调用压缩方法
        fileUtil.zipFiles(srcFiles, zipFile);
        //发送邮件
        mailController.sendSimpleMail();
    }
}
