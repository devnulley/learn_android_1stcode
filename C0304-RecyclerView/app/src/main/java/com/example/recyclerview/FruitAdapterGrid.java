package com.example.recyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapterGrid extends RecyclerView.Adapter<FruitAdapterGrid.ViewHolder>{
    private List<Fruit> mFruitList;

    // 构造函数用于获取传入数据fruitList
    public FruitAdapterGrid(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    // 找到当前View对应的控件ID，并实例化
    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitText;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.image_fruit);
            fruitText = (TextView) itemView.findViewById(R.id.text_fruit);
        }
    }

    // 设置View的布局文件，并返回holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_fruit_item_grid, parent, false);

        // 设置点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Snackbar.make(view , fruit.getName()
                        , Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

        return holder;
    }

    // 动态绑定控件的数据，根据position
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitText.setText(fruit.getName());
    }

    // 返回列表FruitList长度
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
