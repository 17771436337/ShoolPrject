package prject.shool.src.com.shoolprject.utils;

import prject.shool.src.com.shoolprject.App;

/**
 * Log测试
 */
public class LogUtil {
    private LogUtil() {
    }

    public static boolean isDebug = App.isDebug;
    //测试
//	public static boolean isDebug = true;

    public static void v(String tag, String msg) {
        if (isDebug)
            android.util.Log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.v(tag, msg, t);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            android.util.Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            android.util.Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            android.util.Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            android.util.Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.e(tag, msg, t);
    }
}
