package com.example.smup.feature.home.meal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.data.home.MealRepository
import com.example.smup.databinding.FragmentMealBinding
import com.example.smup.feature.MainActivity
import com.example.smup.feature.home.meal.viewmodel.MealViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealFragment : Fragment() {

    private lateinit var dBinding : FragmentMealBinding
    private val binding get() = dBinding
    val vm : MealViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dBinding = FragmentMealBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentMealBinding.bind(view)

        observeEvent()

        return view
    }

    companion object {

    }

    fun observeEvent(){
        val view = binding.root
        val binding = FragmentMealBinding.bind(view)

        activity?.let {
            vm.breakfast.observe(it,{
                it.run{
                    binding.firstTV.text = it
                }
            })
            vm.lunch.observe(it,{
                it.run {
                    binding.secondTV.text = it
                }
            })
            vm.dinner.observe(it,{
                it.run {
                    binding.thirdTv.text = it
                }
            })
        }

    }
}