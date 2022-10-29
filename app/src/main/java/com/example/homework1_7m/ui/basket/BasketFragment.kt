package com.example.homework1_7m.ui.basket

import androidx.navigation.fragment.findNavController
import com.example.core.core.BaseFragment
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {

    private val sum = 2700
    private var summ = 0

    override fun setupUI() {

        binding().imgCross.setOnClickListener {
            findNavController().navigateUp()
        }

        binding().imgCap.setImageResource(R.drawable.img3)

        binding().txtName.text = "NewEra"
        binding().txtTitle.text = R.string.Golden_State.toString()
        binding().txtPrice.text = sum.toString()
        binding().txtSize.text = "M"
        binding().txtDeliverySum.text = "250 сом"
        binding().img.setImageResource(R.drawable.img3)

        var a : Int = 1
        binding().minus.setOnClickListener {
            if(a >= 1 ){
                a--
                binding().quantity.text = a.toString()
                summ = a * sum
                binding().txtGeneralSum.text = summ.toString()
            }else{
                a = 0
            }
        }
        binding().plus.setOnClickListener{
            a++
            binding().quantity.text = a.toString()
            summ = a * sum
            binding().txtGeneralSum.text = summ.toString()
        }

    }

}