package com.zhuimeng.baseadapertest;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 追梦 on 2017/5/1.
 **/

public class AdapterThree extends BaseAdapter {

    private LayoutInflater layoutInflater;

    /**
     * 数据源与数据适配器关联
     */
    private List<NewsBean> newsBeanList;
    public AdapterThree(Context context, List<NewsBean> list) {
        newsBeanList = list;
        //context要使用当前的Adapter的界面对象layoutInflate布局装载器对象
        layoutInflater = LayoutInflater.from(context);
    }


    /**
     * 返回ListView需要显示的数据数量（适配器数据集中的数据个数）
     * @return
     */
    @Override
    public int getCount() {
        return newsBeanList.size();
    }

    /**
     * 返回索引项数据（item）（获取数据集中与指定索引对应的数据项）
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return newsBeanList.get(position);
    }

    /**
     * 返回指定索引对应的数据项（获取指定行对应的ID）
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 返回每一项的显示内容（获取每一个Item的显示内容）
     *
     * 不仅利用了ListView的缓存机制，更通过了ViewHolder类来实现显示数据的视图的缓存
     * 避免多次通过findViewById寻找控件
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取系统纳秒时间
        long start = System.nanoTime();

        ViewHolder viewHolder;
        if (convertView ==  null){//为空：View未被实例化，缓存池无缓存
            viewHolder = new ViewHolder();
                                              //R.layout.item,需要装载到item中的布局文件
            convertView = layoutInflater.inflate(R.layout.item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);

            //通过setTag将ViewHolder与covertView绑定
            convertView.setTag(viewHolder);
        } else {
            //通过ViewHolder对象找到对应的控件
            viewHolder = (ViewHolder) convertView.getTag();
        }

                                    //getItem(int position):返回索引项数据（item）
        viewHolder.imageView.setImageResource(newsBeanList.get(position).itemImageID);
        viewHolder.title.setText(newsBeanList.get(position).title);
        viewHolder.content.setText(newsBeanList.get(position).content);

        long end = System.nanoTime();//获取系统纳秒时间
        long dValue = end - start;
        Log.e("TAG", "文艺模式运行时间为（纳秒）：" + dValue);

        return convertView;
    }

    /**
     * 创建内部类ViewHoler
     */
    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
