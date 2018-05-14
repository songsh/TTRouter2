package com.tt.module2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Param;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tt.base.TestService;

import com.tt.module2.BuildConfig;

/**
 * @author Lance
 * @date 2018/2/23
 */

@Route(path = "/module2/test")
public class Module2Activity extends Activity {

    @Autowired
    String msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module2_activity_main);
//        ARouter.getInstance().inject(this);
        Log.i("module2", "我是模块2:" + msg);

        //当处于组件模式的时候  BuildConfig.isModule
//        if (BuildConfig.isModule){
//            TestService testService = (TestService) ARouter.getInstance().build("/main/service1")
//                    .navigation();
//            testService.test();
//
//            TestService testService1 = (TestService) ARouter.getInstance().build("/main/service2")
//                    .navigation();
//            testService1.test();
//
//            TestService testService2 = (TestService) ARouter.getInstance().build("/module1/service")
//                    .navigation();
//            testService2.test();
//
//            TestService testService3 = (TestService) ARouter.getInstance().build("/module2/service")
//                    .navigation();
//            testService3.test();
//        }

    }

    public void mainJump(View view) {
        if (BuildConfig.isModule){
            ARouter.getInstance().build("/main/test").withString("a",
                    "从Module2").navigation(this);
        }else{
            Toast.makeText(this,"当前处于组件模式,无法使用此功能",0).show();
        }
    }

    public void module1Jump(View view) {
        ARouter.getInstance().build("/module1/test").withString("msg",
                "从Module2").navigation(this);
    }
}
