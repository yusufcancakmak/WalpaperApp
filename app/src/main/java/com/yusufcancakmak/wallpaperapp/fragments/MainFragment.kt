package com.yusufcancakmak.wallpaperapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.yusufcancakmak.wallpaperapp.R
import com.yusufcancakmak.wallpaperapp.databinding.FragmentMainBinding
import com.yusufcancakmak.wallpaperapp.fragments.adapter.ViewPagerAdapter

class MainFragment : Fragment() {

    private val tabTitles= listOf("Home","Popular","Random","Categories")
    private val fragments = listOf(HomeFragment(),PopularFragment(),RandomFragment(),CategoriesFragment())
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(layoutInflater,container,false)
        initViewPager()
        initTablayout()
        initToolBar()

        return binding.root
    }

    private fun initTablayout(){
        TabLayoutMediator(binding.tabLayout,binding.viewPaper){tab,position->
            tab.text=tabTitles[position]
        }.attach()
    }
    private fun initViewPager(){
    val pagerAdapter = ViewPagerAdapter(context as FragmentActivity,fragments)
        binding.viewPaper.adapter =pagerAdapter
        binding.viewPaper.isUserInputEnabled=false
    }
    private fun initToolBar(){
        binding.toolbar.title="Walpapers"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

}