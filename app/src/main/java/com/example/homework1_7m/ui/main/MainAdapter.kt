package com.example.homework1_7m.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.brand.model.Brand
import com.example.domain.caps.model.Caps
import com.example.domain.caps.model.Caps2
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.ItemBestsellersBinding

class MainAdapter(
    private val listener : BrandItemListener,
    private val brandList: ArrayList<Caps2>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface BrandItemListener {
        fun onClickedItem(id: Int)
    }


    inner class ViewHolder(
        private val listener: BrandItemListener,
        private val binding: ItemBestsellersBinding
    ) : RecyclerView.ViewHolder(binding.root), OnClickListener {
        private lateinit var brand: Caps2
        init {
            itemView.setOnClickListener(this)
        }
        fun onBind(brand: Caps2) {
            this.brand = brand
            binding.rvItemForBestsellers.txtPriceModel.text = brand.price.toString()
            binding.rvItemForBestsellers.txtDescModel.text = brand.description
            binding.rvItemForBestsellers.txtNameModel.text = brand.name
            Glide.with(binding.rvItemForBestsellers.imgModel).load(brand.image)
            .into(binding.rvItemForBestsellers.imgModel)

            binding.rvItemForBestsellers.imgLike.setOnClickListener {
                if (binding.rvItemForBestsellers.imgLike.visibility == VISIBLE) {
                    binding.rvItemForBestsellers.imgLike.visibility = GONE
                    binding.rvItemForBestsellers.imgYellowLike.visibility = VISIBLE
                }
            }

            binding.rvItemForBestsellers.imgYellowLike.setOnClickListener {
                if (binding.rvItemForBestsellers.imgYellowLike.visibility == VISIBLE) {
                    binding.rvItemForBestsellers.imgLike.visibility = VISIBLE
                    binding.rvItemForBestsellers.imgYellowLike.visibility = GONE
                }
            }
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
    fun addData(list:  List<Caps2>) {
        brandList.clear()
        brandList.addAll(list)
        notifyDataSetChanged()
    }
}