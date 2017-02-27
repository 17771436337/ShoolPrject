package prject.shool.src.com.shoolprject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import prject.shool.src.com.shoolprject.interbase.BasePage;
import prject.shool.src.com.shoolprject.interbase.LoadingOnClick;
import prject.shool.src.com.shoolprject.libView.LoadingView;

/**
 * Created by Administrator on 2016/12/22.
 */
public abstract class BaseFragment extends Fragment implements BasePage ,LoadingOnClick{

    /**
     * 布局
     */
    protected View view;

    /**
     * 上下文
     */
    protected Context context;

    LoadingView loadingView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), null);
        context = getActivity();
        loadingView = new LoadingView(context,view,this);
        return loadingView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.inject(this, view);
        initView();
        initData();

    }




    @Override
    public void initView() {



    }

    @Override
    public void initData() {

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

    //-------------------

    /**
     * 添加数据
     */
    protected abstract void getData();


    /**数据绑定视图*/
    protected View findViewById(int id) {
        return view.findViewById(id);
    }

}
