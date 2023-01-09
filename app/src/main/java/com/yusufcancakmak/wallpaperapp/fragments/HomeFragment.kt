package com.yusufcancakmak.wallpaperapp.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yusufcancakmak.wallpaperapp.databinding.FragmentHomeBinding
import com.yusufcancakmak.wallpaperapp.fragments.base.BaseFragment
import com.yusufcancakmak.wallpaperapp.recyclerview.RecycylerviewAdapter
import com.yusufcancakmak.wallpaperapp.utils.Constants
import com.yusufcancakmak.wallpaperapp.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewmodel:HomeViewModel by viewModels()

    override fun initviewModel() {
        lifecycleScope.launch {
            viewmodel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context,3)
        binding.homerecylerview.layoutManager=layoutManager
        binding.homerecylerview.adapter=recyclerViewAdapter

    }

    override var recyclerViewAdapter: RecycylerviewAdapter
       = RecycylerviewAdapter(Constants.NavigationIntent.FromHomeToDownload)


}