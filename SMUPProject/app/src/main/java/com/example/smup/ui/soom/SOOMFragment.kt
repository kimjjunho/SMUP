package com.example.smup.ui.soom

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.R
import com.example.smup.ui.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SOOMFragment : Fragment() {

    var isfabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView : View =  inflater.inflate(R.layout.fragment_main, container, false)
        val mainActivity = activity as MainActivity
        val fab : FloatingActionButton = rootView.findViewById(R.id.fab)
        val fab1 : FloatingActionButton = rootView.findViewById(R.id.fab1)
        val fab2 : FloatingActionButton = rootView.findViewById(R.id.fab2)
        val fab3 : FloatingActionButton = rootView.findViewById(R.id.fab3)
        val fab4 : FloatingActionButton = rootView.findViewById(R.id.fab4)


        fab.setOnClickListener {
            if(isfabOpen){
                fab.setImageResource(R.drawable.soom_button_main)
                ObjectAnimator.ofFloat(fab1,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(fab2,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(fab3,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(fab4,"translationY",0f).apply { start() }
                isfabOpen = false
            }else{
                fab.setImageResource(R.drawable.soom_button_close)
                ObjectAnimator.ofFloat(fab1,"translationY",-200f).apply { start() }
                ObjectAnimator.ofFloat(fab2,"translationY",-400f).apply { start() }
                ObjectAnimator.ofFloat(fab3,"translationY",-600f).apply { start() }
                ObjectAnimator.ofFloat(fab4,"translationY",-800f).apply { start() }
                isfabOpen = true

            }
        }
        fab1.setOnClickListener {
            mainActivity.changeFragment(2)
        }
        fab2.setOnClickListener {
            mainActivity.changeFragment(3)
        }
        fab3.setOnClickListener {
            mainActivity.changeFragment(4)
        }
        fab4.setOnClickListener {
            mainActivity.changeFragment(5)
        }

        return rootView
    }



    companion object {

    }
}