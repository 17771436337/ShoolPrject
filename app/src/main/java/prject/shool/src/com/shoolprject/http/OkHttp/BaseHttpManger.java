package prject.shool.src.com.shoolprject.http.OkHttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import prject.shool.src.com.shoolprject.App;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.bean.BaseResponse;
import prject.shool.src.com.shoolprject.utils.JsonUtil;
import prject.shool.src.com.shoolprject.utils.ToastUtils;

/**
 * Created by Administrator on 2017/1/4.
 */
public class BaseHttpManger {
    public interface BaseCallListener {
        public void onSuccess(BaseResponse pResponse);

        public void onFail(BaseResponse pResponse);
    }


    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Request.Builder builder;

    private static void connectOfStringEntity(Context context, int method, String url, Map<String, String> data,
                                              Class<? extends BaseResponse> responseClass, BaseCallListener pListener) {
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(3, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(3, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(3, TimeUnit.SECONDS);
        okHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        //okHttpClient.setCache(new Cache(CarConstant.HTTP_CACHE_DIR, CarConstant.CACHE_SIZE));
        okHttpClient.setRetryOnConnectionFailure(true);
        builder = new Request.Builder();

        isDebugUrl(url);
        Callback callback = getCallbackr(context, responseClass, pListener);
        if (isNetworkConnected(context)) {
            switch (method) {
                case 0:/** post */
                    Request request;
                    if (data == null) {
                        request = builder
                                .url(url)
                                .post(null)
                                .build();

                    } else {
                        request = builder
                                .url(url)
                                .post(buildParams(data))
                                .build();

                    }


                    okHttpClient.newCall(request);
                    break;

                case 1:    /** get */

                    break;
                case 2:    /** put **/

                    break;
                case 3:/** delete **/

                    break;
                default:
                    break;
            }


        } else {
            sendError(context.getResources().getString(R.string.error_netfail));
            if (pListener != null)
                pListener.onFail(null);
        }

    }


    /**
     * 获取返回内容
     */
    private static Callback getCallbackr(
            final Context context,
            final Class<? extends BaseResponse> responseClass,
            final BaseCallListener pListener) {

        return new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                String statusCode = e.getMessage();
                sendError(context.getResources().getString(
                        R.string.error_requestfail)
                        + "code" + statusCode);
                if (pListener != null) {
                    pListener.onFail(null);
                }
            }

            @Override
            public void onResponse(Response respons) throws IOException {
                final String jsonString = respons.body().toString();
                isDebug(jsonString);

                try {

                    BaseResponse response = JsonUtil.fromJson(jsonString, BaseResponse.class);

                    if (response != null) {
                        pListener.onSuccess(JsonUtil.fromJson(jsonString, responseClass));
                    } else {
                        pListener.onFail(null);
                    }

                } catch (Exception e) {
                    sendError(context.getResources().getString(
                            R.string.error_datafail));
                    if (pListener != null) {
                        pListener.onFail(null);
                    }
                }

            }
        };
    }

    //--------------------

    private static RequestBody buildParams(Map<String, String> params) {
        FormEncodingBuilder builder = new FormEncodingBuilder();





        RequestBody requestBody = builder.build();
        return requestBody;
    }


    /**
     * 错误信息提示
     */
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg == null)
                return;
            String tips = (String) msg.obj;
            switch (msg.what) {
                case 1:
                    if (tips != null && tips.length() > 0)
                        ToastUtils.show(App.mCurrentActivity, tips);
                    break;
                default:
                    break;
            }
        }
    };

    private static void sendError(String value) {
        Message msg = mHandler.obtainMessage();
        msg.what = 1;
        msg.obj = value;
        mHandler.sendMessage(msg);
    }


    //------------------

    /**
     * 是否联网
     */
    private static boolean isNetworkConnected(Context context) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }
        return false;
    }
    //--------Log网络请求----------

    public static void isDebug(String json) {
        Log.e("网络请求返回的json", json + "");
    }

    public boolean isOk(String json) throws JSONException {

        int status = new JSONObject(json).getInt("c");
        String msg = new JSONObject(json).getString("m");
        if (0 == status) {
            Toast.makeText(App.mCurrentActivity, msg, Toast.LENGTH_SHORT);
            return false;
        } else {
            return true;
        }
    }

    public static void isDebugUrl(String url) {
        Log.e("url地址：", "url地址：" + url);
    }

    public static void isDebug(Map<String, String> params) {
        Log.e("params：", "params：" + new Gson().toJson(params));
    }
}
