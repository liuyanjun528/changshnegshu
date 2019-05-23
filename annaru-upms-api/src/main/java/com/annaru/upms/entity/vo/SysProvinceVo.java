package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.SysCity;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

public class SysProvinceVo extends Model<SysProvinceVo> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String provinceId;
    private String province;
    private List<SysCityVo> sysCityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<SysCityVo> getSysCityList() {
        return sysCityList;
    }

    public void setSysCityList(List<SysCityVo> sysCityList) {
        this.sysCityList = sysCityList;
    }


}
