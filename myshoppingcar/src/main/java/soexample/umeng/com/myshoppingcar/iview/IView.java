package soexample.umeng.com.myshoppingcar.iview;

public interface IView<T> {

    //成功回调
    void setData(T data);

    //失败回调
    void setError(T error);

}
