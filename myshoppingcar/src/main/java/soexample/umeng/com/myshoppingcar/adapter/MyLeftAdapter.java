package soexample.umeng.com.myshoppingcar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.R;
import soexample.umeng.com.myshoppingcar.bean.MyFoodData;

public class MyLeftAdapter extends RecyclerView.Adapter<MyLeftAdapter.ViewHolder> {
    private ArrayList<MyFoodData.DataBean> datas;
    private Context context;
    private View inflate;

    public MyLeftAdapter(ArrayList<MyFoodData.DataBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        inflate = LayoutInflater.from(context).inflate(R.layout.group_list, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(datas.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemOnClick != null) {
                    itemOnClick.onItemOnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.Group_Name);
        }
    }

    private ItemOnClick itemOnClick;

    public interface ItemOnClick {
        void onItemOnClick(int position);
    }

    public void setItemOnClick(ItemOnClick item) {
        this.itemOnClick = item;
    }
}
