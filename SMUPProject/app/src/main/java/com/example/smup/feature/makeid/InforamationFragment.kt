package com.example.smup.feature.makeid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.databinding.FragmentInforamationBinding

class InforamationFragment : Fragment() {

    private var mBinding : FragmentInforamationBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentInforamationBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentInforamationBinding.bind(view)

        binding.btn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.frame, EmailFragment())
                addToBackStack(null)
                commit()
            }
        }

        return view
    }

    companion object {

    }
}