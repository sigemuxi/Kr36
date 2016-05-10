package com.example.lenovo.kr36.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2016/5/10.
 */
public abstract class BaseFragment extends Fragment {

    //创建的Context对象
    private Context mContext;

    /**
         *  context 从依附的Activity 上获取 context 对象
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = mContext;
    }

    /**

     *  初始化视图
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initLayout(),container,false);
    }
    /**

     *  加载组件
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    /**
     *  加载数据
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**

     *  这三个抽象方法
     */
    public abstract int initView();

    public abstract void initData();

    public abstract int initLayout();


    /**

     */
    protected <T extends View> T bindView(int id){
        return (T) getView().findViewById(id);
    }

}