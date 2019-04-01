package com.joyzone.platform.module.admin.controller;

import com.joyzone.platform.common.utils.PublicUtil;
import com.joyzone.platform.common.utils.R;
import com.joyzone.platform.core.model.ShopModel;
import com.joyzone.platform.core.service.ShopService;
import com.joyzone.platform.core.service.ShopTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopType")
@Api(value="后台门店类型及种类V",description="后台门店类型及种类",tags="1.0")
public class ShopTypeController {
	
	@Autowired
	private ShopTypeService shopTypeService;
	
	@GetMapping("getShopTypeList/{pid}")
	@ApiOperation("店家的类型及类型旗下的种类")
	public R getShopTypeList(@PathVariable Long pid) {
		if(pid == null){
			return R.ok(shopTypeService.findByShopType());
		}
		return R.ok(shopTypeService.findByPid(pid));
	}

}
