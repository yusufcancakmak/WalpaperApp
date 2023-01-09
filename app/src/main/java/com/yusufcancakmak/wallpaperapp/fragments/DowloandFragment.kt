package com.yusufcancakmak.wallpaperapp.fragments

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.yusufcancakmak.wallpaperapp.databinding.FragmentDowloandBinding
import com.yusufcancakmak.wallpaperapp.utils.BlurHashDecoder

class DowloandFragment : Fragment() {
    private lateinit var binding:FragmentDowloandBinding
    private val args:DowloandFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDowloandBinding.inflate(inflater,container,false)

        loadImage(args.imageData[0])
        addCallBack()
        return binding.root
    }
    private fun loadImage(url:String){
        val blurHash=BlurHashDecoder.decode(args.imageData[1])
        Glide.with(this)
            .load(url)
            .centerCrop()
            .placeholder(blurHash!!.toDrawable(this.resources))
            .error(blurHash)
            .into(binding.dowloandImage)

        binding.constraintBackground.background = BitmapDrawable(this.resources,blurHash)

    }
    private fun addCallBack(){
        binding.backbutton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}