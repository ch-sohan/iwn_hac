package com.gnits.iwn.cat

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gnits.iwn.ngoprofile.ProfileState
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CategoryViewModel:ViewModel() {
    private val _categoryState = MutableStateFlow<CategoryState>(CategoryState())
    val categoryState: StateFlow<CategoryState> = _categoryState
    init {
        fetchCategories()
    }
    fun fetchCategories() {
        _categoryState.value =CategoryState(progressShown =true)
        val db = Firebase.firestore
        val docRef = db.collection("categories").document("1")
        db.collection("categories")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Categories", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Categories", "Error getting documents: ", exception)
            }
    }

}

data class CategoryState(
    val categories:List<Category> = emptyList() ,
    val progressShown: Boolean = false,

    )
data class Category(
    val imageUrl:String="",
    val title:String="",


)