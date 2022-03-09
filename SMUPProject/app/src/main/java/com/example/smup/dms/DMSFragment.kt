package com.example.smup.dms

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.MainActivity
import com.example.smup.R

class DMSFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainActivity  = activity as MainActivity
        val dialog = Dialog(mainActivity)
        dialog.setContentView(R.layout.dialog_dms)
        dialog.show()

        return inflater.inflate(R.layout.fragment_d_m_s, container, false)
    }

    companion object {
    }
}