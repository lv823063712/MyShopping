package soexample.umeng.com.myshoppingcar.ipersenter;

import soexample.umeng.com.myshoppingcar.callback.MyCallBack;
import soexample.umeng.com.myshoppingcar.iview.IViewNews;
import soexample.umeng.com.myshoppingcar.moudle.MyMoudleNews;

public class IPersenterNewsImpl implements IPersenter {
    private IViewNews iViewNews;
    private MyMoudleNews myMoudleNews;

    public IPersenterNewsImpl(IViewNews iViewNews) {
        this.iViewNews = iViewNews;
        myMoudleNews = new MyMoudleNews();
    }

    @Override
    public void startRequest(String url) {
        myMoudleNews.startLogin(url, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iViewNews.setNewsData(data);
            }

            @Override
            public void setError(Object error) {
                iViewNews.setNewsError(error);
            }
        });
    }

    //防止内存泄漏
    public void onDatacth() {
        if (myMoudleNews != null) {
            myMoudleNews = null;
        }
        if (iViewNews != null) {
            iViewNews = null;
        }
    }

}
