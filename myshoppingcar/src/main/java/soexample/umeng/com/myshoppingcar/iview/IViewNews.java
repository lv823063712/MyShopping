package soexample.umeng.com.myshoppingcar.iview;

public interface IViewNews<T> {

    void setNewsData(T data);

    void setNewsError(T error);
}
