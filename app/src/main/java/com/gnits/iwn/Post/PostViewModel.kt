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
        _postState.value = PostState(progressShown =true)
        val db = Firebase.firestore
        db.collection("posts")
            .get()
            .addOnSuccessListener { result ->
                val postItems = mutableListOf<Post>()
                for (document in result) {
                    Log.d("Post Item", "${document.id} => ${document.data}")
                    postItems.add(
                        Post(
                            type = document.getString("type") ?: "",
                            description = document.getString("description") ?: "",
                            id = document.getString("id")?:"",
                            imageUrl = document.getString("imageUrl") ?: "",
                            category = document.getString("category") ?: "",
                            noofcomments = document.getString("noofcomments") ?: "",
                            nooflikes = document.getString("nooflikes") ?: "",
                            noofshares = document.getString("noofshares") ?: "",
                            pointsearned = document.getString("pointsearned") ?: "",
                            title = document.getString("title") ?: ""
                        )
                    )
                }
                _postState.value = PostState(postItems, false)
            }
            .addOnFailureListener { exception ->
                Log.d("Categories", "Error getting documents: ", exception)
            }
    }

}

data class PostState(
    val posts: List<Post> = emptyList(),
    val progressShown:Boolean=false
)

data class Post(
    val category:String="",
    val description:String="",
    val id:String="",
    val imageUrl:String="",
    val noofcomments:String="",
    val nooflikes:String="",
    val noofshares:String="",
    val pointsearned:String="",
    val title:String="",
    val type:String=""
)