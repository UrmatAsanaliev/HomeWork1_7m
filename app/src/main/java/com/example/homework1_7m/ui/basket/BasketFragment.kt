package com.example.homework1_7m.ui.basket

import com.example.core.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {


    override fun setupUI() {
        var a : Int = 1
        binding().minus.setOnClickListener {
            if(a >= 1 ){
                a--
                binding().quantity.text = a.toString()
            }else{
                a = 0
            }
        }
        binding().plus.setOnClickListener{
            a++
            binding().quantity.text = a.toString()
        }

    }

}