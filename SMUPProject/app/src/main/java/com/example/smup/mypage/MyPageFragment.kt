package com.example.smup.mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.smup.MainActivity
import com.example.smup.R
import com.example.smup.databinding.FragmentFindBinding
import com.example.smup.databinding.FragmentMyPageBinding
import com.example.smup.soom.FindFragment

class MyPageFragment : Fragment() {

    private var mBinding : FragmentMyPageBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentMyPageBinding.inflate(inflater, container,false)
        val view = binding.root
        val binding = FragmentMyPageBinding.bind(view)
        val mainActivity = activity as MainActivity

        binding.userImage.setOnClickListener {
            startActivity(Intent(mainActivity, UserActivity::class.java))
        }
        binding.ringImage.setOnClickListener {
            startActivity(Intent(mainActivity, RingActivity::class.java))
        }
        binding.schoolImage.setOnClickListener {
            startActivity(Intent(mainActivity, SchoolActivity::class.java))
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val mWindow = requireActivity().window
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(),R.color.purple)
    }
    override fun onDestroy() {
        super.onDestroy()
        val mWindow = requireActivity().window
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(),R.color.white)
    }

    companion object {

    }
}