package prject.shool.src.com.shoolprject.activity;

import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.InjectView;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.interbase.LoadingMode;
import prject.shool.src.com.shoolprject.utils.ToastUtils;

/**
 * Created by Administrator on 2017/2/12.
 */
public class WebViewActivity extends BaseActivity {
    @InjectView(R.id.web_view)
    WebView webView;

    @Override
    protected void getData() {
        ToastUtils.show(this,"改变数据");
        setMode(LoadingMode.STATE_SUCCESS);
    }



    @Override
    public int getLayout() {
        return R.layout.activity_webview;
    }

    @Override
    public void initView() {
        initWeb();
        webView.loadUrl("http://www.baidu.com");

    }

    @Override
    public void initData() {

    }


    private void initWeb() {
        webView.requestFocusFromTouch();

        WebSettings webSettings = webView.getSettings();

        webView.requestFocus();
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);

        // -------------
        // webView.getSettings().setJavaScriptEnabled(true);

        // webView.getSettings().setBlockNetworkImage(false);
        // -------------
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        // 设置WebChromeClient
        WebChromeClient mWebChromeClient = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {

                    setMode(LoadingMode.STATE_EMPTY);
                } else {
                    setMode(LoadingMode.STATE_LOADING);
                }
                super.onProgressChanged(view, newProgress);
            }
        };

        try {
            webView.setWebChromeClient(mWebChromeClient);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setLoadWithOverviewMode(true);

            // ----------------
            webSettings.setBlockNetworkImage(false);//
            webSettings.setUseWideViewPort(false); // 将图片调整到适合webview的大小
            webSettings.setLoadsImagesAutomatically(true); // 支持自动加载图片
            // ------------------------------
            // webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            // webSettings.setPluginState(PluginState.ON);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                this.webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
