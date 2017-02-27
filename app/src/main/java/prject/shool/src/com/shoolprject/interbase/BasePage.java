package prject.shool.src.com.shoolprject.interbase;

/**
 * Created by Administrator on 2016/12/22.
 * Activity抽象类
 */
public interface BasePage {
    /**
     * 布局嵌入
     */
    int getLayout();

    /**
     * 布局初始化
     */
    void initView();

    /**
     * 数据初始化
     */
    void initData();



}
