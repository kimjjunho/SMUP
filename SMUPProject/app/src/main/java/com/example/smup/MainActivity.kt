package com.example.smup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.smup.dms.DMSFragment
import com.example.smup.home.HomeFragment
import com.example.smup.mypage.MyPageFragment
import com.example.smup.mypage.UserActivity
import com.example.smup.soom.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById<View> (R.id.main_bottom_navigation) as BottomNavigationView
        bottomNavigationView!!.setOnNavigationItemSelectedListener(this)
        bottomNavigationView!!.selectedItemId = R.id.menu_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_home ->{
                val homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, homeFragment)
                    .commit()
                return true
            }
            R.id.menu_dms->{
                val dmsFragment = DMSFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, dmsFragment)
                    .commit()
                return true
            }
            R.id.menu_soom->{
                val soomFragment = SOOMFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, soomFragment)
                    .commit()
                return true
            }
            R.id.menu_mypage ->{
                val mypageFragment = MyPageFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, mypageFragment)
                    .commit()
                return true
            }
        }
        return false
    }
    fun changeFragment(index:Int){
        when(index){
            1 -> supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, SOOMFragment())
                .commit()
            2 -> supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, FindFragment())
                .commit()
            3 -> supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, ChatFragment())
                .commit()
            4 -> supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, AccountFragment())
                .commit()
            5 -> startActivity(Intent(applicationContext, MakeSoomActivity::class.java))
        }
    }
}