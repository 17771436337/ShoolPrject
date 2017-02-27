package prject.shool.src.com.shoolprject.activity;

import android.widget.RelativeLayout;

import java.util.List;

import butterknife.InjectView;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.adapter.TestAdapter;
import prject.shool.src.com.shoolprject.bean.DemoModel;
import prject.shool.src.com.shoolprject.interbase.LoadingMode;
import prject.shool.src.com.shoolprject.interbase.Refresh;
import prject.shool.src.com.shoolprject.interbase.RefreshMode;
import prject.shool.src.com.shoolprject.libView.refresh.RefreshListView;
import prject.shool.src.com.shoolprject.utils.DataManager;
import prject.shool.src.com.shoolprject.utils.ToastUtils;

/**
 * Created by Administrator on 2017/2/12.
 */
public class TextActivity extends BaseActivity implements Refresh {

    @InjectView(R.id.test)
    RelativeLayout test;

    RefreshListView refreshListView;

    @Override
    protected void getData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_text;
    }

    @Override
    public void initView() {

        refreshListView = new RefreshListView(this);
        List<DemoModel> mData = DataManager.loadData(getBaseContext());
        refreshListView.setAdapter( new TestAdapter<DemoModel>(mData));
        test.addView(refreshListView);
        refreshListView.setMode(RefreshMode.Up);
        refreshListView.setRefreshUp(this);
        setMode(LoadingMode.STATE_SUCCESS);


    }

    @Override
    public void initData() {

    }


    @Override
    public void refreshDown() {
        ToastUtils.show(this, "asdasda");

    }

    @Override
    public void refreshUp() {
        ToastUtils.show(this, "asdasda");
    }
}
