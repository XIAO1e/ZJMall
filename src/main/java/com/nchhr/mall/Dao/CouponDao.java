package com.nchhr.mall.dao;

import com.nchhr.mall.entity.CouponEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CouponDao {

    //通过用户ID和状态查询自己的优惠券信息（多表）
    @Select("select * from offeCoupon, coupon where offeCoupon.COid = coupon.Co_id and Receiver = #{Receiver} and state = #{state}")
    List<CouponEntity> getCoupons(@Param("Receiver") String Receiver, @Param("state") String state);

    //通过id查询某个优惠券信息（多表）
    @Select("select * from offeCoupon, coupon where offeCoupon.COid = coupon.Co_id and OFid = #{OFid}")
    CouponEntity getCouponById(@Param("OFid") String OFid);

    //改变优惠券状态
    @Update("update offeCoupon set state = #{state}, useTime = #{useTime} where OFid = #{OFid}")
    void updateCouponUsageInfo(CouponEntity couponEntity);

}
