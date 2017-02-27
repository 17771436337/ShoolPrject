package prject.shool.src.com.shoolprject.libView.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

/**
 * Created by Administrator on 2017/2/12.
 */
public class RefreshWebView extends WebView{

    SwipeToLoadLayout swipeToLoadLayout;
    public RefreshWebView(Context context) {
        super(context);

    }

    public RefreshWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
