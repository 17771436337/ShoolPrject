package prject.shool.src.com.shoolprject.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import kale.adapter.CommonRcvAdapter;
import kale.adapter.item.AdapterItem;
import prject.shool.src.com.shoolprject.holder.BaseHolder;

/**
 * Created by Administrator on 2017/2/12.
 */
public abstract class BaseRecyclerAdapter<T> extends CommonRcvAdapter<T> {


    public BaseRecyclerAdapter(@Nullable List<T> data) {
        super(data);
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
