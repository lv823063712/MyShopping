package soexample.umeng.com.myshoppingcar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.R;
import soexample.umeng.com.myshoppingcar.bean.MyFoodData;
import soexample.umeng.com.myshoppingcar.view.ZiDingYiView;

public class MyRightAdapter extends RecyclerView.Adapter<MyRightAdapter.ViewHolder> {
    private ArrayList<MyFoodData.DataBean.SpusBean> datas;
    private Context context;
    private View inflate;

    public MyRightAdapter(ArrayList<MyFoodData.DataBean.SpusBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        inflate = LayoutInflater.from(context).inflate(R.layout.childe_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(datas.get(i).getName() + "");
        viewHolder.price.setText(datas.get(i).getSkus().get(0).getPrice() + "");
        viewHolder.zidingyi.setNumber(datas.get(i).getPraise_num());
        Glide.with(context).load(datas.get(i).getPic_url()).into(viewHolder.img);

        viewHolder.zidingyi.setOnChange(new ZiDingYiView.onCountChange() {
            @Override
            public void setCount(int count) {
                datas.get(i).setPraise_num(count);
                notifyDataSetChanged();
                itemOnClick.flush();
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView img;
        private TextView price;
        private ZiDingYiView zidingyi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.Child_Icon);
            tv = itemView.findViewById(R.id.Child_title);
            price = itemView.findViewById(R.id.Child_price);
            zidingyi = itemView.findViewById(R.id.JiaJianView);

        }
    }
    //计算总数量
    public float getGoodsNumber() {
        float number = 0;
        for (int i = 0; i < datas.size(); i++) {
            number += datas.get(i).getPraise_num();
        }
        return number;
    }

    ///计算总价格
    public float getGoodsPrice() {
        float price = 0;
        for (int i = 0; i < datas.size(); i++) {
            price += datas.get(i).getPraise_num() * Float.valueOf(datas.get(i).getSkus().get(0).getPrice());
        }
        return price;
    }

    private ItemOnClick itemOnClick;

    public interface ItemOnClick {
        void flush();
    }

    public void setItemOnClick(ItemOnClick item) {
        this.itemOnClick = item;
    }
}
