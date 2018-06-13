package com.xh.study.bcy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;
import java.util.Random;

/**
 * Created by XH on 2018/1/29.
 */

public class CommonUtil {
    public static List getRandomList(List list,int splitSize){
        Random random = new Random();
        if(list.size()>splitSize) {
            int i = random.nextInt(list.size() - splitSize);
            return list.subList(i,i+splitSize);
        }
        return list;
    }
}
