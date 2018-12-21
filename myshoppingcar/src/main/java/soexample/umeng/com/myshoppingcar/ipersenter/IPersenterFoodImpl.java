package soexample.umeng.com.myshoppingcar.ipersenter;

import soexample.umeng.com.myshoppingcar.callback.MyCallBack;
import soexample.umeng.com.myshoppingcar.iview.IView;
import soexample.umeng.com.myshoppingcar.moudle.MyMoudleFood;

public class IPersenterFoodImpl implements IPersenter {
    private IView iView;
    private MyMoudleFood myMoudleFood;

    public IPersenterFoodImpl(IView iView) {
        this.iView = iView;
        myMoudleFood = new MyMoudleFood();
    }

    @Override
    public void startRequest(String url) {
        myMoudleFood.startLogin(url, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.setData(data);
            }

            @Override
            public void setError(Object error) {
                iView.setError(error);
            }
        });
    }

    //防止内存泄漏
    public void onDatacth() {
        if (myMoudleFood != null) {
            myMoudleFood = null;
        }
        if (iView != null) {
            iView = null;
        }
    }
}
