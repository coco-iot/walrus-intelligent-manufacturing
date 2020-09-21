package com.walrus.manufacturing.wx.service;

import com.walrus.manufacturing.db.domain.ManufacturingRegion;
import com.walrus.manufacturing.db.service.ManufacturingRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private ManufacturingRegionService regionService;

	private static List<ManufacturingRegion> manufacturingRegions;

	protected List<ManufacturingRegion> getManufacturingRegions() {
		if(manufacturingRegions==null){
			createRegion();
		}
		return manufacturingRegions;
	}

	private synchronized void createRegion(){
		if (manufacturingRegions == null) {
			manufacturingRegions = regionService.getAll();
		}
	}
}
