package com.ceniza.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var inputEditText: EditText
    private lateinit var addButton: Button
    private lateinit var adapter: CustomAdapter
    private var itemList: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)


        listView = view.findViewById(R.id.itemListView)
        inputEditText = view.findViewById(R.id.inputEditText)
        addButton = view.findViewById(R.id.addButton)


        adapter = CustomAdapter(requireContext(), itemList)
        listView.adapter = adapter


        addButton.setOnClickListener {
            addItem()
        }

        return view
    }

    private fun addItem() {
        val newItem = inputEditText.text.toString().trim()
        if (newItem.isNotEmpty()) {
            itemList.add(newItem)
            adapter.notifyDataSetChanged()
            inputEditText.setText("")
        }
    }
}
