package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.SysDistrict;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

public class SysCityVo extends Model<SysCityVo> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cityId;
    private String city;
    private String provinceId;
    private List<SysDistrictVo> districtList;

    public List<SysDistrictVo> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<SysDistrictVo> districtList) {
        this.districtList = districtList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

}
