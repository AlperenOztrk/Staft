package com.wiuma.staft.ui.member

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.wiuma.staft.MainActivity
import com.wiuma.staft.databinding.ComponentMembershipBinding

class Member(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: ComponentMembershipBinding =
        ComponentMembershipBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setView()
    }

    private fun setView() {
    }

    public fun enterView(activity: MainActivity) {
        visibility = VISIBLE
        binding.login.enter(activity, binding)
    }

    public fun exitView() {
        visibility = GONE
    }
}