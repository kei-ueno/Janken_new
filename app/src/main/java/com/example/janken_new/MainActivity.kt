package com.example.janken_new

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.janken_new.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //イメージボタンとメソッド紐づけ
        binding.gu.setOnClickListener { onJankenButtontapped(it) }
        binding.choki.setOnClickListener { onJankenButtontapped(it) }
        binding.pa.setOnClickListener { onJankenButtontapped(it) }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            clear()
        }
    }

    //遷移処理
    fun onJankenButtontapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)
        startActivity(intent)
    }
}