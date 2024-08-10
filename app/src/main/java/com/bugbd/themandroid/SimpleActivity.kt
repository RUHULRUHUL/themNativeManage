package com.bugbd.themandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bugbd.themandroid.databinding.ActivitySimpleBinding

class SimpleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this,TestActivity::class.java))
        }
    }
}