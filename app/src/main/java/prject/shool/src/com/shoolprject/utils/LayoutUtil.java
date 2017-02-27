package prject.shool.src.com.shoolprject.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Kale
 * @date 2016/3/16
 */
public class LayoutUtil {

    public static void setContentView(Activity activity, View view) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        activity.setContentView(view);
    }

    public static View getLayoutInflater(Context context, int id){
        return LayoutInflater.from(context).inflate(id,null);
    }
    
}
