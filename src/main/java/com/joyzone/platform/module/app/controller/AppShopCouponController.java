package com.joyzone.platform.module.app.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.joyzone.platform.common.utils.R;
import com.joyzone.platform.core.dto.CouponDto;
import com.joyzone.platform.core.model.CouponUserModel;
import com.joyzone.platform.core.model.ShopCouponModel;
import com.joyzone.platform.core.model.TeamModel;
import com.joyzone.platform.core.service.CouponUserService;
import com.joyzone.platform.core.service.ShopCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app_shopcoupon")
@Api(tags = "app商家体验券相关接口",description = "AppShopCouponController")
public class AppShopCouponController {

    @Autowired
    private ShopCouponService shopCouponService;
    @Autowired
    private CouponUserService couponUserService;
    @Autowired
    private ShopCouponService couponService;


    /**
     * zy
     */
    @PostMapping("/getCouponList")
    @ApiOperation("前端获取体验券列表 @zhangyu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort", value = "0:热点 1：最新", required = true, dataType = "Integer", paramType = "query")
    })
    public R getCouponList(ShopCouponModel shopCouponModel, Integer sort){
        PageHelper.startPage(0,10);
        List<CouponDto> couponDtoList = shopCouponService.getCouponList(shopCouponModel,sort);
        if(couponDtoList != null && couponDtoList.size() > 0){
            Page page = new Page();
            page = (Page)couponDtoList;
            return R.pageToData(page.getTotal(),page.getResult());
        }
        return R.pageToData(0L,new ArrayList<>());
    }

    /**
     * zy
     */
    @PostMapping("/getCouponShopList")
    @ApiOperation("前端获取体验券店家列表 @zhangyu")
    public R getCouponShopList(ShopCouponModel shopCouponModel){
        List<Map<String,Object>> couponShopList = shopCouponService.getCouponShopList(shopCouponModel);
        if(couponShopList != null && couponShopList.size() > 0){
            Page page = new Page();
            page = (Page)couponShopList;
            return R.pageToData(page.getTotal(),page.getResult());
        }
        return R.pageToData(0L,new ArrayList<>());
    }

    @PostMapping("/joinTheCoupon")
    @ApiOperation("前端用户领取体验券 @zhangyu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "couponId", value = "体验券ID", required = true, dataType = "Long", paramType = "query")
    })
    public R joinTheCoupon(CouponUserModel model, Long userId, Long couponId){
        CouponUserModel couponUserModel = couponUserService.checkUserInCoupon(model,userId,couponId);
        if(couponUserModel != null && couponUserModel.getStatus() == 0){
            return R.error("用户已领取该体验券！");
        }
        if(couponUserModel != null && couponUserModel.getStatus() == 1){
            couponUserModel.setStatus(0);
            couponUserModel.setUpdateTime(new Date());
            int result = couponUserService.update(couponUserModel);
            checkCouponIfSuccess(couponId);
            if(result == 1){
                return R.ok("用户领取成功！");
            }else {
                return R.error("用户领取失败！");
            }
        }
        CouponUserModel bean = new CouponUserModel();
        bean.setCouponId(couponId);
        bean.setUserId(userId);
        bean.setStatus(0);
        bean.setCreateTime(new Date());
        int ret = couponUserService.save(bean);
        checkCouponIfSuccess(couponId);
        if(ret == 1){
            return R.ok("用户领取成功！");
        }else {
            return R.error("用户领取失败！");
        }
    }

    public void checkCouponIfSuccess(Long couponId){
        Map<String,Object> couponInfo = couponService.checkCouponIfSuccess(couponId);
        Integer number = (Integer) couponInfo.get("number");
        Integer joinNum = Integer.parseInt(couponInfo.get("joinNum").toString());
        if(number == joinNum){
            ShopCouponModel model = new ShopCouponModel();
            model.setId(couponId);
            model.setResult(1);
            model.setUpdateTime(new Date());
            couponService.update(model);
        }
    }

}
