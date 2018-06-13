package com.xh.study.bcy.utils;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by xh on 05/05/2018.
 */

public class ListBeanConvert implements PropertyConverter<List,String> {

    @Override
    public List convertToEntityProperty(String databaseValue) {
        return RestProvider.gson.fromJson(databaseValue,List.class);
    }

    @Override
    public String convertToDatabaseValue(List entityProperty) {
        return RestProvider.gson.toJson(entityProperty);
    }
}
