package com.xh.study.bcy.adapter.model;

import com.xh.study.bcy.bean.TypeTagCircleBean;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.utils.ListBeanConvert;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

/**
 * Created by xh on 17/05/2018.
 */

@Entity
public class TagCoreListModel {
    @Convert(converter = ListBeanConvert.class,columnType = String.class)
    private List<TypeTagCircleBean> typeTagCircleBeans;

    @Convert(converter = ListBeanConvert.class,columnType = String.class)
    private List<WeekHotWorkBean> weekHotWorkBeans;


    @Generated(hash = 1650793241)
    public TagCoreListModel(List<TypeTagCircleBean> typeTagCircleBeans,
                            List<WeekHotWorkBean> weekHotWorkBeans) {
        this.typeTagCircleBeans = typeTagCircleBeans;
        this.weekHotWorkBeans = weekHotWorkBeans;
    }

    @Generated(hash = 1143517574)
    public TagCoreListModel() {
    }


    public List<TypeTagCircleBean> getTypeTagCircleBeans() {
        return typeTagCircleBeans;
    }

    public void setTypeTagCircleBeans(List<TypeTagCircleBean> typeTagCircleBeans) {
        this.typeTagCircleBeans = typeTagCircleBeans;
    }

    public List<WeekHotWorkBean> getWeekHotWorkBeans() {
        return weekHotWorkBeans;
    }

    public void setWeekHotWorkBeans(List<WeekHotWorkBean> weekHotWorkBeans) {
        this.weekHotWorkBeans = weekHotWorkBeans;
    }
}
