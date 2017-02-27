package prject.shool.src.com.shoolprject.holder;


import android.widget.TextView;

import butterknife.InjectView;
import prject.shool.src.com.shoolprject.R;
import prject.shool.src.com.shoolprject.bean.DemoModel;


/**
 * @author Jack Tony
 * @date 2015/5/15
 */
public class TextItem extends BaseHolder<DemoModel>{

    @InjectView(R.id.textView)
    TextView textView;

    @Override
    public int getLayoutResId() {
        return R.layout.demo_item_text;
    }
//    @Override
//    public void bindViews(View root) {
//        textView = (TextView) root.findViewById(R.id.textView);
//    }

    @Override
    protected void initView() {

    }

//    @Override
//    public void setViews() {
//        //Log.d(TextItem.class.getSimpleName(), "setViews--------->");
//    }

    @Override
    public void handleData(DemoModel model, int position) {
        textView.setText(model.content + " pos=" + position);
    }

}

