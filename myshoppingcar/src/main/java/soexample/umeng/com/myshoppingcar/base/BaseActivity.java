package soexample.umeng.com.myshoppingcar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected abstract int getLayout();

    protected abstract void initViews();

    protected abstract void setOnClick();

    protected abstract void proLogic();

    void init() {
        if (getLayout() != 0) {
            setContentView(getLayout());
            initViews();
            setOnClick();
            proLogic();
        }
    }

}
