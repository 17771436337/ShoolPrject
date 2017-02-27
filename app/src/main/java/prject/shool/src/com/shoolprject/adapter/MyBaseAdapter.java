package prject.shool.src.com.shoolprject.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import kale.adapter.CommonAdapter;
import kale.adapter.item.AdapterItem;
import prject.shool.src.com.shoolprject.holder.BaseHolder;

/**
 * Created by Administrator on 2017/2/11.
 */
public abstract class MyBaseAdapter<T> extends CommonAdapter<T>{

    /**加载不同布局*/
    public MyBaseAdapter(@Nullable List<T> data, int viewTypeCount) {
        super(data, viewTypeCount);
    }

    /**加载相同布局*/
    public MyBaseAdapter(@Nullable List<T> data) {
        super(data, 1);
    }

    @Override
    public T getItemType(T t) {
        return t;
    }

    @NonNull
    @Override
    public AdapterItem createItem(Object type) {
        return getItemHolder(type);
    }


    /**添加不同的Handler*/
    protected abstract BaseHolder getItemHolder(Object type);
}
