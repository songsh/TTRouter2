package com.tt.module2;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tt.base.TestService;

/**
 * @author Lance
 * @date 2018/3/6
 */

@Route(path = "/module2/service")
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        Log.i("Service", "我是Module2模块测试服务通信");
    }

    @Override
    public void init(Context context) {

    }
}

