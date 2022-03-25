package com.example.mynote

import android.view.View
import android.widget.TextView
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder

class NoteAdapterItem(
    private val note: String
): AdapterItem<NoteViewHolder>() {

    override val layoutId: Int = R.layout.item_note

    override fun onCreateViewHolder(view: View) = NoteViewHolder(view)

    override fun updateItemViews(viewHolder: NoteViewHolder) {
        viewHolder.noteTextView.text = note
    }

    override fun isTheSame(newItem: AdapterItem<*>): Boolean {
        return newItem is NoteAdapterItem && newItem.note == note
    }

    override fun isContentsTheSame(newItem: AdapterItem<*>): Boolean {
        return isTheSame(newItem)
    }

}

class NoteViewHolder(view: View): BaseViewHolder(view) {
    val noteTextView: TextView = view.findViewById(R.id.note_text_view)

}