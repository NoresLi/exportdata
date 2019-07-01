package com.sjyg.lzx.exportdata.mailUtil;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

/**
 * @author lzx
 * @create 2019-07-01
 * 导出Excel工具类
 */
@RestController
public class ExcelUtil {

    Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private HSSFWorkbook workbook = new HSSFWorkbook();

    public boolean ExcelData(String[] headers,String sheetTitle,List<Object[]> objects,String startTime,String endTime,boolean flag){
        logger.info("开始导出Excel");
        HSSFSheet sheet = workbook.createSheet(sheetTitle);
        int bookInt = 1;
        Boolean b = this.createTitleCell(headers,workbook,sheet);//表格标题
        Boolean b1 = false;
        if(flag){
            b1 = this.createDateCell(bookInt,sheet,objects,startTime,endTime);//订单数据
        }else{
            b1 = this.createDateCell1(bookInt,sheet,objects,startTime,endTime);//订单数据
        }
        String fileName = startTime+"~"+endTime+".xls";
        //所有Sheet页生成之后才导出Excel
        if(b && b1){
            return this.ExportExcel(fileName,workbook);
        }else {
            logger.warn("填充数据失败了！无法生成数据");
            return false;
        }
    }

    /**
     * 导出Excel文件
     * @param fileName
     * @param workbook
     */
    public boolean ExportExcel(String fileName,HSSFWorkbook workbook){
        try {
            OutputStream outputStream = new FileOutputStream
                    ("C:\\LZX\\Document\\orderFile\\orderWorkBook"+fileName);
            workbook.write(outputStream);
            logger.info("导出Excel成功");
            return true;
        } catch (FileNotFoundException e) {
            logger.error("Excel导出异常!可能是文件没有找到异常！");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            logger.error("Excel导出异常!IO异常！");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 填充Title
     * @param headers
     * @param workbook
     * @param sheet
     */
    public boolean createTitleCell(String[] headers,HSSFWorkbook workbook,HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = workbook.createCellStyle();
        logger.info("填充Title开始~");
        try {
            for (int i=0;i<headers.length;i++) {
                style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                HSSFFont font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString textString = new HSSFRichTextString(headers[i]);
                cell.setCellValue(textString);
                cell.setCellStyle(style);
            }
            logger.info("填充Title成功~");
            return true;
        }catch (Exception e){
            logger.error("填充Title失败！");
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 填充数据
     * @param bookInt
     * @param sheet
     * @param objects
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean createDateCell(int bookInt,HSSFSheet sheet,List<Object[]> objects,String startTime,String endTime){
        logger.info("填充数据开始~");
        HSSFRow row = sheet.createRow(bookInt);
        try {
            for (Object[] object : objects) {
                int orderNumCount = 0;
                for(int i=0;i<object.length;i++){
                    Object obj = object[i];
                    orderNumCount += Integer.parseInt(object[i].toString());
                    row.createCell(i).setCellValue(obj.toString());
                }
                row.createCell(12).setCellValue(orderNumCount);
                row.createCell(13).setCellValue(startTime+"~"+endTime);
            }
            logger.info("填充数据成功~");
            return true;
        }catch (Exception e){
            logger.error("填充数据失败！");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 填充数据
     * @param bookInt
     * @param sheet
     * @param objects
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean createDateCell1(int bookInt,HSSFSheet sheet,List<Object[]> objects,String startTime,String endTime){
        logger.info("填充数据开始~");
        String name = startTime+"~"+endTime;
        int orderNumCount = 0;
        try {
            for (int j=0;j<=objects.size();j++) {
                HSSFRow row = sheet.createRow(bookInt);
                if(j == objects.size()){
                    row.createCell(0).setCellValue(name);
                    row.createCell(1).setCellValue(orderNumCount);
                    break;
                }
                Object[] object = objects.get(j);
                String strObject = object[1].toString();
                orderNumCount+=Integer.parseInt(strObject);
                row.createCell(0).setCellValue(object[0].toString());
                row.createCell(1).setCellValue(strObject);
                bookInt++;
            }
            logger.info("填充数据成功~");
            return true;
        }catch (Exception e){
            logger.error("填充数据失败!");
            e.printStackTrace();
            return false;
        }
    }

}
