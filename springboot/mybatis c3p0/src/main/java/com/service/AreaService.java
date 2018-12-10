package com.service;

import java.util.List;

import com.entity.Area;
//service层接口里的方法不一定要和dao层接口里的方法一一对应
public interface AreaService {

	/**
	 * 获取区域列表
	 * 
	 * @return
	 */
	List<Area> getAreaList();

	/**
	 * 通过区域Id获取区域信息
	 * 
	 * @param areaId
	 * @return
	 */
	Area getAreaById(int areaId);

	/**
	 * 增加区域信息
	 * 
	 * @param area
	 * @return
	 */
	boolean addArea(Area area);

	/**
	 * 修改区域信息
	 * 
	 * @param area
	 * @return
	 */
	boolean modifyArea(Area area);

	/**
	 * 删除区域信息
	 * 
	 * @param area
	 * @return
	 */
	boolean deleteArea(int areaId);

}
