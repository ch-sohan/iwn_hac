package com.gnits.iwn.Post

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gnits.iwn.ngoprofile.ProfileState
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PostViewModel:ViewModel() {
    private val _postState = MutableStateFlow<PostState>(PostState())
    val postState: StateFlow<PostState> = _postState
    init {
        fetchPosts()
    }
    fun fetchPosts() {
        _postState.value =PostState(progressShown =true)
        val db = Firebase.firestore
        val docRef = db.collection("ngoprofile").document("1")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("NGO Profile", "DocumentSnapshot data: ${document.data}")
                    _postState.value= PostState(
                        type = document.getString("type") ?: "",
                        description = document.getString("description") ?: "",
                        id = document.get("id") as? Int ?:0,
                        imageUrl = document.getString("imageUrl") ?: "",
                        category = document.getString("category") ?: "",
                        noofcomments = document.get("noofcomments") as? Int ?:0,
                        nooflikes = document.get("nooflikes") as? Int ?:0,
                        noofshares = document.get("noofshares") as? Int ?:0,
                        pointsearned = document.get("pointsearned") as? Int ?:0,
                        title = document.getString("title") ?: "",
                        progressShown = false,

                        )

                } else {
                    Log.d("NGO Profile", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("NGO Profile", "get failed with ", exception)
            }
    }

}

data class PostState(
    val category:String="",
    val description:String="",
    val id:Int=0,
    val imageUrl:String="",
    val noofcomments:Int=0,
    val nooflikes:Int=0,
    val noofshares:Int=0,
    val pointsearned:Int=0,
    val title:String="",
    val type:String="",
    val progressShown:Boolean=false,

)