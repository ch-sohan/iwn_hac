package com.gnits.iwn.ngoprofile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NgoProfileViewModel : ViewModel() {
    private val _profileState = MutableStateFlow<ProfileState>(ProfileState())
    val profileState: StateFlow<ProfileState> = _profileState
    init {
        fetchProfile()
    }
    fun fetchCategories() {
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

    fun fetchPosts() {
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

    fun fetchProfile() {
        _profileState.value =ProfileState(progressShown =true)
        val db = Firebase.firestore
        val docRef = db.collection("ngoprofile").document("1")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("NGO Profile", "DocumentSnapshot data: ${document.data}")
                    _profileState.value= ProfileState(
                        ngoname = document.getString("ngoname") ?: "",
                        bio = document.getString("bio") ?: "",
                        followersCount = document.getString("followersCount")?: "",
                        followingCount = document.getString("followingCount")?: "",
                        link = document.getString("link") ?: "",
                        subCategory = document.getString("subCategory") ?: "",
                        postCount = document.getString("postCount")?: "",
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

data class ProfileState(
    val ngoname: String = "",
    val bio: String = "",
    val followersCount:String="",
    val followingCount:String="",
    val link: String = "",
    val postCount: String="",
    val subCategory: String = "",
    val progressShown: Boolean = false,
)
