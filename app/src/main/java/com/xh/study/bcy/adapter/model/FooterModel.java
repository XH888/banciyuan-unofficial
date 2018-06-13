package com.xh.study.bcy.adapter.model;

/**
 * Created by xh on 14/05/2018
 */

public class FooterModel {
    /**
     * 表示是否还有数据
     * 0:下拉加载更多喵
     * 1:正在加载新内容喵
     * -1:已经到底啦喵
     */
    private int type = 1;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
