package prject.shool.src.com.shoolprject.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/4.
 * 弹框提示语句
 */
public class ToastUtils {
    /**
     * 弹框提示
     *
     * @param context
     * @param value   提示内容
     */
    public static void show(Context context, String value) {
        Toast.makeText(context, value + "", Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹框提示
     *
     * @param context
     * @param value   提示内容
     */
    public static void show(Context context, int value) {
        Toast.makeText(context, value + "", Toast.LENGTH_SHORT).show();
    }


    /**
     * 弹框相对长时间提示
     *
     * @param context
     * @param value   提示内容
     */
    public static void showLong(Context context, String value) {
        Toast toast = Toast.makeText(context, value, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * 当字符串为空时提示语句
     * 为空则为假
     *
     * @param value 是否为空的字符串
     * @param toast 提示语句
     */
    public static boolean isEmpty(Context context, String value, String toast) {
        boolean is = true;
        if (TextUtils.isEmpty(value)) {
            Toast.makeText(context, toast + "", Toast.LENGTH_SHORT).show();
            is = false;
        }

        return is;
    }

    /**
     * 当字符串为空时提示语句
     * 为空则为假
     *
     * @param value 是否为空的字符串
     * @param toast 提示语句
     */
    public static boolean isEmpty(Context context, String value, int toast) {
        boolean is = true;
        if (TextUtils.isEmpty(value)) {
            Toast.makeText(context, toast + "", Toast.LENGTH_SHORT).show();
            is = false;
        }
        return is;

    }


    /**
     * 当字符串没有达到规定长度时提示语句
     * 返回为true，则是达到对应长度
     *
     * @param value  需要计算的字符串长度
     * @param toast  提示语句
     * @param length 长度
     */
    public static boolean isLength(Context context, String value, int toast, int length) {
        boolean is = true;
        if (TextUtils.isEmpty(value) || value.length() <= length) {
            Toast.makeText(context, toast + "", Toast.LENGTH_SHORT).show();
            is = false;
        }
        return is;
    }


    /**
     * 当字符串没有达到规定长度时提示语句
     * 返回为true，则是达到对应长度
     *
     * @param value  需要计算的字符串长度
     * @param toast  提示语句
     * @param length 长度
     */
    public static boolean isLength(Context context, String value, String toast, int length) {
        boolean is = true;
        if (TextUtils.isEmpty(value) || value.length() <= length) {
            Toast.makeText(context, toast + "", Toast.LENGTH_SHORT).show();
            is = false;
        }
        return is;
    }

}
