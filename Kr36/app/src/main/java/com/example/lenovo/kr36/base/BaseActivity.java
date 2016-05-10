package com.example.lenovo.kr36.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/1/25.、
 * 本类描述：制作当前项目里所有的基类，用来存放一些公用的代码
 * 本类实现：复写 onCreate onDestroy两个方法
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //向activityList中添加自己
        BaseApplication.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        //从activityList集合中将自己去掉
        BaseApplication.delActivity(this);
        super.onDestroy();
    }
    protected <T extends View> T bindView(int id){
        return (T) findViewById(id);
    }
}
