package prject.shool.src.com.shoolprject.interbase;

/**
 * Created by Administrator on 2017/1/17.
 *
 * loading枚举
 */
public enum LoadingMode {

    /**
     * 空状态
     */
    STATE_NONE,
    /**
     * 加载中的状态
     */
    STATE_LOADING,

    /**
     * 数据加载超时
     */
    STATE_EMPTY,

    /**
     * 错误的状态
     */
    STATE_ERROR,
    /**
     * 成功的状态
     */
    STATE_SUCCESS;
}
