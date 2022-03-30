package com.example.smup.feature.home.schedule.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.smup.databinding.FragmentMealBinding
import com.example.smup.databinding.FragmentScheduleBinding
import com.example.smup.feature.home.meal.viewmodel.MealViewModel
import com.example.smup.feature.home.schedule.viewmodel.ScheduleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class ScheduleFragment : Fragment() {
    val TAG = "ScheduleFragment"

    private var progressBar: ProgressBar? = null
    private lateinit var dBinding : FragmentScheduleBinding
    private val binding get() = dBinding
    val vm : ScheduleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dBinding = FragmentScheduleBinding.inflate(inflater,container,false)
        val view = binding.root
        val binding = FragmentScheduleBinding.bind(view)

        vm.schedule()
        vm.setTime()

        observeEvent()

        return view
    }



    fun observeEvent(){
        activity?.let {
            vm.progressTotal.observe(it,{
                it.run {
                    progressBar = binding.circleProgressbar
                    progressBar!!.progress = it.toInt()
                }
            })
            vm.rotaionTotal.observe(it,{
                it.run {
                    progressBar = binding.circleProgressbar
                    progressBar!!.rotation = it.toFloat()
                }
            })
            vm.timeTotal.observe(it,{
                it.run{
                    dBinding.tvRealTime.text = it
                }
            })
        }
    }

    companion object {

    }
}