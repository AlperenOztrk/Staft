package com.wiuma.staft.ui.containers

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.wiuma.staft.R
import com.wiuma.staft.databinding.ComponentEmptyViewBinding

class EmptyView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private var binding: ComponentEmptyViewBinding =
        ComponentEmptyViewBinding.inflate(LayoutInflater.from(context), this, true)

    public fun setView(resID: Int) {
        binding.label.text = getCompleteSentence(resID)
    }

    private fun getCompleteSentence(resID: Int): String {
        return context.getString(R.string.emptyView).replace("RRRR", context.getString(resID))
    }
}


