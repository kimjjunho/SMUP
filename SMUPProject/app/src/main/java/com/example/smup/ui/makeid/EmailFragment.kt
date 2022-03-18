package com.example.smup.ui.makeid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.databinding.FragmentEmailBinding
import com.example.smup.databinding.FragmentInforamationBinding

class EmailFragment : Fragment() {

    private var mBinding : FragmentEmailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentEmailBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentEmailBinding.bind(view)

        binding.btn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.frame, CitationFragment())
                addToBackStack(null)
                commit()
            }
        }

        return view
    }

    companion object {

    }
}