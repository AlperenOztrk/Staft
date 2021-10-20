package com.wiuma.staft.ui.member.components

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.wiuma.staft.MainActivity
import com.wiuma.staft.databinding.ComponentMembershipBinding
import com.wiuma.staft.databinding.LayoutLoginBinding
import com.wiuma.staft.models.User

class Login(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private lateinit var activity: MainActivity
    private var binding: LayoutLoginBinding =
        LayoutLoginBinding.inflate(LayoutInflater.from(context), this, true)
    private lateinit var rootBinding: ComponentMembershipBinding

    init {
        setView()
    }

    private fun setView() {
        binding.loginButton.setOnClickListener { login() }
        binding.registerButton.setOnClickListener { register() }
    }

    private fun login() {
        activity.auth.signInWithEmailAndPassword(binding.emailAddress.text.toString(), binding.password.text.toString())
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = activity.auth.currentUser
                    User.setUserID(activity, user!!.uid)
                    activity.binding.membership.exitView()
                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(context, "Başarısız giriş.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun register() {
        exit()
        rootBinding.signUp.enter(activity, rootBinding)
    }

    fun enter(activity: MainActivity, rootBinding: ComponentMembershipBinding) {
        this.activity = activity
        this.rootBinding = rootBinding
        visibility = VISIBLE
    }

    private fun exit() {
        visibility = GONE
    }
}