package com.wiuma.staft.ui.sheets.avatar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wiuma.staft.databinding.SheetAvatarBinding
import com.wiuma.staft.ui.member.components.SignUp

class AvatarSheet(private var singUpLayout: SignUp) : BottomSheetDialogFragment() {
    lateinit var binding: SheetAvatarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SheetAvatarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
    }

    private fun bindView() {
        binding.recycler.layoutManager = GridLayoutManager(context, 4)
        binding.recycler.adapter = AvatarAdapter(singUpLayout, this)
    }
}