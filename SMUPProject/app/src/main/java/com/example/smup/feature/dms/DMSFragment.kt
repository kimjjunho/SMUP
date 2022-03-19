package com.example.smup.feature.dms

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.smup.feature.MainActivity
import com.example.smup.R

class DMSFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val mainActivity  = activity as MainActivity
        val dialog = Dialog(mainActivity)
        dialog.setContentView(R.layout.dialog_dms)
        dialog.setCancelable(false)
        dialog.show()

        val btn : Button = dialog.findViewById(R.id.btn)
        btn.setOnClickListener {
            mainActivity.goHome()
            dialog.dismiss()
        }

        return inflater.inflate(R.layout.fragment_d_m_s, container, false)
    }

    companion object {
    }
}