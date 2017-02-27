package prject.shool.src.com.shoolprject.libView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.OnClick;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.interbase.LoadingMode;
import prject.shool.src.com.shoolprject.interbase.LoadingOnClick;
import prject.shool.src.com.shoolprject.utils.LayoutUtil;
import prject.shool.src.com.shoolprject.utils.ToastUtils;

/**
 * Created by Administrator on 2017/2/12.
 * Loading加载类
 */
public class LoadingView extends FrameLayout implements View.OnClickListener{




    /**
     * 空视图
     */
    private View nullView;

    /**
     * 数据加载错误
     */
    private View errorView;


    /**
     * 数据加载超时
     */
    private View emptView;

    /**
     * 成功视图
     */
    private View SuccessView;


    //---------------------------

    private Button pullButError;//错误视图加载数据
    private Button pullButEmpt;// 加载超数据刷新按钮
    //---------------------------

    private Context context;
    LoadingOnClick loadingOnClick;

    /**
     * c
     *
     * @param context 环境变量 h
     * @param view    成功视图
     */
    public LoadingView(Context context, View view, LoadingOnClick loadingOnClick) {
        super(context);
        this.context = context;
        SuccessView = view;
        this.loadingOnClick = loadingOnClick;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, Context context1, View successView, LoadingOnClick loadingOnClick) {
        super(context, attrs);
        context = context1;
        SuccessView = successView;
        this.loadingOnClick = loadingOnClick;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, View successView, Context context1, LoadingOnClick loadingOnClick) {
        super(context, attrs, defStyleAttr);
        SuccessView = successView;
        context = context1;
        this.loadingOnClick = loadingOnClick;
        init();
    }

    /**
     * 布局初始化
     */
    private void init() {
        nullView = LayoutUtil.getLayoutInflater(context, R.layout.view_nulldata);//空数据视图初始化
        errorView = LayoutUtil.getLayoutInflater(context, R.layout.view_error);//错误视图初始化
        emptView = LayoutUtil.getLayoutInflater(context, R.layout.view_empt);//超时视图初始化

        this.addView(nullView);
        this.addView(errorView);
        this.addView(emptView);
        this.addView(SuccessView);


        pullButError = (Button) findViewById(R.id.pull_but_error,errorView);
        pullButEmpt = (Button) findViewById(R.id.pull_but_empt,emptView);


        pullButError.setOnClickListener(this);
        pullButEmpt.setOnClickListener(this);
    }


    public void setMode(LoadingMode mode) {
        switch (mode) {
            case STATE_EMPTY: //数据加载超时
                showEmpt();
                break;
            case STATE_ERROR: //数据加载错误
                showError();
                break;
            case STATE_LOADING:// 加载中的状态
                break;
            case STATE_NONE: //空状态
                showNull();
                break;
            case STATE_SUCCESS://成功的状态
                showSuccess();
                break;
        }
    }

    /**
     * 显示成功界面
     */
    private void showSuccess() {
        SuccessView.setVisibility(View.VISIBLE);
        nullView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptView.setVisibility(View.GONE);
    }


    /**
     * 显示空界面
     */
    private void showNull() {
        SuccessView.setVisibility(View.GONE);
        nullView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        emptView.setVisibility(View.GONE);
    }

    /**
     * 显示错误界面
     */
    private void showError() {
        SuccessView.setVisibility(View.GONE);
        nullView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        emptView.setVisibility(View.GONE);
    }


    /**
     * 显示加载超时界面
     */
    private void showEmpt() {
        SuccessView.setVisibility(View.GONE);
        nullView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.pull_but_empt)
    public void emptButton(View v) {
        ToastUtils.show(context, "这是刷新");

    }

    /**
     * 初始化
     */
    protected View findViewById(int id, View view) {
        return view.findViewById(id);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pull_but_error:
                loadingOnClick.onClickError();
            break;
            case R.id.pull_but_empt:
                loadingOnClick.onClickEmpt();
                break;
        }
    }

}
