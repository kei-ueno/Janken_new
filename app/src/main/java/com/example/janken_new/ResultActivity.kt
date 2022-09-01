package com.example.janken_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.janken_new.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    val gu = 0
    val choki = 1
    val pa = 2

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("MY_HAND", 0)//null=0

        val myHand: Int

        myHand = when (id) {
            R.id.gu -> {
                binding.myHAndImage.setImageResource(R.drawable.gu)
                gu//戻り値　0
            }
            R.id.choki -> {
                binding.myHAndImage.setImageResource(R.drawable.choki)
                choki//戻り値　1
            }
            R.id.pa -> {
                binding.myHAndImage.setImageResource(R.drawable.pa)
                pa//戻り値　2
            }
            else -> gu
        }

        //コンピュータの手
        val comHand = (Math.random() * 3).toInt()//javaのMathクラスのランダムメソッド利用
        when (comHand) {
            gu -> binding.comHandImage.setImageResource(R.drawable.com_gu)
            choki -> binding.comHandImage.setImageResource(R.drawable.com_choki)
            pa -> binding.comHandImage.setImageResource(R.drawable.com_pa)
        }
        //判定
        val gameResult = (comHand - myHand + 3) % 3 //じゃんけん判定ロジック
        when (gameResult) {
            0 -> binding.resultLabel.setText(R.string.result_draw)
            1 -> binding.resultLabel.setText(R.string.result_win)
            2 -> binding.resultLabel.setText(R.string.result_lose)

        }


    }

}