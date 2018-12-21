package soexample.umeng.com.myshoppingcar.okhttp;

import android.view.View;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyOkHttpUtils {

    private OkHttpClient okHttpClient;

    private MyOkHttpUtils() {
        this.okHttpClient = new OkHttpClient();
    }

    public static MyOkHttpUtils getInstance() {
        return ViewHolder.myOkHttpUtils;
    }

    static class ViewHolder {
        private static final MyOkHttpUtils myOkHttpUtils = new MyOkHttpUtils();
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
