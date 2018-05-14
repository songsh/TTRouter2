package com.tt.dnrouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tt.base.TestService;
import com.tt.dnrouter.parcelable.TestParcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        /**
         * 组件服务共享 通信
         */
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


    public void innerJump(View view) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("2");

        ArrayList<TestParcelable> ps = new ArrayList<TestParcelable>();

        TestParcelable testParcelable = new TestParcelable(1, "a");
        TestParcelable testParcelable2 = new TestParcelable(2, "d");
        ps.add(testParcelable);
        ps.add(testParcelable2);

        ARouter.getInstance().build("/main/test").withString("a",
                "从MainActivity")
                .navigation(this, 100);
    }

    public void module1Jump(View view) {
        ARouter.getInstance().build("/module1/test").withString("msg",
                "从MainActivity").navigation();
    }

    public void module2Jump(View view) {
        ARouter.getInstance().build("/module2/test").withString("msg",
                "从MainActivity").navigation();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Main", requestCode + ":" + resultCode + ":" + data);
    }
}
