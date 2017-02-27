package prject.shool.src.com.shoolprject.holder;

import android.view.View;

import butterknife.ButterKnife;
import kale.adapter.item.AdapterItem;

/**
 * Created by Administrator on 2017/2/12.
 */
public abstract class BaseHolder<T> implements AdapterItem<T> {


    @Override
    public void bindViews(View root) {
        ButterKnife.inject(this,root);
        initView();
    }

    @Override
    public void setViews() {

    }

    /**初始化布局*/
    protected  abstract void initView();


}
