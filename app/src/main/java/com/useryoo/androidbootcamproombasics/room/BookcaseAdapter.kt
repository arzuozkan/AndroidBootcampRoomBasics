package com.useryoo.androidbootcamproombasics.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.useryoo.androidbootcamproombasics.databinding.ItemCardBinding

class BookcaseAdapter(private var listBook:List<BookModel?>)
    :RecyclerView.Adapter<BookcaseAdapter.ItemCardDesign>() {

        class ItemCardDesign(val itemCardBinding: ItemCardBinding)
            :RecyclerView.ViewHolder(itemCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardDesign {
        val layoutInflater=LayoutInflater.from(parent.context)
        val itemCardBinding=ItemCardBinding.inflate(layoutInflater,parent,false)
        return ItemCardDesign(itemCardBinding)
    }

    override fun onBindViewHolder(holder: ItemCardDesign, position: Int) {
        val book=listBook[position]

        holder.itemCardBinding.apply {
            if(book!=null){
                bookNameText.text=book.bookName
                authorText.text=book.author

            }
        }

    }

    override fun getItemCount()=listBook.size
}