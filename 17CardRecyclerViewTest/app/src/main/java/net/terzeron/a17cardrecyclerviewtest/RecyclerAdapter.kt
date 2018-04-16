package net.terzeron.a17cardrecyclerviewtedt

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter Five")
    private val details = arrayOf("Item One Details", "Item Two Details", "Item Three Details", "Item Four Details", "Item Five Details")
    private val images = intArrayOf(R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3, R.drawable.android_image_4, R.drawable.android_image_5)
    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup?.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder?, i: Int) {
        viewHolder?.itemTitle?.text = titles[i]
        viewHolder?.itemDetail?.text = details[i]
        viewHolder?.itemImage?.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    }
}