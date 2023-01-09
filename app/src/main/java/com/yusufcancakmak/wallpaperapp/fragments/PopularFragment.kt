package com.yusufcancakmak.wallpaperapp.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.yusufcancakmak.wallpaperapp.databinding.FragmentPopularBinding
import com.yusufcancakmak.wallpaperapp.fragments.base.BaseFragment
import com.yusufcancakmak.wallpaperapp.recyclerview.RecycylerviewAdapter
import com.yusufcancakmak.wallpaperapp.utils.Constants
import com.yusufcancakmak.wallpaperapp.viewmodel.PopularViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::inflate) {
    private val viewmodel:PopularViewModel by viewModels()
    override fun initviewModel() {
        lifecycleScope.launch {
            viewmodel.popularpage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context,3)
        binding.recyclerviewPopular.layoutManager=layoutManager
        binding.recyclerviewPopular.adapter=recyclerViewAdapter
    }
    override var recyclerViewAdapter: RecycylerviewAdapter
            = RecycylerviewAdapter(Constants.NavigationIntent.FromHomeToDownload)

}