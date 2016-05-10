package com.example.lenovo.kr36.base;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sige on 16/5/10.
 */

/**
 * 本来描述：这是应用APP的基类,用来替换系统的Application,一个APP的所有activity都加入到这个List中，
 *          方便最后到退出。
 *        完成本类后，要到清单文件中的<Application标签中注册一下BaseApplication android:name=".base.BaseApplication"**/
public class BaseApplication  extends Application {
    public  static List<Activity> activityList;//存放所有activity的集合
    public static void addActivity(Activity activity){
        if(activityList==null){
            activityList= new ArrayList<>();
        }
        activityList.add(activity);//将activity加入到集中
    }
    public static void delActivity(Activity activity){
        activityList.remove(activity);//从集合中删除一个 activity

    }
    //将集合里的所有activity都finish掉
    public  static  void finishAll(){
        for (Activity activity : activityList) {
            if(!activity.isFinishing()){//如果当前这个activity不是正在结束
                activity.finish();//结束这个activity
            }
        }

    }

}
