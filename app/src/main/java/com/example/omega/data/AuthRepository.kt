package com.example.omega.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.omega.models.User
import com.example.omega.navigation.INVENTORY
import com.example.omega.navigation.ROUTE_HOME
import com.example.omega.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthRepository
    (var navController: NavHostController, var context: Context) {

        var mAuth:FirebaseAuth = FirebaseAuth.getInstance()
    var progress:ProgressDialog = ProgressDialog(context)

    init {
        progress.setTitle("Loading")
            progress.setMessage("Please Wait....")
        }
        fun signup(name:String, email:String,password:String){
            progress.show()
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    var userId = mAuth.currentUser!!.uid
                    var userData = User(name, email, password, userId)
                    var regRef = FirebaseDatabase.getInstance().getReference().child("Users/$userId")
                    regRef.setValue(userData).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(context, "Nice Job! Signup Successful", Toast.LENGTH_SHORT).show()
                            navController.navigate(INVENTORY)
                        }
                    }
                }
            }
        }

    fun login(email: String, password: String){
        progress.show()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                navController.navigate(INVENTORY)
            }
        }
    }

    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isLoggedIn():Boolean{
        return mAuth.currentUser !=null
    }
}