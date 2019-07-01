package com.sjyg.lzx.exportdata.controller;

import com.sjyg.lzx.exportdata.mailUtil.ExcelUtil;
import com.sjyg.lzx.exportdata.mailUtil.FileUtil;
import com.sjyg.lzx.exportdata.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author lzx
 * @create 2019-06-27
 */
@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FileUtil fileUtil;
    @Autowired
    ExcelUtil excelUtil;

    //查询每周商家订单量
    @RequestMapping(value = "getOrderInfoByMerchant")
    public boolean getOrderInfoByMerchant(String startTime, String endTime){
        List<Object[]> hgoOrderInfo = orderRepository.getOrderInfoByMerchant(startTime,endTime);
        String[] headers = {"商家名称","订单数量"};
        String sheetTitle = "商家订单量";
        return excelUtil.ExcelData(headers,sheetTitle,hgoOrderInfo,startTime,endTime,false);
    }

    //查询每周骑手送单量
    @RequestMapping(value = "getOrderInfoByHorseMan")
    public boolean getOrderInfoByHorseMan(String startTime, String endTime){
        List<Object[]> hgoOrderInfo = orderRepository.getOrderInfoByHorseMan(startTime,endTime);
        String[] headers = {"骑手名称","订单数量"};
        String sheetTitle = "骑手接单量";
        return excelUtil.ExcelData(headers,sheetTitle,hgoOrderInfo,startTime,endTime,false);
    }

    //查询每周骑手超时订单
    @RequestMapping(value = "getOrderInfoByHorseManTimeOut")
    public boolean getOrderInfoByHorseManTimeOut(String startTime, String endTime){
        List<Object[]> hgoOrderInfo = orderRepository.getOrderInfoByHorseManTimeOut(startTime,endTime);
        String[] headers = {"骑手名称","超时订单数量"};
        String sheetTitle = "骑手超时订单";
        return excelUtil.ExcelData(headers,sheetTitle,hgoOrderInfo,startTime,endTime,false);
    }

    //查询每周10点到21点的下单情况
    @RequestMapping(value = "getOrderInfoByHour")
    public boolean getOrderInfoByHour(String startTime, String endTime){
        List<Object[]> hgoOrderInfo = orderRepository.getOrderInfoByHour(startTime,endTime);
        String[] headers = {"上午十点","上午十一点","中午十二点","下午一点",
                "下午两点","下午三点","下午四点","下午五点","下午六点",
                "下午七点","下午八点","下午九点","订单总数","订单时间"};
        String sheetTitle = "整点订单数据";
        return excelUtil.ExcelData(headers,sheetTitle,hgoOrderInfo,startTime,endTime,true);
    }

}
