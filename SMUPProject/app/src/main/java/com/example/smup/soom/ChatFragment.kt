package com.example.smup.soom

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.databinding.FragmentChatBinding
import com.example.smup.databinding.FragmentFindBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatFragment : Fragment() {

    var isfabOpen = false
    private var mBinding : FragmentChatBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentChatBinding.inflate(inflater,container,false)
        val view = binding.root
        val binding = FragmentChatBinding.bind(view)
        val soomActivity = activity as SoomActivity

        binding.fab.setOnClickListener {
            if(isfabOpen){
                binding.fab.setImageResource(R.drawable.soom_button_chat)
                ObjectAnimator.ofFloat(binding.fab1,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab2,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab3,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab4,"translationY",0f).apply { start() }
                isfabOpen = false
            }else{
                binding.fab.setImageResource(R.drawable.soom_button_close)
                ObjectAnimator.ofFloat(binding.fab1,"translationY",-200f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab2,"translationY",-400f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab3,"translationY",-600f).apply { start() }
                ObjectAnimator.ofFloat(binding.fab4,"translationY",-800f).apply { start() }
                isfabOpen = true

            }
        }
        binding.fab1.setOnClickListener {
           soomActivity.changeFragment(1)
        }
        binding.fab2.setOnClickListener {
            soomActivity.changeFragment(2)
        }
        binding.fab3.setOnClickListener {
            soomActivity.changeFragment(4)
        }
        binding.fab4.setOnClickListener {
            soomActivity.changeFragment(5)
        }

        return view
    }

    companion object {

    }
}