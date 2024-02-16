package com.gnits.iwn.ngoprofile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class NgoProfileViewModel :ViewModel(){

    fun fetchProfile(){


    }
    fun fetchCategories(){
        val db = Firebase.firestore
        db.collection("categories")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Categories", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Categories", "Error getting documents.", exception)
            }
    }

    fun fetchPosts(){
        val db = Firebase.firestore
        db.collection("posts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Posts", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Posts", "Error getting documents.", exception)
            }
    }


}
