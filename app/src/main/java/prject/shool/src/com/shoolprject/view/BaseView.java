package prject.shool.src.com.shoolprject.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import prject.shool.src.com.shoolprject.interbase.BasePage;

/**
 * Created by Administrator on 2017/1/17.
 */
public abstract class BaseView implements BasePage {

    protected Context context;
    protected View mView;
    protected Object mTag;

    public BaseView(Context mContext) {
        this.context = mContext;
        mView = LayoutInflater.from(context).inflate(getLayout(), null);
        ButterKnife.inject(this, mView);
        initView();
        initData();

    }

    public View getView() {
        return mView;
    }

    public void setTag(Object tag) {
        mTag = tag;
    }


    protected View findViewById(int id) {
        return mView.findViewById(id);
    }
}
