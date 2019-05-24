package com.joyzone.platform.module.app.controller;

import com.joyzone.platform.common.utils.R;
import com.joyzone.platform.core.model.ForumDetailModel;
import com.joyzone.platform.core.model.ForumModel;
import com.joyzone.platform.core.service.ForumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app_forum")
@Api(tags="app论坛相关操作", description = "AppForumController")
public class AppForumController {

    @Autowired
    private ForumService forumService;

    /**
     * Mr.Gx
     */
    @PostMapping("saveForum")
    @ApiOperation("添加及更新论坛信息  @Mr.Gx")
    public R saveForum(ForumModel forumModel){
        return forumService.saveForumNum(forumModel);
    }

    /**
     * Mr.Gx
     */
    @PostMapping("saveForumDetail")
    @ApiOperation("添加跟帖信息 @Mr.Gx")
    public R saveForumDetail(ForumDetailModel forumDetailModel){
        return forumService.saveForumDetail(forumDetailModel);
    }

    /**
     * Mr.Gx
     */
    @PostMapping("getAppForumList")
    @ApiOperation("获取论坛发帖信息及跟帖信息 @Mr.Gx")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID",paramType = "form"),
            @ApiImplicitParam(name = "type",value = "类型：0.建议,1.吐槽 ",paramType = "form"),
            @ApiImplicitParam(name = "queryType",value = "0 热点,1 最新",paramType = "form",defaultValue = "0"),
            @ApiImplicitParam(name = "pageNum",value = "页数",paramType = "form",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",paramType = "form",defaultValue = "10")
    })
    public R getAppForumList(Long userId,Integer pageNum,Integer pageSize,Integer type,Integer queryType){
        return forumService.getAppForumList(userId,pageNum,pageSize,type,queryType);
    }

    @PostMapping("updateForumPointNum")
    @ApiOperation("给论坛主评论进行点赞 @Mr.Gx")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID",paramType = "form"),
            @ApiImplicitParam(name = "forumId",value = "评论ID",paramType = "form"),
    })
    public R updateForumPointNum(@RequestParam("userId") Long userId,@RequestParam("forumId") Long forumId){
        return forumService.updateForumPointNum(userId,forumId);
    }

    @PostMapping("updateForumDetailPointNum")
    @ApiOperation("给论坛跟帖评论进行点赞 @Mr.Gx")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID",paramType = "form"),
            @ApiImplicitParam(name = "forumDetailId",value = "跟帖评论ID",paramType = "form"),
    })
    public R updateForumDetailPointNum(@RequestParam("userId") Long userId,@RequestParam("forumDetailId") Long forumDetailId){
        return forumService.updateForumDetailPointNum(userId,forumDetailId);
    }

}
