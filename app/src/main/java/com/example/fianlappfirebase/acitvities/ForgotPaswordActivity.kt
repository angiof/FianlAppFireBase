package com.example.fianlappfirebase.acitvities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.extencionfuntions.*
import com.example.fianlappfirebase.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_pasword.*

private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

class ForgotPaswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pasword)


        buttonGoLogIn.setOnClickListener {
            goToActivity<LoginAcitivty> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            }

            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        editTextEmail.validate {
            editTextEmail.error = if (isValidEmail(it)) null else "email is not valid"
        }

        buttonForgot.setOnClickListener {
            val email = editTextEmail.text.toString()
            if (isValidEmail(email))   {
                mAuth.sendPasswordResetEmail(email)
                goToActivity<LoginAcitivty> {
                    toastt("reset password link sent to $email")
                }
            }    else toastt("wrong mail")
        }


    }
}