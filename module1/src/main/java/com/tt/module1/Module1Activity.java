package com.tt.module1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Param;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Lance
 * @date 2018/2/23
 */

@Route(path = "/module1/test")
public class Module1Activity extends Activity {

    @Autowired
    String msg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity_main);
//        ARouter.getInstance().inject(this);
        Log.i("module1", "我是模块1:" + msg);


//        TestService testService = (TestService) ARouter.getInstance().build("/main/service1")
//                .navigation();
//        testService.test();
//
//        TestService testService1 = (TestService) ARouter.getInstance().build("/main/service2")
//                .navigation();
//        testService1.test();
//
//        TestService testService2 = (TestService) ARouter.getInstance().build("/module1/service")
//                .navigation();
//        testService2.test();
//
//        TestService testService3 = (TestService) ARouter.getInstance().build("/module2/service")
//                .navigation();
//        testService3.test();
    }

    public void mainJump(View view) {
        ARouter.getInstance().build("/main/test").withString("a",
                "从Module1").navigation(this);
    }

    public void module2Jump(View view) {
        ARouter.getInstance().build("/module2/test").withString("msg",
                "从Module1").navigation(this);
    }
}
