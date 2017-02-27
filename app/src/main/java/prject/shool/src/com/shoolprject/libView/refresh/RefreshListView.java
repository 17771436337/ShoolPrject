package prject.shool.src.com.shoolprject.libView.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.interbase.Refresh;
import prject.shool.src.com.shoolprject.interbase.RefreshMode;
import prject.shool.src.com.shoolprject.utils.LayoutUtil;

/**
 * Created by Administrator on 2017/2/12.
 */
public class RefreshListView extends FrameLayout implements OnRefreshListener, OnLoadMoreListener {
    private Context context;

    /**
     * 初始布局
     */
    private View view;

    SwipeToLoadLayout swipeToLoadLayout;
    ListView listView;


    View pullBottom;

    private int refresh;

    public RefreshListView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.refresh);
//        refresh = typedArray.getIndex(R.attr.refresh);

        init();
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.refresh);
        init();
    }


    /**
     * 初始化布局
     */
    private void init() {
        view = LayoutUtil.getLayoutInflater(context, R.layout.pull_list_view);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout,view);
        listView = (ListView) findViewById(R.id.swipe_target,view);
        pullBottom = findViewById(R.id.swipe_load_more_footer,view);
        this.addView(view);

    }

    /**
     * 初始化
     */
    protected View findViewById(int id, View view) {
        return view.findViewById(id);
    }


    /**
     * 绑定适配器
     */
    public void setAdapter(ListAdapter adapter) {
        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }

    public void setMode(RefreshMode refreshMode) {
        switch (refreshMode) {
            case All:
                swipeToLoadLayout.setOnRefreshListener(this);
                swipeToLoadLayout.setOnLoadMoreListener(this);
                break;
            case Down:
                swipeToLoadLayout.setOnLoadMoreListener(this);
                break;
            case Up:
                swipeToLoadLayout.setOnRefreshListener(this);
//                swipeToLoadLayout.setLoadingMore(true);
                swipeToLoadLayout.setRefreshing(false);
                break;

        }

//        swipeToLoadLayout.setOnRefreshListener(refreshListener);
//        swipeToLoadLayout.setOnLoadMoreListener(loadMoreListener);
    }

    /**
     * 视图的点击事件
     */
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        listView.setOnItemClickListener(listener);
    }

    Refresh refreshListener;

    /**
     * 上拉刷新
     */
    public void setRefreshUp(Refresh refreshListener) {
        this.refreshListener = refreshListener;
    }


    public void setRefreshDown(Refresh loadMoreListener) {
        this.refreshListener = loadMoreListener;
    }


    @Override
    public void onRefresh() {
        refreshListener.refreshUp();
        swipeToLoadLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
        refreshListener.refreshDown();
        swipeToLoadLayout.setLoadingMore(false);

    }
}
