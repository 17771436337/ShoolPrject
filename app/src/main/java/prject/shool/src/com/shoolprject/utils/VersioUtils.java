package prject.shool.src.com.shoolprject.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.telephony.TelephonyManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import prject.shool.src.com.shoolprject.App;
import prject.shool.src.com.shoolprject.R;

/**
 * Created by Administrator on 2016/12/22.
 * 获取版本相关信息
 */
public class VersioUtils {

    /**
     * 下载安装包的名字
     */
    static String m_appNameStr = R.string.app_name + ".apk";
    static Handler m_mainHandler;
    static ProgressDialog m_progressDlg;

    // 以下是获得版本信息的工具方法
    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }


    /**
     * 得到设备 的唯一标识符
     *
     * @return
     */
    public static String getSzimei(Context mContext) {
        String szimei;
        try {
            szimei = ((TelephonyManager) mContext.getSystemService(mContext.TELEPHONY_SERVICE)).getDeviceId();
        } catch (Exception e) {
            return "";
        }

        return szimei;
    }


    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }

    //---------------------------------------------

    /**
     * 通过Url链接下载更新包
     */
    private static void doNewVersionUpdate(String url) {
        if (m_mainHandler == null)
            m_mainHandler = new Handler();
        if (m_progressDlg == null)
            m_progressDlg = new ProgressDialog(App.mCurrentActivity);
        m_progressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        m_progressDlg.setIndeterminate(false);
        m_progressDlg.setCancelable(false);

        m_progressDlg.setTitle("正在下载");
        m_progressDlg.setMessage("请稍候...");
        downFile(url); // 开始下载
    }


    private static void downFile(final String url) {
        m_progressDlg.show();
        new Thread() {
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(url);
                HttpResponse response;
                try {
                    response = client.execute(get);
                    HttpEntity entity = response.getEntity();
                    long length = entity.getContentLength();

                    m_progressDlg.setMax((int) length);// 设置进度条的最大值

                    InputStream is = entity.getContent();
                    FileOutputStream fileOutputStream = null;
                    if (is != null) {
                        File file = new File(
                                Environment.getExternalStorageDirectory(),
                                m_appNameStr);
                        fileOutputStream = new FileOutputStream(file);
                        byte[] buf = new byte[1024];
                        int ch = -1;
                        int count = 0;
                        while ((ch = is.read(buf)) != -1) {
                            fileOutputStream.write(buf, 0, ch);
                            count += ch;
                            if (length > 0) {
                                m_progressDlg.setProgress(count);
                            }
                        }
                    }
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    down();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    private static void down() {
        m_mainHandler.post(new Runnable() {
            public void run() {
                m_progressDlg.cancel();
                update();
            }
        });
    }


    /**
     * 安装
     */
    static void update() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(Environment
                        .getExternalStorageDirectory(), m_appNameStr)),
                "application/vnd.android.package-archive");

        PageJumpsUtils.JumpActivity(App.mCurrentActivity, intent);
    }
}
