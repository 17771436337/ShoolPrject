package prject.shool.src.com.shoolprject.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import prject.shool.src.com.shoolprject.App;
import prject.shool.src.com.shoolprject.R;

/**
 * Created by Administrator on 2016/12/22.
 * 页面跳转 <为设置动画/>
 */
public class PageJumpsUtils {
    /**
     * 设置意图
     */
    public static void JumpActivity(Activity context, Intent intent) {
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    /**
     * Activity设置意图转 ,可返回
     */
    public static void JumpActivity(Activity context, Intent intent, int requestCode) {
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


    /**
     * Activity不带参数得页面跳转
     */
    public static void JumpActivity(Activity context, Class activity) {
        Intent it = new Intent(context, activity);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


    /**
     * Activity携带参数得页面跳转
     */
    public static void JumpActivity(Activity context, Class activity, Bundle bundle) {
        Intent it = new Intent(context, activity);
        it.putExtras(bundle);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    /**
     * Activity不带参数得页面跳转 ,可返回
     */
    public static void JumpActivity(Activity context, Class activity, int requestCode) {
        Intent it = new Intent(context, activity);
        context.startActivityForResult(it, requestCode);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    /**
     * Activity携带参数得页面跳转  ,可返回
     */
    public static void JumpActivity(Activity context, Class activity, Bundle bundle, int requestCode) {
        Intent it = new Intent(context, activity);
        it.putExtras(bundle);
        context.startActivityForResult(it, requestCode);
        context.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);

    }

    /**
     * Fragment不带参数得页面跳转
     */
    public static void JumpFragment(Context context, Class activity) {
        Intent it = new Intent(context, activity);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
        App.mCurrentActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


    /**
     * Fragment携带参数得页面跳转
     */
    public static void JumpFragment(Context context, Class activity, Bundle bundle) {
        Intent it = new Intent(context, activity);
        it.putExtras(bundle);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
        App.mCurrentActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    /**
     * Fragment不带参数得页面跳转 ,可返回
     */
    public static void JumpFragment(Context context, Class activity, int requestCode) {
        Intent it = new Intent(context, activity);
        App.mCurrentActivity.startActivityForResult(it, requestCode);
    }

    /**
     * Fragment携带参数得页面跳转  ,可返回
     */
    public static void JumpFragment(Context context, Class activity, Bundle bundle, int requestCode) {
        Intent it = new Intent(context, activity);
        it.putExtras(bundle);
        App.mCurrentActivity.startActivityForResult(it, requestCode);
        App.mCurrentActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


    /**
     * 界面销毁
     */
    public static void finish(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
