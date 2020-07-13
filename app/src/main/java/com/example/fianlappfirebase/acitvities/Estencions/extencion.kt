package com.example.extencionfuntions

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.fianlappfirebase.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_acitivty.view.*
import kotlinx.android.synthetic.main.activity_sing_up.*
import java.util.regex.Pattern

//import com.squareup.picasso.Picasso

fun EditText.validate(validation: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            validation(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if ( s?.length==8){
                Toast.makeText(context," i numero dei caratteri richiesti è stato inserito con sucesso ",Toast.LENGTH_LONG).show()

            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {






        }
    })
}



fun Activity.gotoActivityResult(action: String,requestcode:Int ,init: Intent.() -> Unit={}){
    val intent=Intent(action)
    intent.init()
    startActivityForResult(intent,requestcode)
}

inline fun  < reified T:Activity>Activity.goToActivity(  noinline init: Intent.()-> Unit ={} ){
     val intent=Intent(this,T::class.java)
     intent.init()
     startActivity(intent)
}

 //fun ImageView.imageviewloaderbyurl(url: String)= Picasso.get().load(url)
   // .transform(Trans())
    //.into(this)

fun Activity.isValidEmail(email: String): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

fun Activity.isValidPassword(password: String): Boolean {
    // Necesita Contener -->    1 Num / 1 Minuscula / 1 Mayuscula / 1 Special / Min Caracteres 4
    val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
    val pattern = Pattern.compile(passwordPattern)
    return pattern.matcher(password).matches()
}

fun Activity.isValidConfirmPassword(password: String, confirmPassword: String): Boolean {
    return password == confirmPassword
}

fun ViewGroup.infla(layoutId: Int)= LayoutInflater.from(context).inflate(layoutId,this,false)
fun Int.isnatural()=this >=0
fun Activity.toastt(message: CharSequence, duration:Int=Toast.LENGTH_LONG)= Toast.makeText(this,message,duration).show()
fun Activity.snackisnacki(message: CharSequence, view: View? =findViewById(R.id.container), duration: Int=Snackbar.LENGTH_LONG, action:String?=null, actionsEvent:(v:View)->Unit={}){





    if (view!=null){
        val snack = Snackbar.make(view,message,duration)
        if (!action.isNullOrEmpty()){
            snack.setAction(action,actionsEvent)
        }
        snack.show()
    }







}