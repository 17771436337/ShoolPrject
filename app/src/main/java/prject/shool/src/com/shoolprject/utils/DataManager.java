package prject.shool.src.com.shoolprject.utils;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.bean.DemoModel;

/**
 * @author Jack Tony
 * @date 2015/9/19
 */
public class DataManager {

    public static List<DemoModel> loadData(Context context) {
        return loadData(context, 200);
    }

    /**
     * 模拟加载数据的操作
     */
    public static List<DemoModel> loadData(Context context, int num) {
        List<String> originList = Arrays.asList(context.getResources().getStringArray(R.array.country_names));
        List<DemoModel> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int type = (int) (Math.random() * 3);
            DemoModel model = new DemoModel();
            switch (type) {
                case 0:
                    model.type = "text";
                    model.content = originList.get(i);
                    break;
                case 1:
                    model.type = "button";
                    model.content = originList.get(i);
                    break;
                case 2:
                    model.type = "image";
                    model.content = String.valueOf(R.drawable.kale);
                    break;
                default:
            }
            list.add(model);
        }

        for (int i = 0; i < list.size(); i++) {
            Log.d("DataManager", "[" + i + "]" + list.get(i).content);
        }
        return list;
    }
}