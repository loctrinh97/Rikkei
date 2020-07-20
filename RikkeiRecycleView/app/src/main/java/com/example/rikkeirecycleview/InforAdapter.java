package com.example.rikkeirecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class InforAdapter extends
        RecyclerView.Adapter<InforAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public TextView tvInfor;

        public ViewHolder(View itemView) {

            super(itemView);
            imgView =  itemView.findViewById(R.id.imgView);
            tvInfor = itemView.findViewById(R.id.tvInfor);
        }
    }


    private ArrayList<Infor> mInfor;
    private Context mContext;

    public InforAdapter(ArrayList<Infor> mInfor, Context mContext) {
        this.mInfor = mInfor;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View inforView = inflater.inflate(R.layout.custom_raw, parent, false);
        ViewHolder viewHolder = new ViewHolder(inforView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Infor infor = mInfor.get(position);
        Glide.with(mContext).load(infor.getImg()).into(holder.imgView);
        holder.tvInfor.setText(infor.getName());
    }

    @Override
    public int getItemCount() {
        return mInfor.size();
    }





}
