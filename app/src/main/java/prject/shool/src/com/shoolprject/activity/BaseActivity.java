package prject.shool.src.com.shoolprject.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import prject.shool.src.com.shoolprject.App;
import prject.shool.src.com.shoolprject.interbase.BasePage;
import prject.shool.src.com.shoolprject.interbase.LoadingMode;
import prject.shool.src.com.shoolprject.interbase.LoadingOnClick;
import prject.shool.src.com.shoolprject.libView.LoadingView;
import prject.shool.src.com.shoolprject.utils.PageJumpsUtils;
import prject.shool.src.com.shoolprject.utils.ScreenUtils;

/**
 * Created by Administrator on 2016/12/22.
 */
public abstract class BaseActivity extends AppCompatActivity implements BasePage ,LoadingOnClick{
    /**
     * 布局
     */
    protected View view;

    protected Context context;

    LoadingView loadingView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.initScreen(this);//获取当前屏幕相关信息初始化 /
        view = LayoutInflater.from(this).inflate(getLayout(), null);
        loadingView = new LoadingView(this,view,this);
        setContentView(loadingView);
        context = this;
        ButterKnife.inject(this, view);
        setMode(LoadingMode.STATE_NONE);
        initView();
        initData();


    }

    @Override
    protected void onStart() {
        super.onStart();
        App.getActivities().add(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getActivities().remove(this);
    }

    @Override
    protected void onResume() {

        // 横屏设置
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    @Override
    public void finish() {
        super.finish();
        PageJumpsUtils.finish(this);
    }

    /**
     * 设置模式
     */
    public void setMode(LoadingMode mode) {
        loadingView.setMode(mode);
    }

    //-------------------

    @Override
    public void onClickError() {
        getData();
    }

    @Override
    public void onClickEmpt() {
        getData();

    }


    /**
     * 添加数据
     */
    protected abstract void getData();


}



