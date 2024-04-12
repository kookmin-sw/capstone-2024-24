package com.kotlin.kiumee.presentation.menu

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.kiumee.databinding.ItemMenuBinding

class MenuViewHolder(
    private val binding: ItemMenuBinding,
    private val click: (MenuEntity, Int) -> Unit = { _, _ -> }
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MenuEntity) {
        with(binding) {
            data.imageUrl?.let { url ->
                Glide.with(ivItemMenu.context)
                    .load(url)
                    .centerCrop()
                    .into(ivItemMenu)
            }
            tvItemMenuName.text = data.name
            tvItemMenuPrice.text = data.price.toString() + "원"
            tvItemMenuDescription.text = data.description

            root.setOnClickListener {
                click(data, adapterPosition)
            }
        }
    }
}
