package com.joyzone.platform.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = TeamModel.TABLE_NAME)
@ApiModel("组队信息")
public class TeamModel {
    protected static final String TABLE_NAME = "team";
    @Id
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("店家ID")
    @Column(name = "shop_id")
    private Long shopId;

    @ApiModelProperty("发起人ID")
    private Long owner;

    /**
     * 活动开始时间
     */
    @ApiModelProperty("活动开始时间")
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 组队类型：:0：组队店家;1:体验店家
     */
    @ApiModelProperty(" 组队类型：:0：组队店家;1:体验店家")
    private Integer type;

    /**
     * 组队状态;0：有效，1：无效
     */
    @ApiModelProperty("组队状态;0：有效，1：无效")
    private Integer status;

    /**
     * 0：组队中；1：组队成功；2：组队失败
     */
    @ApiModelProperty("0：组队中；1：组队成功；2：组队失败")
    private Integer result;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return shop_id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return owner
     */
    public Long getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * 获取活动开始时间
     *
     * @return start_time - 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置活动开始时间
     *
     * @param startTime 活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取组队类型：:0：组队店家;1:体验店家
     *
     * @return type - 组队类型：:0：组队店家;1:体验店家
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置组队类型：:0：组队店家;1:体验店家
     *
     * @param type 组队类型：:0：组队店家;1:体验店家
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取组队状态;0：有效，1：无效
     *
     * @return status - 组队状态;0：有效，1：无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置组队状态;0：有效，1：无效
     *
     * @param status 组队状态;0：有效，1：无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0：组队中；1：组队成功；2：组队失败
     *
     * @return result - 0：组队中；1：组队成功；2：组队失败
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 设置0：组队中；1：组队成功；2：组队失败
     *
     * @param result 0：组队中；1：组队成功；2：组队失败
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}