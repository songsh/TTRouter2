package com.tt.dnrouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tt.base.TestService;

/**
 * @author Lance
 * @date 2018/3/6
 */

@Route(path = "/main/service2")
public class TestServiceImpl2 implements TestService {


    @Override
    public void test() {
        Log.i("Service", "我是app模块测试服务通信2");
    }

    @Override
    public void init(Context context) {

    }
}
