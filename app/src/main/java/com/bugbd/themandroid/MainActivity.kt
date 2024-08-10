package com.bugbd.themandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugbd.themandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MultipleSelectionAdapter
    private lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = Preferences()
        preferences.initPreference(this)
        adapter = MultipleSelectionAdapter(list = students,this)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        setCheckedRadio(binding.radio,preferences.getThem()?:"")
        setThem(preferences.getThem()?:"")

        binding.radio.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.darkThem -> {
                    preferences.saveThem("MODE_NIGHT_YES")
                    setThem(preferences.getThem()?:"")
                }
                R.id.lightThem -> {
                    preferences.saveThem("MODE_NIGHT_NO")
                    setThem(preferences.getThem()?:"")
                }
                else -> {
                    preferences.saveThem("MODE_NIGHT_FOLLOW_SYSTEM")
                    setThem(preferences.getThem()?:"")
                }
            }
        }

        binding.themTxt.setOnClickListener {
            startActivity(Intent(this,SimpleActivity::class.java))
        }


    }
}