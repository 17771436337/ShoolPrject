package prject.shool.src.com.shoolprject.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * JSON解析
 */
public class JsonUtil {
    private JsonUtil() {
    }

    private static Gson gson = null;

    private static synchronized Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * 将JSON字符串转换为指定类型对象
     *
     * @param json
     * @param typeOfT
     * @return
     * @throws JsonSyntaxException json语法错误
     */
    public static <T> T fromJson(String json, Type typeOfT)
            throws JsonSyntaxException {
        T t = null;
        try {
            t = getGsonInstance().fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d("JsonUtil", "typeOfT : " + typeOfT.getClass());
            LogUtil.d("JsonUtil", "转换时发生异常!" + "源字符串:\n" + json);
        }
        return t;
    }

    /**
     *      * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的 {@code JavaBean} 对象。</strong>
     *      *
     *      * @param <T> 要转换的目标类型。
     *      * @param json 给定的 {@code JSON} 字符串。
     *      * @param clazz 要转换的目标类。
     *      * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     *      * @since 1.0
     *      
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGsonInstance().fromJson(json, clazz);
    }


    /**
     * 将对象转换为JSON字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return getGsonInstance().toJson(obj);
    }

}