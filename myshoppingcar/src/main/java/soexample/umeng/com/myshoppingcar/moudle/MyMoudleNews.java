package soexample.umeng.com.myshoppingcar.moudle;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import soexample.umeng.com.myshoppingcar.bean.MyNewsData;
import soexample.umeng.com.myshoppingcar.callback.MyCallBack;
import soexample.umeng.com.myshoppingcar.okhttp.MyOkHttpUtils;

public class MyMoudleNews implements MyMoudle {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String jsons = (String) msg.obj;
            Gson gson = new Gson();
            MyNewsData myNewsData = gson.fromJson(jsons, MyNewsData.class);
            myCallBack.setData(myNewsData);
        }
    };
    private MyCallBack myCallBack;

    @Override
    public void startLogin(String url, MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        MyOkHttpUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(0, response.body()
                        .string()));
            }
        });
    }
}
