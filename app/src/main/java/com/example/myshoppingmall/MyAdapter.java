package com.example.myshoppingmall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myshoppingmall.Iteminfo;
import com.example.myshoppingmall.R;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView content;
        TextView price;

        MyViewHolder(View view){
            super(view);

            image = view.findViewById(R.id.image);
            name=view.findViewById(R.id.name);
            content=view.findViewById(R.id.content);
            price = view.findViewById(R.id.price);

        }
    }

    private ArrayList<Iteminfo> IteminfoArrayList;
    MyAdapter(ArrayList<Iteminfo> IteminfoArrayList){
        this.IteminfoArrayList = IteminfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.image.setImageResource(IteminfoArrayList.get(position).image);
        myViewHolder.name.setText(IteminfoArrayList.get(position).name);
        myViewHolder.content.setText(IteminfoArrayList.get(position).content);
        myViewHolder.price.setText(IteminfoArrayList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return IteminfoArrayList.size();
    }
}

