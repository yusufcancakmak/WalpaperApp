package com.yusufcancakmak.wallpaperapp.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yusufcancakmak.wallpaperapp.databinding.FragmentRandomBinding
import com.yusufcancakmak.wallpaperapp.fragments.base.BaseFragment
import com.yusufcancakmak.wallpaperapp.recyclerview.RecycylerviewAdapter
import com.yusufcancakmak.wallpaperapp.utils.Constants
import com.yusufcancakmak.wallpaperapp.viewmodel.RandomViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RandomFragment : BaseFragment<FragmentRandomBinding>(FragmentRandomBinding::inflate) {
    private val viewmodel:RandomViewModel by viewModels()
    override fun initviewModel() {
        lifecycleScope.launch {
            viewmodel.randompage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context,3)
        binding.randomRecyclerview.layoutManager=layoutManager
        binding.randomRecyclerview.adapter=recyclerViewAdapter


    }
    override var recyclerViewAdapter: RecycylerviewAdapter
            = RecycylerviewAdapter(Constants.NavigationIntent.FromHomeToDownload)


}