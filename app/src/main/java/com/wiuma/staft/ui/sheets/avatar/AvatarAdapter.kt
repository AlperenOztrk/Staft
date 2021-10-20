package com.wiuma.staft.ui.sheets.avatar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wiuma.staft.databinding.CellAvatarBinding
import com.wiuma.staft.models.Avatars
import com.wiuma.staft.ui.member.components.SignUp

class AvatarAdapter(private val singUpLayout: SignUp, private val sheet: AvatarSheet) : RecyclerView.Adapter<AvatarViewHolder>() {
    private var avatars: Array<Avatars> = Avatars.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        val binding: CellAvatarBinding = CellAvatarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvatarViewHolder(binding, singUpLayout, sheet)
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        holder.bindData(Avatars.values()[position])
    }

    override fun getItemCount(): Int {
        return avatars.size
    }
}