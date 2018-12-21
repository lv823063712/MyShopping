package soexample.umeng.com.myshoppingcar.callback;

public interface MyCallBack<T> {
    void setData(T data);

    void setError(T error);
}
