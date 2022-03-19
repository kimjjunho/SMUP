package com.example.smup.feature.makeid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.databinding.FragmentSchoolInfoBinding

class SchoolInfoFragment : Fragment() {

    private var mBinding : FragmentSchoolInfoBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSchoolInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentSchoolInfoBinding.bind(view)
        val activity = activity as MakeIdActivity

        binding.btn.setOnClickListener {
            activity.move()
        }

        return view
    }

    companion object {

    }
}