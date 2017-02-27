package prject.shool.src.com.shoolprject.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import prject.shool.src.com.shoolprject.App;

/**
 * Created by Administrator on 2017/1/4.
 * 系统相关应用
 */
public class SystemUtils {
    /**
     * 判断包是否安装
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            manager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);

            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * 安装应用程序
     *
     * @param context
     * @param apkFile
     */
    public static void installApp(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 打开应用程序
     *
     * @param context
     * @param packageName
     */
    public static void openApp(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(intent);
    }


    /**
     * 退出App
     */
    public static void exitApp() {
        ListIterator<Activity> iterator = App.getActivities().listIterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            next.finish();
        }
    }


    /**
     * 重新启动
     */
    private void restartApplication() {
        final Intent intent = App.mCurrentActivity.getPackageManager().getLaunchIntentForPackage(App.mCurrentActivity.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PageJumpsUtils.JumpActivity(App.mCurrentActivity, intent);
    }


    /**
     * 判断某个界面是否在前台
     *
     * @param context
     * @param className 某个界面名称
     */
    public static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }

        return false;
    }

    /*
     * 是否手机号 原值为："^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$"
     * 最新手机号码正则表达式：^(0|86|
     * 17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$
     * 修改于20150831
     */
    public static boolean isPhoneNumber(String phone_num) {
        Pattern p = Pattern
                .compile("^(0|86)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = p.matcher(phone_num);
        if (!m.matches()) {
            return false;
        }

        return true;
    }
}
