package prject.shool.src.com.shoolprject.activity.app;

import android.widget.ListView;

import java.util.List;

import butterknife.InjectView;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.activity.BaseActivity;
import prject.shool.src.com.shoolprject.adapter.TestAdapter;
import prject.shool.src.com.shoolprject.bean.DemoModel;
import prject.shool.src.com.shoolprject.interbase.LoadingMode;
import prject.shool.src.com.shoolprject.utils.DataManager;

/**
 * Created by Administrator on 2017/1/7.
 * 设置
 */
public class SettingActivity extends BaseActivity {


    @InjectView(R.id.list_view)
    ListView listView;
    private List<DemoModel> mData;



    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        setMode(LoadingMode.STATE_SUCCESS);
        mData = DataManager.loadData(getBaseContext());
        listView.setAdapter( new TestAdapter<DemoModel>(mData));
    }

    @Override
    public void initData() {

    }

    @Override
    protected void getData() {

    }


    /**
     * 一种类型的type
     */
    private TestAdapter<DemoModel> singleType(List<DemoModel> data) {
        return new TestAdapter<DemoModel>(data);
    }
}
