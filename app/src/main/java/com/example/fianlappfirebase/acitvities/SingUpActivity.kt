package com.example.fianlappfirebase.acitvities

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.extencionfuntions.*
import com.example.fianlappfirebase.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sing_up.*
import java.util.regex.Pattern


private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)


        buttonGoLogIn.setOnClickListener {

            goToActivity<LoginAcitivty> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

        }


        buttonSignUp.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()
            if (isValidEmail(email) && isValidPassword(password) && isValidConfirmPassword(password, confirmPassword)) {
                signUpByEmail(email, password)
            } else {
                toastt("Please make sure all the data is correct.")
            }
        }

        editTextEmail.validate {
            editTextEmail.error = if (isValidEmail(it)) null else "Email is not valid"
        }

        editTextPassword.validate {
            editTextPassword.error = if (isValidPassword(it)) null else "Password should contain 1 lowercase, 1 uppercase, 1 number, 1 special character and 4 characters length at least."
        }

        editTextConfirmPassword.validate {
            editTextConfirmPassword.error = if (isValidConfirmPassword(editTextPassword.text.toString(), it)) null else "Confirm Password does not match with Password"
        }

    }

    private fun signUpByEmail(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                mAuth.currentUser!!.sendEmailVerification().addOnCompleteListener(this) {
                    toastt("An email has been sent to you. Please, confirm before sign in.")

                    goToActivity<LoginAcitivty> {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
            } else {
                toastt("An unexpected error occurred, please try again.")
            }
        }
    }
}