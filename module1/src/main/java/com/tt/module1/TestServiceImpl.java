package com.tt.module1;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tt.base.TestService;


@Route(path = "/module1/service")
public class TestServiceImpl implements TestService {


    @Override
    public void test() {
        Log.i("Service", "我是Module1模块测试服务通信");
    }

    @Override
    public void init(Context context) {

    }
}

