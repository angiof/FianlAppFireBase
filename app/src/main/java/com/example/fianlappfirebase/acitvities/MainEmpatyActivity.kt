package com.example.fianlappfirebase.acitvities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.extencionfuntions.goToActivity
import com.google.firebase.auth.FirebaseAuth


class MainEmpatyActivity : AppCompatActivity() {
    private val mAuth: FirebaseAuth =FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (mAuth.currentUser==null){
            goToActivity<LoginAcitivty> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }else{
            goToActivity<MainActivity> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
        finish()





    }
}