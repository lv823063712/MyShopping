package soexample.umeng.com.myshoppingcar;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.adapter.MyLeftAdapter;
import soexample.umeng.com.myshoppingcar.adapter.MyRightAdapter;
import soexample.umeng.com.myshoppingcar.base.BaseActivity;
import soexample.umeng.com.myshoppingcar.bean.MyFoodData;
import soexample.umeng.com.myshoppingcar.ipersenter.IPersenterFoodImpl;
import soexample.umeng.com.myshoppingcar.iview.IView;

public class Main3Activity<T> extends BaseActivity implements IView<T> {

    private TextView All_Price;
    private TextView Go_To_Js;
    private XRecyclerView My_Recy;
    private XRecyclerView My_XRecy;
    private MyLeftAdapter adapter;
    private ArrayList<MyFoodData.DataBean> datas = new ArrayList<>();
    private IPersenterFoodImpl iPersenterFood;
    private String mUrl = "http://www.wanandroid.com/tools/mockapi/6523/restaurant-list";
    private ArrayList<MyFoodData.DataBean.SpusBean> lists = new ArrayList<>();
    private MyRightAdapter myRightAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main3;
    }

    @Override
    protected void initViews() {
        All_Price = findViewById(R.id.All_Price);
        Go_To_Js = findViewById(R.id.Go_To_Js);
        My_Recy = findViewById(R.id.My_Recy);
        My_XRecy = findViewById(R.id.My_XRecy);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        My_Recy.setLayoutManager(manager);
        My_XRecy.setLayoutManager(manager1);
        adapter = new MyLeftAdapter(datas, this);
        myRightAdapter = new MyRightAdapter(lists, this);
        My_Recy.setAdapter(adapter);
        My_XRecy.setAdapter(myRightAdapter);
    }

    @Override
    protected void setOnClick() {
    }

    @Override
    protected void proLogic() {
        iPersenterFood = new IPersenterFoodImpl(this);
        iPersenterFood.startRequest(mUrl);
        iPersenterFood.startRequest(mUrl);
        adapter.setItemOnClick(new MyLeftAdapter.ItemOnClick() {
            @Override
            public void onItemOnClick(int position) {
                lists.clear();
                lists.addAll(datas.get(position).getSpus());
                myRightAdapter.notifyDataSetChanged();

            }
        });
        myRightAdapter.setItemOnClick(new MyRightAdapter.ItemOnClick() {
            @Override
            public void flush() {
                All_Price.setText("价格" + myRightAdapter.getGoodsPrice());
                Go_To_Js.setText("去结算(" + myRightAdapter.getGoodsNumber() + ")");
            }
        });

    }

    @Override
    public void setData(T data) {
        MyFoodData myFoodData = (MyFoodData) data;
        datas.addAll(myFoodData.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setError(T error) {

    }

}
