package soexample.umeng.com.myshoppingcar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import soexample.umeng.com.myshoppingcar.R;

public class ZiDingYiView extends LinearLayout implements View.OnClickListener {
    private TextView delete_tv;
    private TextView product_number_tv;
    private TextView add_tv;
    private int myCount;

    public ZiDingYiView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.add_remove_view, this);
        initView();
    }

    private void initView() {
        delete_tv = findViewById(R.id.delete_tv);
        product_number_tv = findViewById(R.id.product_number_tv);
        add_tv = findViewById(R.id.add_tv);

        delete_tv.setOnClickListener(this);
        add_tv.setOnClickListener(this);
    }

    public void setNumber(int number) {
        this.myCount = number;
        product_number_tv.setText(number + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_tv:
                if (myCount >= 1) {
                    myCount--;
                    product_number_tv.setText(myCount + "");
                    if (achange != null) {
                        achange.setCount(myCount);
                    }
                } else {
                    Toast.makeText(getContext(), "商品数量为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.add_tv:
                myCount++;
                Toast.makeText(getContext(), myCount + "", Toast.LENGTH_SHORT).show();
                product_number_tv.setText(myCount + "");
                if (achange != null) {
                    achange.setCount(myCount);
                }

                break;
        }
    }

    public interface onCountChange {
        void setCount(int count);
    }

    private onCountChange achange;

    public void setOnChange(onCountChange onChange) {
        this.achange = onChange;
    }

}
