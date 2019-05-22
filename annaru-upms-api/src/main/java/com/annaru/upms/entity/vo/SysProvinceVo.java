package com.annaru.upms.entity.vo;

import com.annaru.upms.entity.SysCity;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

public class SysProvinceVo extends Model<SysProvinceVo> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String provinceid;
    private String province;
    private List<SysCity> sysCityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<SysCity> getSysCityList() {
        return sysCityList;
    }

    public void setSysCityList(List<SysCity> sysCityList) {
        this.sysCityList = sysCityList;
    }


}
