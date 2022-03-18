package com.example.smup.ui.mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.smup.R
import com.example.smup.databinding.FragmentMyPageBinding
import com.example.smup.ui.MainActivity
import com.example.smup.ui.login.LoginActivity

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

        binding.userImage.setOnClickListener { startActivity(Intent(mainActivity, UserActivity::class.java)) }
        binding.userBtn.setOnClickListener { startActivity(Intent(mainActivity, UserActivity::class.java)) }

        binding.ringImage.setOnClickListener { startActivity(Intent(mainActivity, RingActivity::class.java)) }
        binding.ringBtn.setOnClickListener { startActivity(Intent(mainActivity, RingActivity::class.java)) }

        binding.schoolImage.setOnClickListener { startActivity(Intent(mainActivity, SchoolActivity::class.java)) }
        binding.schoolBtn.setOnClickListener { startActivity(Intent(mainActivity, SchoolActivity::class.java)) }

        binding.outImage.setOnClickListener {
            startActivity(Intent(mainActivity, LoginActivity::class.java))
            mainActivity.logout()
        }
        binding.outBtn.setOnClickListener {
            startActivity(Intent(mainActivity, LoginActivity::class.java))
            mainActivity.logout()
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