package com.yusufcancakmak.wallpaperapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufcancakmak.wallpaperapp.R
import com.yusufcancakmak.wallpaperapp.databinding.CategoryItemRowBinding
import com.yusufcancakmak.wallpaperapp.models.Category



class CategoryAdapter(private val categoryList: List<Category>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> (){
   inner class CategoryViewHolder(view:View):RecyclerView.ViewHolder(view){
       val binding=CategoryItemRowBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.category_item_row,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory=categoryList[position]
        holder.binding.apply {
            categoryName.text=currentCategory.categoryName
            Glide.with(holder.itemView.context)
                .load(currentCategory.imageUrl)
                .centerCrop()
                .error(R.color.teal_200)
                .into(categoryImageview)
        }
    }

    override fun getItemCount()=categoryList.size
}