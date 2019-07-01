package com.sjyg.lzx.exportdata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * 订单表Entity
 * @author zhuzengpeng
 * @version 2018-06-19
 */
@Entity
@Table(name = "hgo_order_info")
public class HgoOrderInfo {

	@Id
	private BigInteger id;
	private String merchantName;
	private Integer orderCount;

	@Override
	public String toString() {
		return "HgoOrderInfo{" +
				"id=" + id +
				", merchantName='" + merchantName + '\'' +
				", orderCount=" + orderCount +
				'}';
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	/*private String orderNo;		// 流水号
	private Long merchantId;		// 商家id
	private String merchantName;		// 商家名称
	private String merchantEnglish;		// 商家名称
	private String hopeTime;		// 送达时间
	private String deliverAddress;		// 送货地址
	private String longitude;		// 送货位置-经度
	private String latitude;		// 送货位置-纬度
	private String deliverType;		// 配送方式
	private Long horsemanId;		// 配送骑手id
	private String horsemanName;		// 配送骑手姓名
	private String horsemanPhone;		// 配送骑手手机号
	private String orderAmount;		// 优惠前金额
	private Long mycouponId;		// 我的优惠券id
	private String discountAmount;		// 优惠金额
	private Long mycashId;		// 我的代金券id
	private String cashAmount;		// 代金券金额
	private String packAmount;		// 包装费
	private String deliverAmount;		// 配送费
	private String realAmount;		// 实付款
	private String nickName;		// 客户姓名
	private String payType;		// 支付方式
	private String orderStatus;		// 订单状态
	private String extra1;		// extra1
	private String extra2;		// extra2
	private String extra3;		// extra3
	private String extra4;		// extra4
	private String extra5;		// extra5
	private Date gmtCreate;		// gmt_create
	private Date gmtModified;		// 记录修改时间
	private Date startTime;		// 有效开始时间
	private Date endTime;		// 有效结束时间
	private String orderFlag;   //是否处理标识 0未处理；1已处理
	private String shippingFee;		// 骑手配送费
	private String extra8;		// 送达时间
    private String hgoHorsemanInfo;
    private Date orderEndTime;  //订单完成时间
	private String extra10;		// 配送时间
	private double timeoutFlag; // 真实配送时间 单位：分钟
	private String orderDistance;	//配送距离
	private String isNewUser;	//新用户下单
	private String horsemanKnotSite;	//骑手结款站点
	private String knotManLoginName;	//结款操作人员
	private Date orderKnotTime;  //订单结款时间
	private String originalOrderAmount;		// 计算商家优惠活动前的订单总金额
	private String horsemanKnotSiteName;	//骑手结款站点名称

	public Date getOrderKnotTime() {
		return orderKnotTime;
	}

	public void setOrderKnotTime(Date orderKnotTime) {
		this.orderKnotTime = orderKnotTime;
	}

	public String getHorsemanKnotSite() {
		return horsemanKnotSite;
	}

	public void setHorsemanKnotSite(String horsemanKnotSite) {
		this.horsemanKnotSite = horsemanKnotSite;
	}

	public String getKnotManLoginName() {
		return knotManLoginName;
	}

	public void setKnotManLoginName(String knotManLoginName) {
		this.knotManLoginName = knotManLoginName;
	}

	public String getMerchantEnglish() {
		return merchantEnglish;
	}

	public void setMerchantEnglish(String merchantEnglish) {
		this.merchantEnglish = merchantEnglish;
	}

	public double getTimeoutFlag() {
		return timeoutFlag;
	}

	public void setTimeoutFlag(double timeoutFlag) {
		this.timeoutFlag = timeoutFlag;
	}

	public String getExtra10() {
		return extra10;
	}

	public void setExtra10(String extra10) {
		this.extra10 = extra10;
	}

	public Date getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(Date orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public String getExtra8() {
		return extra8;
	}

	public void setExtra8(String extra8) {
		this.extra8 = extra8;
	}

	public String getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(String shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}

	@Length(min=0, max=100, message="流水号长度必须介于 0 和 100 之间")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	
	@Length(min=0, max=100, message="商家名称长度必须介于 0 和 100 之间")
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	@Length(min=0, max=50, message="送达时间长度必须介于 0 和 50 之间")
	public String getHopeTime() {
		return hopeTime;
	}

	public void setHopeTime(String hopeTime) {
		this.hopeTime = hopeTime;
	}
	
	@Length(min=0, max=500, message="送货地址长度必须介于 0 和 500 之间")
	public String getDeliverAddress() {
		return deliverAddress;
	}

	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Length(min=0, max=100, message="配送方式长度必须介于 0 和 100 之间")
	public String getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}
	
	public Long getHorsemanId() {
		return horsemanId;
	}

	public void setHorsemanId(Long horsemanId) {
		this.horsemanId = horsemanId;
	}
	
	@Length(min=0, max=100, message="配送骑手姓名长度必须介于 0 和 100 之间")
	public String getHorsemanName() {
		return horsemanName;
	}

	public void setHorsemanName(String horsemanName) {
		this.horsemanName = horsemanName;
	}
	
	@Length(min=0, max=100, message="配送骑手手机号长度必须介于 0 和 100 之间")
	public String getHorsemanPhone() {
		return horsemanPhone;
	}

	public void setHorsemanPhone(String horsemanPhone) {
		this.horsemanPhone = horsemanPhone;
	}
	
	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	public Long getMycouponId() {
		return mycouponId;
	}

	public void setMycouponId(Long mycouponId) {
		this.mycouponId = mycouponId;
	}
	
	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	public Long getMycashId() {
		return mycashId;
	}

	public void setMycashId(Long mycashId) {
		this.mycashId = mycashId;
	}
	
	public String getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(String cashAmount) {
		this.cashAmount = cashAmount;
	}
	
	public String getPackAmount() {
		return packAmount;
	}

	public void setPackAmount(String packAmount) {
		this.packAmount = packAmount;
	}
	
	public String getDeliverAmount() {
		return deliverAmount;
	}

	public void setDeliverAmount(String deliverAmount) {
		this.deliverAmount = deliverAmount;
	}
	
	public String getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(String realAmount) {
		this.realAmount = realAmount;
	}
	
	@Length(min=0, max=100, message="客户姓名长度必须介于 0 和 100 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}
	
	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}
	
	public String getExtra3() {
		return extra3;
	}

	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}
	
	public String getExtra4() {
		return extra4;
	}

	public void setExtra4(String extra4) {
		this.extra4 = extra4;
	}
	
	public String getExtra5() {
		return extra5;
	}

	public void setExtra5(String extra5) {
		this.extra5 = extra5;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

    public void setHgoHorsemanInfo(String hgoHorsemanInfo) {
        this.hgoHorsemanInfo = hgoHorsemanInfo;
    }

    public String getHgoHorsemanInfo() {
        return hgoHorsemanInfo;
    }

	public String getOrderDistance() {
		return orderDistance;
	}

	public void setOrderDistance(String orderDistance) {
		this.orderDistance = orderDistance;
	}

	public String getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(String isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getOriginalOrderAmount() {
		return originalOrderAmount;
	}

	public void setOriginalOrderAmount(String originalOrderAmount) {
		this.originalOrderAmount = originalOrderAmount;
	}

	public String getHorsemanKnotSiteName() {
		return horsemanKnotSiteName;
	}

	public void setHorsemanKnotSiteName(String horsemanKnotSiteName) {
		this.horsemanKnotSiteName = horsemanKnotSiteName;
	}*/
}