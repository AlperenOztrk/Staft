package com.wiuma.staft.ui.member.components

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.wiuma.staft.MainActivity
import com.wiuma.staft.databinding.ComponentMembershipBinding
import com.wiuma.staft.databinding.LayoutSignUpBinding
import com.wiuma.staft.models.Avatars
import com.wiuma.staft.models.User
import com.wiuma.staft.ui.sheets.avatar.AvatarSheet

class SignUp(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private lateinit var activity: MainActivity
    private var binding: LayoutSignUpBinding =
        LayoutSignUpBinding.inflate(LayoutInflater.from(context), this, true)
    private lateinit var rootBinding: ComponentMembershipBinding
    private var userAvatar = Avatars.flower
    private lateinit var user: FirebaseUser

    init {
        setView()
    }

    private fun setView() {
        binding.back.setOnClickListener { exit() }
        binding.avatar.setOnClickListener { showSheet() }
        binding.registerButton.setOnClickListener { register() }
        setAvatar(Avatars.flower)
    }

    fun enter(activity: MainActivity, rootBinding: ComponentMembershipBinding) {
        this.activity = activity
        this.rootBinding = rootBinding
        this.activity = activity
        visibility = VISIBLE
    }

    private fun register() {
        activity.auth.createUserWithEmailAndPassword(binding.emailAddress.text.toString(), binding.password.text.toString())
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    user = activity.auth.currentUser!!
                    setUserProfile()
                    saveUser()
                    activity.binding.membership.exitView()
                } else {
                    Log.println(Log.ASSERT, "Log.ASSERT", ": " + task.exception)
                    Log.println(Log.ASSERT, "Log.ASSERT", ": " + task.isCanceled)
                    Log.println(Log.ASSERT, "Log.ASSERT", ": " + task.isComplete)
                    Log.println(Log.ASSERT, "Log.ASSERT", ": " + task.isSuccessful)
                    Log.println(Log.ASSERT, "createUserWithEmail:failure", task.exception!!.localizedMessage!!)
                    Toast.makeText(context, "Başarısız kayıt.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun setUserProfile() {
        val profileUpdates = userProfileChangeRequest {
            displayName = binding.name.text.toString()
            photoUri = Uri.parse(userAvatar.imageURL())
        }
        user.updateProfile(profileUpdates)
    }

    fun saveUser() {
        User.setUserID(activity, user.uid)
        val user = hashMapOf(
            "id" to user.uid,
            "name" to binding.name.text.toString(),
            "avatar" to userAvatar.imageURL(),
            "public" to true
        )

        activity.db.collection("users")
            .document(this.user.uid)
            .set(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

    private fun exit() {
        visibility = GONE
        rootBinding.login.enter(activity, rootBinding)
    }

    fun setAvatar(avatar: Avatars?) {
        avatar?.let { userAvatar = avatar }
        binding.iconAvatar.setImageDrawable(ContextCompat.getDrawable(context, userAvatar.image()))
    }

    private fun showSheet() {
        val avatarSheet = AvatarSheet(this)
        avatarSheet.show(activity.supportFragmentManager, "AvatarSheet")
    }
}