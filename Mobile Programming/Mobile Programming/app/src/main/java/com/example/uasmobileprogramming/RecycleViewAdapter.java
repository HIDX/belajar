package com.example.uasmobileprogramming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasmobileprogramming.model.Data;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Data> dataList = new ArrayList<>();
    private onViewClick listener;

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.tvnama.setText(data.getNama());
        holder.tvharga.setText(data.getHarga());
        holder.tvjumlah.setText(data.getJumlah());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvnama, tvharga, tvjumlah;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvnama = itemView.findViewById(R.id.tvMainNama);
            tvharga = itemView.findViewById(R.id.tvMainHarga);
            tvjumlah = itemView.findViewById(R.id.tvMainJumlah);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onViewClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(List<Data> list ){
        this.dataList = list;
        notifyDataSetChanged();
    }

    public void clearDataList(List<Data> list ){
        this.dataList = list;
        dataList.clear();
    }

    public interface onViewClick{
        void onViewClick(int position);
    }

    public void setOnClickListener(onViewClick listener){
        this.listener = listener;
    }
}
