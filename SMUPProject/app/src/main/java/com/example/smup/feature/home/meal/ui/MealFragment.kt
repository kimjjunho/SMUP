package com.example.smup.feature.home.meal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.databinding.FragmentMealBinding
import com.example.smup.feature.home.meal.viewmodel.MealViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MealFragment : Fragment() {
    val TAG = "MealFragment"

    private lateinit var dBinding : FragmentMealBinding
    private val binding get() = dBinding
    val vm : MealViewModel by viewModel()

    var click = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dBinding = FragmentMealBinding.inflate(inflater, container, false)
        val view = binding.root

        //vm.getTodayMeal()

        dBinding.rightImage.setOnClickListener {
            vm.addData()
            //vm.getMeal(date.toString())
        }
        dBinding.leftIamge.setOnClickListener {
            vm.minusData()
            //vm.getMeal(date.toString())
        }

        observeEvent()

        return view
    }

    companion object {

    }

    fun observeEvent(){
        activity?.let {
            vm.breakfast.observe(it,{
                it.run{
                    dBinding.firstTV.text = it
                }
            })
            vm.lunch.observe(it,{
                it.run {
                    dBinding.secondTV.text = it
                }
            })
            vm.dinner.observe(it,{
                it.run {
                    dBinding.thirdTv.text = it
                }
            })
            vm.day.observe(it,{
                it.run{
                    dBinding.dayText.text = it+"요일"
                }
            })
            vm.date.observe(it,{
                it.run {
                    dBinding.dateText.text = it
                }
            })
        }

    }

}