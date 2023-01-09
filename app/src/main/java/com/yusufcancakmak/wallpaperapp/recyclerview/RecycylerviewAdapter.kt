package com.yusufcancakmak.wallpaperapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.yusufcancakmak.wallpaperapp.R
import com.yusufcancakmak.wallpaperapp.databinding.ItemRecyclerviewBinding
import com.yusufcancakmak.wallpaperapp.fragments.MainFragmentDirections
import com.yusufcancakmak.wallpaperapp.models.Data
import com.yusufcancakmak.wallpaperapp.utils.BlurHashDecoder
import com.yusufcancakmak.wallpaperapp.utils.Constants

class RecycylerviewAdapter(private val navigationId:Int?):PagingDataAdapter<Data,RecycylerviewAdapter.MyViewHolder> (DiffUtilCallBack()){
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding=ItemRecyclerviewBinding.bind(view)

        fun bind(data: Data){
            val blurHashAsDrawable =BlurHashDecoder.blurHashBitmap(itemView.resources,data)
            Glide.with(itemView.context)
                .asBitmap()
                .load(data.smallImageUrl)
                .centerCrop()
                .transition(BitmapTransitionOptions.withCrossFade(80))
                .error(blurHashAsDrawable)
                .placeholder(blurHashAsDrawable)
                .into(binding.imageview)

            itemView.setOnClickListener { v->
                val imageData= arrayOf(data.fullImageUrl.toString(),data.blurHash.toString())
                when(navigationId){
                    Constants.NavigationIntent.FromHomeToDownload->{
                        Navigation.findNavController(v)
                            .navigate(
                                MainFragmentDirections.actionMainFragmentToDowloandFragment(imageData)
                            )

                    }
                }

            }
        }



    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)
        return MyViewHolder(inflater)
    }
    class DiffUtilCallBack :DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.blurHash==newItem.blurHash
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
           return oldItem==newItem
        }

    }
}