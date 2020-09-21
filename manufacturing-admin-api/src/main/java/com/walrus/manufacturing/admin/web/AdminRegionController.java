package com.walrus.manufacturing.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.walrus.manufacturing.admin.vo.RegionVo;
import com.walrus.manufacturing.core.util.ResponseUtil;
import com.walrus.manufacturing.db.domain.ManufacturingRegion;
import com.walrus.manufacturing.db.service.ManufacturingRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private ManufacturingRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<ManufacturingRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<ManufacturingRegion> manufacturingRegions = regionService.getAll();
        Map<Byte, List<ManufacturingRegion>> collect = manufacturingRegions.stream().collect(Collectors.groupingBy(ManufacturingRegion::getType));
        byte provinceType = 1;
        List<ManufacturingRegion> provinceList = collect.get(provinceType);
        byte cityType = 2;
        List<ManufacturingRegion> city = collect.get(cityType);
        Map<Integer, List<ManufacturingRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(ManufacturingRegion::getPid));
        byte areaType = 3;
        List<ManufacturingRegion> areas = collect.get(areaType);
        Map<Integer, List<ManufacturingRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(ManufacturingRegion::getPid));

        for (ManufacturingRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<ManufacturingRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (ManufacturingRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(cityVo.getId());
                cityVO.setName(cityVo.getName());
                cityVO.setCode(cityVo.getCode());
                cityVO.setType(cityVo.getType());

                List<ManufacturingRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (ManufacturingRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
