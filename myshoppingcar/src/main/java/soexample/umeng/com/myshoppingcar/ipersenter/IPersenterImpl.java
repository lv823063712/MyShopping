package soexample.umeng.com.myshoppingcar.ipersenter;

import soexample.umeng.com.myshoppingcar.callback.MyCallBack;
import soexample.umeng.com.myshoppingcar.iview.IView;
import soexample.umeng.com.myshoppingcar.moudle.MyMoudleImpl;

public class IPersenterImpl implements IPersenter {
    private IView miView;
    private MyMoudleImpl myMoudle;

    public IPersenterImpl(IView iView) {
        this.miView = iView;
        myMoudle = new MyMoudleImpl();
    }

    @Override
    public void startRequest(String url) {
        myMoudle.startLogin(url, new MyCallBack() {
            @Override
            public void setData(Object data) {
                miView.setData(data);
            }

            @Override
            public void setError(Object error) {
                miView.setError(error);
            }
        });
    }

    //防止内存泄漏
    public void onDatacth() {
        if (myMoudle != null) {
            myMoudle = null;
        }
        if (miView != null) {
            miView = null;
        }
    }

}
