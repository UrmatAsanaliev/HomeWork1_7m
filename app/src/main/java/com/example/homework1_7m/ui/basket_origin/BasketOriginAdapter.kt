package com.example.homework1_7m.ui.basket_origin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.caps.model.Caps2
import com.example.homework1_7m.databinding.ItemCapsBinding

class BasketOriginAdapter(
    private val listener : BasketOriginAdapter.BasketOriginItemListener,
    private val brandList: ArrayList<Caps2>
) : RecyclerView.Adapter<BasketOriginAdapter.ViewHolder>() {

    interface BasketOriginItemListener {
        fun onClickedItem(id: Int)
    }


    inner class ViewHolder(
        private val listener: BasketOriginItemListener,
        private val binding: ItemCapsBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var brand: Caps2
        init {
            itemView.setOnClickListener(this)
        }
        fun onBind(brand: Caps2) {
            this.brand = brand
            Glide.with(binding.imgCaps).load(brand.image)
                .into(binding.imgCaps)
        }

        override fun onClick(p0: View?) {
            brand.id.let { listener.onClickedItem(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCapsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(brandList[position])
    }

    override fun getItemCount(): Int = brandList.size


    @SuppressLint("NotifyDataSetChanged")
    fun addData(list:  List<Caps2>) {
        brandList.clear()
        brandList.addAll(list)
        notifyDataSetChanged()
    }
}