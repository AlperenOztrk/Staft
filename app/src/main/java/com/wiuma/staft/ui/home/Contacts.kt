package com.wiuma.staft.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.wiuma.staft.databinding.ComponentMembershipBinding

class Contacts(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: ComponentMembershipBinding =
        ComponentMembershipBinding.inflate(LayoutInflater.from(context), this, true)

}