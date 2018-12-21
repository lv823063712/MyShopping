package soexample.umeng.com.myshoppingcar;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.GridView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.adapter.MyAdapter;
import soexample.umeng.com.myshoppingcar.adapter.MyNewsAdapter;
import soexample.umeng.com.myshoppingcar.base.BaseActivity;
import soexample.umeng.com.myshoppingcar.bean.MyLoginGridData;
import soexample.umeng.com.myshoppingcar.bean.MyNewsData;
import soexample.umeng.com.myshoppingcar.ipersenter.IPersenter;
import soexample.umeng.com.myshoppingcar.ipersenter.IPersenterImpl;
import soexample.umeng.com.myshoppingcar.ipersenter.IPersenterNewsImpl;
import soexample.umeng.com.myshoppingcar.iview.IView;
import soexample.umeng.com.myshoppingcar.iview.IViewNews;

public class MainActivity<T> extends BaseActivity implements IView<T>, IViewNews {

    private XRecyclerView MyXRecy;
    private GridView MyGV;
    private ArrayList<MyLoginGridData.ResultsBean> datas = new ArrayList<>();
    private ArrayList<MyNewsData.DataBean> lists = new ArrayList<>();
    private String mUrl = "https://gank.io/api/data/福利/10/1";
    private String myUrl = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private IPersenterImpl iPersenter;
    private MyAdapter myAdapter;
    private MyNewsAdapter myNewsAdapter;
    private IPersenterNewsImpl iPersenterNews;
    ;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        MyGV = findViewById(R.id.MyGV);
        MyXRecy = findViewById(R.id.MyXRecy);
        myAdapter = new MyAdapter(datas, this);
        MyGV.setAdapter(myAdapter);
        //设定现实的布局
        LinearLayoutManager manager = new LinearLayoutManager(this);
        MyXRecy.setLayoutManager(manager);
        myNewsAdapter = new MyNewsAdapter(lists);
        MyXRecy.setAdapter(myNewsAdapter);
    }

    @Override
    protected void setOnClick() {

    }

    @Override
    protected void proLogic() {
        iPersenter = new IPersenterImpl(this);
        iPersenterNews = new IPersenterNewsImpl(this);
        iPersenter.startRequest(mUrl);
        iPersenterNews.startRequest(myUrl);
    }

    @Override
    public void setData(T data) {
        MyLoginGridData myLoginGridData = (MyLoginGridData) data;
        datas.addAll(myLoginGridData.getResults());
        //刷新适配器
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError(T error) {

    }

    @Override
    public void setNewsData(Object data) {
        MyNewsData myNewsData = (MyNewsData) data;
        lists.addAll(myNewsData.getData());
        //刷新适配器去
        myNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public void setNewsError(Object error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iPersenter != null) {
            iPersenter.onDatacth();
        }
    }


}
