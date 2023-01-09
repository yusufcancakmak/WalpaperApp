package com.yusufcancakmak.wallpaperapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.yusufcancakmak.wallpaperapp.databinding.FragmentCategoriesBinding
import com.yusufcancakmak.wallpaperapp.recyclerview.CategoryAdapter
import com.yusufcancakmak.wallpaperapp.utils.APICategory


class CategoriesFragment :Fragment() {
    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var recyclerViewAdapter:CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoriesBinding.inflate(inflater,container,false)
        initRecyclerViewAdapter()
        return binding.root
    }
    private fun initRecyclerViewAdapter(){
        val layoutManager=GridLayoutManager(context,2)
        recyclerViewAdapter= CategoryAdapter(APICategory.list)
        binding.categoriesRecyclerview.layoutManager=layoutManager
        binding.categoriesRecyclerview.adapter=recyclerViewAdapter


    }



}
