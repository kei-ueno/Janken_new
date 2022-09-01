package com.example.janken_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.janken_new.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("MY_HAND", 0)//null=0

        when (id) {
            R.id.gu -> binding.myHAndImage.setImageResource(R.drawable.gu)
            R.id.choki -> binding.myHAndImage.setImageResource(R.drawable.choki)
            R.id.pa -> binding.myHAndImage.setImageResource(R.drawable.pa)

        }

    }

}