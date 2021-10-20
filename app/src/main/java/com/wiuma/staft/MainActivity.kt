package com.wiuma.staft

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.wiuma.staft.databinding.ActivityMainBinding
import com.wiuma.staft.models.User

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences(
            "Staft",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(applicationContext)
        auth = Firebase.auth
        db = Firebase.firestore
        checkUser()
        binding.chats.setView(this)
    }

    private fun checkUser() {
//        if (User.userID(this).isNullOrEmpty() || auth.currentUser == null) {
        binding.membership.enterView(this)
//        }
    }
}