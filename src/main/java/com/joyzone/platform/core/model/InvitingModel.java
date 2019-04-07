package com.joyzone.platform.core.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = InvitingModel.TABLE_NAME)
public class InvitingModel extends BaseModel{

    protected static final String TABLE_NAME = "inviting";

    @Id
    @Excel(name="邀请函标识")
    private Long id;

    private Long owner;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "shop_name")
    private String shopName;

    /**
     * 地址
     */
    private String address;

    /**
     * 主题
     */
    private String content;

    /**
     * 邀约类型
     */
    @Excel(name="邀请函标识",replace = {"默认_0"})
    private Integer type;

    /**
     * 受邀人数
     */
    @Excel(name="受邀人数")
    @Transient
    private Integer invitingNum;

    /**
     * 邀约状态;0:有效；1：失效
     */
    private Integer status;

    /**
     * 支付方式：0：AA，1：女生免费；2：赢家免费
     */
    @Column(name = "pay_way")
    @Excel(name="支付类型",replace = {"AA_0","女生免费_1","赢家免费_2"})
    private Integer payWay;

    /**
     * 邀约成功状态：0：失败；1：成功
     */
    @Excel(name="结果",replace = {"失败_0","成功_1"})
    private Integer result;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name="体验时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 邀约创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name="创建时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 邀约修改时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Transient
    private Date endTime;

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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取主题
     *
     * @return content - 主题
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置主题
     *
     * @param content 主题
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取邀约类型
     *
     * @return type - 邀约类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置邀约类型
     *
     * @param type 邀约类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取邀约状态;0:有效；1：失效
     *
     * @return status - 邀约状态;0:有效；1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置邀约状态;0:有效；1：失效
     *
     * @param status 邀约状态;0:有效；1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取邀约成功状态：0：失败；1：成功
     *
     * @return result - 邀约成功状态：0：失败；1：成功
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 设置邀约成功状态：0：失败；1：成功
     *
     * @param result 邀约成功状态：0：失败；1：成功
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 获取邀约创建时间
     *
     * @return create_time - 邀约创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置邀约创建时间
     *
     * @param createTime 邀约创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取邀约修改时间
     *
     * @return update_time - 邀约修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置邀约修改时间
     *
     * @param updateTime 邀约修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取支付方式：0：AA，1：女生免费；2：赢家免费
     *
     * @return pay_way - 支付方式：0：AA，1：女生免费；2：赢家免费
     */
    public Integer getPayWay() {
        return payWay;
    }

    /**
     * 设置支付方式：0：AA，1：女生免费；2：赢家免费
     *
     * @param payWay 支付方式：0：AA，1：女生免费；2：赢家免费
     */
    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getInvitingNum() {
        return invitingNum;
    }

    public void setInvitingNum(Integer invitingNum) {
        this.invitingNum = invitingNum;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}