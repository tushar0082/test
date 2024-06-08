package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CoinAdapter(private val coinList: List<DataItem>) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)

        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = coinList[position]

        holder.coinName.text = "Name: "+item.name
        holder.coinPrice.text ="Price: " +(item.priceUsd?.toFloat()?.times(89)).toString()
        holder.changeRate.text = "Rate Change: "+item.changePercent24Hr
    }

    class CoinViewHolder(itemView: View) : ViewHolder(itemView) {

        val coinName: TextView = itemView.findViewById(R.id.coinName)
        val coinPrice: TextView = itemView.findViewById(R.id.coinPrice)
        val changeRate: TextView = itemView.findViewById(R.id.changePercent)
    }

}

