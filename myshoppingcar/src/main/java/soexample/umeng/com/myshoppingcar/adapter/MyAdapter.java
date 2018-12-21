package soexample.umeng.com.myshoppingcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import soexample.umeng.com.myshoppingcar.R;
import soexample.umeng.com.myshoppingcar.bean.MyLoginGridData;

public class MyAdapter extends BaseAdapter {
    private ArrayList<MyLoginGridData.ResultsBean> datas;
    private Context context;

    public MyAdapter(ArrayList<MyLoginGridData.ResultsBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public ArrayList<MyLoginGridData.ResultsBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<MyLoginGridData.ResultsBean> datas) {
        this.datas = datas;
        //刷新适配器
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.linitem, null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.My_Img);
            holder.tv = convertView.findViewById(R.id.My_Title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(datas.get(position).getType());
        Glide.with(context).load(datas.get(position).getUrl()).into(holder.img);

        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView tv;
    }


}
