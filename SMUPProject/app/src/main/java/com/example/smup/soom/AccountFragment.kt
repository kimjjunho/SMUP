package com.example.smup.soom

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.smup.MainActivity
import com.example.smup.R
import com.example.smup.databinding.FragmentAccountBinding
import com.example.smup.databinding.FragmentFindBinding
import com.example.smup.databinding.SlidingUpPageBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class AccountFragment : Fragment() {

    var isfabOpen = false
    private var mBinding : FragmentAccountBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding =  FragmentAccountBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentAccountBinding.bind(view)
        val mainActivity = activity as MainActivity

        val mWindow = requireActivity().window
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        mWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(),R.color.purple)

        binding.sendImageBtn.setOnClickListener {
            binding.mainFrame.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            binding.slideText.text = "내가 지원한 SOOM"
        }
        binding.bookmarkImageBtn.setOnClickListener {
            binding.mainFrame.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            binding.slideText.text = "내가 가입되어 있는 SOOM"
        }

        binding.fab.setOnClickListener {
            if(isfabOpen){
                binding.fab.setImageResource(R.drawable.soom_button_account)
                ObjectAnimator.ofFloat(binding.fab1,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab2,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab3,"translationY",0f).apply { start() }
                isfabOpen = false
            }else{
                binding.fab.setImageResource(R.drawable.soom_button_close)
                ObjectAnimator.ofFloat(binding.fab1,"translationY",-200f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab2,"translationY",-400f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab3,"translationY",-600f).apply { start() }
                isfabOpen = true

            }
        }
        binding.fab1.setOnClickListener {
            mainActivity.changeFragment(1)
        }
        binding.fab2.setOnClickListener {
            mainActivity.changeFragment(3)
        }
        binding.fab3.setOnClickListener {
            mainActivity.changeFragment(2)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val mWindow = requireActivity().window
        mWindow.statusBarColor = ContextCompat.getColor(requireActivity(),R.color.white)
    }

    companion object {
    }
}