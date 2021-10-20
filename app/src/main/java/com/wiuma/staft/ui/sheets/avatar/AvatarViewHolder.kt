package com.wiuma.staft.ui.sheets.avatar

import androidx.recyclerview.widget.RecyclerView
import com.wiuma.staft.databinding.CellAvatarBinding
import com.wiuma.staft.models.Avatars
import com.wiuma.staft.ui.member.components.SignUp

class AvatarViewHolder(private val binding: CellAvatarBinding, private val signUp: SignUp, private val sheet: AvatarSheet) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(avatar: Avatars) {
        binding.icon.setImageResource(avatar.image())
        binding.icon.setOnClickListener {
            signUp.setAvatar(avatar)
            sheet.dismiss()
        }
    }
}