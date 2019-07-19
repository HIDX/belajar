package com.example.belajar2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.belajar2.Model.Data
import java.util.ArrayList

class RecycleViewAdapter : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    private var dataList: MutableList<Data> = ArrayList<Data>()
    private var listener: onViewClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecycleViewAdapter.ViewHolder, position: Int) {
        val data = dataList[position]
        holder.tvnama.setText(data.getNama())
        holder.tvharga.setText(data.getHarga())
        holder.tvjumlah.setText(data.getJumlah())
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvnama: TextView
        internal var tvharga: TextView
        internal var tvjumlah: TextView

        init {
            tvnama = itemView.findViewById(R.id.tvMainNama)
            tvharga = itemView.findViewById(R.id.tvMainHarga)
            tvjumlah = itemView.findViewById(R.id.tvMainJumlah)

            itemView.setOnClickListener { listener!!.onViewClick(adapterPosition) }
        }
    }

    fun setDataList(list: MutableList<Data>) {
        this.dataList = list
        notifyDataSetChanged()
    }

    fun clearDataList(list: MutableList<Data>) {
        this.dataList = list
        dataList.clear()
    }

    interface onViewClick {
        fun onViewClick(position: Int)
    }

    fun setOnClickListener(listener: onViewClick) {
        this.listener = listener
    }
}
