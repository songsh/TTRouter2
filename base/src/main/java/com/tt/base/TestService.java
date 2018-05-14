package com.tt.base;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author Lance
 * @date 2018/3/6
 * <p>
 * <p>
 * 需要组件共享的服务需要将服务在此暴露
 */
public interface TestService extends IProvider {
    void test();
}
