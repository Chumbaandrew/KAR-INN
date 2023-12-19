package com.example.kar_inn.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.kar_inn.model.user
import com.example.kar_inn.navigation.ROUTE_HOME
import com.example.kar_inn.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel ( var controller:NavHostController, var context: Context){


    lateinit var mAuth : FirebaseAuth
    var progress:ProgressDialog


    init {
       var mAuth = FirebaseAuth.getInstance()
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")

    }

    fun signup(email:String,pass:String,confpass:String){


        if (email.isBlank() || pass.isBlank() || confpass.isBlank()){
            Toast.makeText(context,"Please fill the blanks", Toast.LENGTH_LONG).show()
            return

        }
        else if (pass != confpass){
            Toast.makeText(context,"Password do not match", Toast.LENGTH_LONG).show()
            return
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                if (it.isSuccessful){
                    val userdata= user(email,pass,mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {


                        if (it.isSuccessful) {
                            Toast.makeText(context, "Account Created Successfully", Toast.LENGTH_LONG).show()
                            controller.navigate(ROUTE_LOGIN)
                        } else {
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                                .show()
                        }
                    }

                }
            }
        }


    }


    fun login(email: String,pass: String){


        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"LogIn successful",Toast.LENGTH_LONG).show()
                controller.navigate(ROUTE_HOME)
            }
            else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                controller.navigate(ROUTE_LOGIN)
            }
        }
    }


    fun logout(){
        mAuth.signOut()
        controller.navigate(ROUTE_LOGIN)
    }
    fun loggedin():Boolean{
        return mAuth.currentUser !=null
    }






}