package prject.shool.src.com.shoolprject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import prject.shool.src.com.shoolprject.R;

/**
 * Created by Administrator on 2017/2/12.
 */
public class Fragment extends android.support.v4.app.Fragment{
   /*
    * 布局
    */
    protected View view;

    /**
     * 上下文
     */
    protected Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanate) {
        view = inflater.inflate(R.layout.fragment_text, null);
        context = getActivity();

        return view;
    }
}

