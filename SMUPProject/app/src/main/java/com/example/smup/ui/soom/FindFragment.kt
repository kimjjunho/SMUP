package com.example.smup.ui.soom

import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.databinding.FragmentFindBinding
import com.example.smup.ui.MainActivity

class FindFragment : Fragment() {

    var isfabOpen = false
    private var mBinding : FragmentFindBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentFindBinding.inflate(inflater,container,false)
        val view = binding.root
        val binding = FragmentFindBinding.bind(view)
        val mainActivity = activity as MainActivity

        binding.searchText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.searchText.text.isEmpty()){
                    binding.searchLine.setBackgroundColor(mainActivity.getColor(R.color.gray))
                    binding.cancelBtn.visibility = View.INVISIBLE
                    binding.searchBtn.setImageResource(R.drawable.soom_search_gray)
                }else{
                    binding.searchLine.setBackgroundColor(mainActivity.getColor(R.color.black))
                    binding.cancelBtn.visibility = View.VISIBLE
                    binding.searchBtn.setImageResource(R.drawable.soom_search_black)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.searchBtn.setOnClickListener {
            binding.allCancelBtn.visibility = View.VISIBLE
        }
        binding.allCancelBtn.setOnClickListener {
            binding.allCancelBtn.visibility = View.INVISIBLE
            binding.searchText.text = null
        }
        binding.cancelBtn.setOnClickListener {
            binding.searchText.text = null
        }

        binding.web.setOnClickListener {
            textColor(mainActivity)
            binding.webText.setTextColor(mainActivity.getColor(R.color.red))
        }
        binding.app.setOnClickListener {
            textColor(mainActivity)
            binding.appText.setTextColor(mainActivity.getColor(R.color.yellow))
        }
        binding.back.setOnClickListener {
            textColor(mainActivity)
            binding.backText.setTextColor(mainActivity.getColor(R.color.blue))
        }

        binding.fab.setOnClickListener {
            if(isfabOpen){
                binding.fab.setImageResource(R.drawable.soom_button_search)
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
        mBinding!!.fab1.setOnClickListener {
            mainActivity.changeFragment(1)
        }
        binding.fab2.setOnClickListener {
            mainActivity.changeFragment(3)
        }
        binding.fab3.setOnClickListener {
            mainActivity.changeFragment(4)
        }
        binding.fab4.setOnClickListener {
            mainActivity.changeFragment(5)
        }

        return view
    }

    fun textColor(mainActivity: MainActivity){
        binding.appText.setTextColor(mainActivity.getColor(R.color.white))
        binding.webText.setTextColor(mainActivity.getColor(R.color.white))
        binding.backText.setTextColor(mainActivity.getColor(R.color.white))
    }

    companion object {

    }
}