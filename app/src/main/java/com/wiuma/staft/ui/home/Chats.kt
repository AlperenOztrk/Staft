package com.wiuma.staft.ui.home

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.wiuma.staft.MainActivity
import com.wiuma.staft.databinding.ComponentChatsBinding

class Chats(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: ComponentChatsBinding =
        ComponentChatsBinding.inflate(LayoutInflater.from(context), this, true)

    public fun setView(activity: MainActivity) {
        activity.db.collection("users")
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w("TAG", "Listen failed.", e)
                    return@addSnapshotListener
                }
                value.
                Log.println(Log.ASSERT, "result: ", value.toString())
            }
    }

}