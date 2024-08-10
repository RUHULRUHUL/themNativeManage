package com.bugbd.themandroid

import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate

data class Student(
    val id:Int,
    val name:String,
    var isSelected:Boolean = false
)

val students = listOf(
    Student(id = 302555,"shamim"),
    Student(id = 302556,"shakib"),
    Student(id = 302557,"saddam"),
    Student(id = 302558,"sobuj"),
    Student(id = 302559,"shakil"),
    Student(id = 3025510,"haider"),
    Student(id = 3025511,"ali"),
    Student(id = 3025512,"saumik"),
)

fun setThem(them:String){
    when(them){
        "MODE_NIGHT_YES"->{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        "MODE_NIGHT_NO"->{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        "MODE_NIGHT_FOLLOW_SYSTEM"->{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}

fun setCheckedRadio(radioGroup: RadioGroup,them:String){
    when(them){
        "MODE_NIGHT_YES"->{
            radioGroup.check(R.id.darkThem)
        }
        "MODE_NIGHT_NO"->{
            radioGroup.check(R.id.lightThem)
        }
        "MODE_NIGHT_FOLLOW_SYSTEM"->{
            radioGroup.check(R.id.system)
        }
    }
}
