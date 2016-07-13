package com.mangocandy.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"rSnw3XK9gM6rLpDBXQbnh63P-gzGzoHsz","a0SolceHbChYjzVc2nCJnXST");
    }
}
