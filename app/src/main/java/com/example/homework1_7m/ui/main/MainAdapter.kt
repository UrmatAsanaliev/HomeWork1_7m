package com.example.homework1_7m.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.brand.model.Brand
import com.example.homework1_7m.databinding.ItemBestsellersBinding

class MainAdapter(
    private val listener : BrandItemListener,
    private val brandList: ArrayList<Brand>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface BrandItemListener {
        fun onClickedItem(id: Int)
    }


    inner class ViewHolder(
        private val listener: BrandItemListener,
        private val binding: ItemBestsellersBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var brand: Brand
        init {
            itemView.setOnClickListener(this)
        }
        fun onBind(brand: Brand) {
            this.brand = brand
            Glide.with(binding.rvItemForBestsellers.imgModel).load(brand.image)
            .into(binding.rvItemForBestsellers.imgModel)
        }

        override fun onClick(p0: View?) {
            brand.id.let { listener.onClickedItem(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBestsellersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(brandList[position])
    }

    override fun getItemCount(): Int = brandList.size


    @SuppressLint("NotifyDataSetChanged")
    fun addData(list:  List<Brand>) {
        brandList.addAll(list)
        notifyDataSetChanged()
    }
}