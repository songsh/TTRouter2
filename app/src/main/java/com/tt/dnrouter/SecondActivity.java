package com.tt.dnrouter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Param;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tt.base.TestService;
import com.tt.dnrouter.parcelable.TestParcelable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lance
 * @date 2018/2/23
 */
@Route(path = "/main/test")
public class SecondActivity extends AppCompatActivity {


    @Autowired
    String a;
    @Autowired
    int b;

    @Autowired(name = "/main/service1")
    TestService testService1;
    @Autowired(name = "/main/service2")
    TestService testService2;
    @Autowired(name = "/module1/service")
    TestService testService3;
    @Autowired(name = "/module2/service")
    TestService testService4;
    private FrameLayout fl_main;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        ARouter.getInstance().inject(this);
        Log.e("Second", toString());

        testService1.test();
//        testService2.test();
        testService3.test();
//        testService4.test();

        initFragment();
    }

    private void initFragment() {
        fragment = (Fragment)ARouter.getInstance().build("/module1/afragment").navigation();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment,fragment).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        setResult(200);
        super.onBackPressed();
    }

    @Override
    public String toString() {
        return "SecondActivity{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
}
