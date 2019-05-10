package com.joyzone.platform.core.mapper;

import com.joyzone.platform.core.base.BaseMapper;
import com.joyzone.platform.core.dto.ShopDto;
import com.joyzone.platform.core.dto.ShopHomeDto;
import com.joyzone.platform.core.model.ShopModel;
import com.joyzone.platform.core.vo.AppShopVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper extends BaseMapper<ShopModel> {
	
	int addShop(ShopModel shop);
	
	int updateShop(ShopModel shop);
	
	int batchDelete(Long[] ids);

	List<AppShopVO> getAppShopList(ShopDto shopDto);

	ShopModel findById(@Param("id") Long id);

	List<ShopModel> findAll();

	List<AppShopVO> getAppShopHomeList(@Param("shopTypeId") Long shopTypeId,@Param("size") Integer size);

	List<String> getShopPicList(@Param("size") Integer size);

	List<ShopHomeDto> getShopHomeList(@Param("userId") Long userId);

}