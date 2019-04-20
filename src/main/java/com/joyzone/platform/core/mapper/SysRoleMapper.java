package com.joyzone.platform.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.joyzone.platform.core.model.SysRoleModel;

import tk.mybatis.mapper.common.Mapper;

public interface SysRoleMapper extends Mapper<SysRoleModel> {
	
	void addRole(SysRoleModel role);
	
	void addMenus(@Param("ids") Long[] ids, @Param("roleId") Long roleId);
	
	int updateRole(SysRoleModel role);
	
	int deleteMenusByRoleId(@Param("roleId") Long roleId);
	
	int grantRole(@Param("roleId") Long roleId, @Param("userId") Long userId);
	
	int revokeRole(@Param("userId") Long userId);

}
