package prject.shool.src.com.shoolprject.adapter;

import android.support.annotation.Nullable;

import java.util.List;

import prject.shool.src.com.shoolprject.holder.BaseHolder;
import prject.shool.src.com.shoolprject.holder.TextItem;

/**
 * Created by Administrator on 2017/2/12.
 */
public class TestAdapter<T> extends MyBaseAdapter<T> {

    public TestAdapter(@Nullable List<T> data) {
        super(data);
    }

    @Override
    protected BaseHolder getItemHolder(Object type) {
        return new TextItem();
    }


}
