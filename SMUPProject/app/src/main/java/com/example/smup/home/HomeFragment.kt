package com.example.smup.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.databinding.FragmentHomeBinding
import com.example.smup.databinding.FragmentMyPageBinding

class HomeFragment : Fragment() {

    private var mBinding : FragmentHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentHomeBinding.bind(view)

        binding.radioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.schedule_btn->{

                }
                R.id.meal_btn->{

                }
            }
        }

        return view
    }

    companion object {

    }
}