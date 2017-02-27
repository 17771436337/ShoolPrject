package prject.shool.src.com.shoolprject.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by Administrator on 2017/1/7.
 * 简单动画
 */
public class AnimationUtils {

    /**
     * 简单淡入淡出动画
     *
     * @param v           需要淡入淡出的布局
     * @param fromAlpha   起始透明度，1为不透明，0为透明
     * @param toAlpha     终止透明度，1为不透明，0为透明
     * @param time        淡入淡出的时间
     * @param repeatCount 执行次数
     */
    public static void shade(View v, float fromAlpha, float toAlpha, int time, int repeatCount) {
        Animation animation = new AlphaAnimation(fromAlpha, toAlpha);
        animation.setDuration(time);//设置动画执行时间
        animation.setFillAfter(true);//停留在执行结果的状态
        animation.setRepeatCount(repeatCount); //设置动画再重复执行的次数 注意repeatcount(x)共执行x+1次
        v.startAnimation(animation);//开始执行动画
    }

    /**
     * 初始化旋转动画 <>向上旋转</>
     */
    private void setRotateAnimationUp() {
        //向上旋转
        RotateAnimation up=new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        //动画持续的时间
        up.setDuration(300);
        up.setFillAfter(true);

    }

    /**
     * 初始化旋转动画 <>向下旋转</>
     */
    private void setRotateAnimationDown() {
        //向下旋转
        RotateAnimation down=new RotateAnimation(-180, -360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        //动画持续的时间
        down.setDuration(300);
        down.setFillAfter(true);
    }

}
