package soexample.umeng.com.myshoppingcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.Main3Activity;
import soexample.umeng.com.myshoppingcar.R;
import soexample.umeng.com.myshoppingcar.bean.MyNewsData;

public class MyNewsAdapter extends RecyclerView.Adapter<MyNewsAdapter.ViewHolder> {
    private ArrayList<MyNewsData.DataBean> datas;
    private Context context;
    private View inflate;

    public MyNewsAdapter(ArrayList<MyNewsData.DataBean> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        inflate = LayoutInflater.from(context).inflate(R.layout.linear_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tip.setText(datas.get(i).getNews_summary());
        viewHolder.title.setText(datas.get(i).getNews_title());
        Glide.with(context).load(datas.get(i).getPic_url()).into(viewHolder.img);

        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main3Activity.class);
                context.startActivity(intent);
            }
        });
        viewHolder.tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main3Activity.class);
                context.startActivity(intent);
            }
        });
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main3Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final TextView tip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.My_GoodsImg);
            title = itemView.findViewById(R.id.My_GoodsTitle);
            tip = itemView.findViewById(R.id.My_GoodsTip);

        }
    }
}
