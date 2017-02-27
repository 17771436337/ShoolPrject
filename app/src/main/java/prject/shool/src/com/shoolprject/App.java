package prject.shool.src.com.shoolprject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.lqr.imagepicker.ImagePicker;
import com.lqr.imagepicker.view.CropImageView;

import java.util.ArrayList;
import java.util.List;

import prject.shool.src.com.shoolprject.utils.UILImageLoader;

/**
 * Created by Administrator on 2016/12/22.
 */
public class App extends Application {

    /**
     * 为真则打印log日志
     */
    public static boolean isDebug = true;

    //----------------
    private static App app;

    /**
     * 单例
     */
    public static App getInstance() {
        if (null == app) {
            app = new App();
        }
        return app;
    }

    //---------------------------

    private static Context context;

    /**
     * 上下文参数
     */
    public static Context getContext() {
        return context;
    }


    //------------------------------
    /**
     * 当前Activity
     */
    public static Activity mCurrentActivity;


    /**
     * 对所有的activity进行管理*
     */
    private static List<Activity> activities = new ArrayList<Activity>();

    public static List<Activity> getActivities() {
        return activities;
    }


    //----------------------

    @Override
    public void onCreate() {
        super.onCreate();
        initImagePicker();
    }

    //----------------------

    /**
     * 初始化仿微信控件ImagePicker
     */
    private void initImagePicker() {
        ImagePicker  imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new UILImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setMultiMode(false);//是否多选
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素

    }

    //-------------------设置字体不随系统变化而变化------------------
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        if (newConfig.fontScale != -1) {//非默认值
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public Resources getResources() {
        // TODO Auto-generated method stub
        Resources resources = super.getResources();
        if (resources.getConfiguration().fontScale != -1) {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();//设置默认值
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }
    //-----------------------------------


}
