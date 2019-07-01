package com.sjyg.lzx.exportdata.mailUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author lzx
 * @create 2019-06-28
 */
@Component
public class FileUtil {

    Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 导出txt文件
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param hgoOrderInfo   查询结果集
     */
    public boolean exportTxt(String startTime, String endTime, List<Object[]> hgoOrderInfo, String str1, String str2,String str3){
        String fileName = startTime+"~"+endTime+str1+".txt";
        File file = new File("C:\\LZX\\Document\\orderFile\\"+fileName);
        BufferedOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new BufferedOutputStream(new FileOutputStream(file));
            logger.info("开始导出文件...");
            if(str3.equals("0")){
                for (Object[] object : hgoOrderInfo) {
                    String orderInfo = str2+"："+object[0]+"---->"+"订单数量："+object[1]+"\n";
                    outputStream.write(orderInfo.getBytes("utf-8"));
                }
            }else if(str3.equals("1")){
                for (Object[] object : hgoOrderInfo) {
                    String orderInfo = "上午十点：---->订单数量："+object[0]+"\n ";
                    orderInfo += "上午十一点：---->订单数量："+object[1]+"\n ";
                    orderInfo += "上午十二点：---->订单数量："+object[2]+"\n ";
                    orderInfo += "下午一点：---->订单数量："+object[3]+"\n ";
                    orderInfo += "下午两点：---->订单数量："+object[4]+"\n ";
                    orderInfo += "下午三点：---->订单数量："+object[5]+"\n ";
                    orderInfo += "下午四点：---->订单数量："+object[6]+"\n ";
                    orderInfo += "下午五点：---->订单数量："+object[7]+"\n ";
                    orderInfo += "下午六点：---->订单数量："+object[8]+"\n ";
                    orderInfo += "下午七点：---->订单数量："+object[9]+"\n ";
                    orderInfo += "下午八点：---->订单数量："+object[10]+"\n ";
                    orderInfo += "下午九点：---->订单数量："+object[11]+"\n ";
                    outputStream.write(orderInfo.getBytes("utf-8"));
                }
            }

            logger.info("导出文件结束...");
            return  true;
        } catch (IOException e) {
            logger.warn("导出日志出现异常!!!");
            e.printStackTrace();
            return false;
        }finally {
            if(outputStream != null){
                try {
                    outputStream.flush();
                    outputStream.close();
                    logger.info("文件流关闭...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 文件压缩的方法
     * @param files
     * @param zipFile
     */
    public void zipFiles(File[] files,File zipFile){
        if(zipFile.exists()){
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建 FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;

        try {
            // 实例化 FileOutputStream 对象
            fileOutputStream = new FileOutputStream(zipFile);
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            for (int i = 0; i < files.length; i++) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                fileInputStream = new FileInputStream(files[i]);
                // 实例化 ZipEntry 对象，源文件数组中的当前文件
                zipEntry = new ZipEntry(files[i].getName());
                zipOutputStream.putNextEntry(zipEntry);
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            logger.info("文件压缩成功！");
        } catch (IOException e) {
            logger.warn("文件压缩异常！请查看！");
            e.printStackTrace();
        }finally {
            try {
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
