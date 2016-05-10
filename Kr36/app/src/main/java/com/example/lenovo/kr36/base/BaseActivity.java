package com.example.lenovo.kr36.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by sige on 16/5/10.
 * 本类描述：制作当前项目里所有的基类，用来存放一些公用的代码
 * 本类实现：复写 onCreate onDestroy两个方法
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    // 是否允许全屏
    private boolean mAllowFullScreen = true;
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    public BaseActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //向activityList中添加自己
        initContentView(savedInstanceState);
        initData();
        BaseApplication.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        //从activityList集合中将自己去掉
        BaseApplication.delActivity(this);
        super.onDestroy();
    }
    public abstract void initContentView(Bundle savedInstanceState);

    public abstract void buttonClick(View v);
    public abstract void initData();
    protected <T extends View> T bindView(int id){
        return (T) findViewById(id);
    }

    @Override
    public void onClick(View v) {
        buttonClick(v);
    }
}
