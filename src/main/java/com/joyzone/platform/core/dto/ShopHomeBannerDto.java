package com.joyzone.platform.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joyzone.platform.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zy on 2019/5/10.
 */
@ApiModel("商家首页banner图DTO")
@Configuration
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ShopHomeBannerDto extends BaseModel {

    @ApiModelProperty("店家ID")
    private Long shopId;

    @ApiModelProperty("店家封面")
    private String shopCoverImg;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopCoverImg() {
        return shopCoverImg;
    }

    public void setShopCoverImg(String shopCoverImg) {
        this.shopCoverImg = shopCoverImg;
    }


}
