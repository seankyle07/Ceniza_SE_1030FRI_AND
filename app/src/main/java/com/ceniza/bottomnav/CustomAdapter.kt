package com.ceniza.bottomnav

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private val context: Context, private val itemList: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val checkBox: CheckBox = view.findViewById(R.id.itemCheckBox)
        val imageView: ImageView = view.findViewById(R.id.itemImageView)
        val textView: TextView = view.findViewById(R.id.itemTextView)


        textView.text = itemList[position]

        return view
    }
}
