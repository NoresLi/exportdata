package com.sjyg.lzx.exportdata.repository;

import com.sjyg.lzx.exportdata.entity.HgoOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author lzx
 * @create 2019-06-27
 */
@Repository
public interface OrderRepository extends JpaRepository<HgoOrderInfo,BigInteger> {


    @Query(nativeQuery = true,
            value = "select merchant_name,count(*) as orderCount from hgo_order_info " +
                    "where gmt_create BETWEEN ?1 and ?2 " +
                    "and order_status = 9 GROUP BY merchant_name order by orderCount desc")
    List<Object[]> getOrderInfoByMerchant(String startTime,String endTime);

    @Query(nativeQuery = true,
            value = "select horseman_name,count(*) as orderCount from hgo_order_info " +
                    "where gmt_create BETWEEN ?1 and ?2 " +
                    "and order_status = 9 GROUP BY horseman_name order by orderCount desc")
    List<Object[]> getOrderInfoByHorseMan(String startTime,String endTime);

    @Query(nativeQuery = true,
            value = "select horseman_name,count(*) as orderCount from hgo_order_info " +
                    "where gmt_create BETWEEN ?1 and ?2 " +
                    "and extra8 < order_endtime " +
                    "and order_status = 9 GROUP BY horseman_name order by orderCount desc")
    List<Object[]> getOrderInfoByHorseManTimeOut(String startTime,String endTime);

    @Query(nativeQuery = true,
            value = "select sum( CASE HOUR ( gmt_create ) WHEN '10' THEN 1 ELSE 0 END ) AS ten," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '11' THEN 1 ELSE 0 END ) AS eleven," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '12' THEN 1 ELSE 0 END ) AS twelve," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '13' THEN 1 ELSE 0 END ) AS thirteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '14' THEN 1 ELSE 0 END ) AS fourteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '15' THEN 1 ELSE 0 END ) AS fifteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '16' THEN 1 ELSE 0 END ) AS sixteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '17' THEN 1 ELSE 0 END ) AS seventeen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '18' THEN 1 ELSE 0 END ) AS eighteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '19' THEN 1 ELSE 0 END ) AS nineteen," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '20' THEN 1 ELSE 0 END ) AS twenty," +
                    "sum( CASE HOUR ( gmt_create ) WHEN '21' THEN 1 ELSE 0 END ) AS twentyone " +
                    "from hgo_order_info " +
                    "where gmt_create BETWEEN ?1 and ?2 " +
                    "and order_status = 9 ")
    List<Object[]> getOrderInfoByHour(String startTime,String endTime);
}
