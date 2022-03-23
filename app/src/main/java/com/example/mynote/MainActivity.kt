package com.example.mynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
    private val topBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.top_bottom_anim)}

    private var clicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            onAddButtonClicked()
        }
        binding.editButton.setOnClickListener {
            val intent = Intent(this, Note::class.java)
            startActivity(intent)
            Toast.makeText(this, "Edit Button CLicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean){
        if(!clicked) {
            binding.editButton.visibility = View.VISIBLE
        }else{
            binding.editButton.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean){
        if(!clicked) {
            binding.editButton.startAnimation(fromBottom)
            binding.addButton.startAnimation(rotateOpen)
        }else{
            binding.editButton.startAnimation(topBottom)
            binding.addButton.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean) {
        binding.editButton.isClickable = !clicked
    }



}