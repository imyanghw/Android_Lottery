package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countDownTimer = object : CountDownTimer(1500, 100) {
            override fun onTick(p0: Long) {
                val lotteryList = arrayListOf(number1, number2, number3, number4, number5, number6)
                val numberArray = IntArray(6)

                lotteryList.forEachIndexed {index, textView ->
                    while (true) {
                        val randomNumber = (Math.random() * 45 + 1).toInt()
                        if (!numberArray.contains(randomNumber)) {
                            numberArray[index] = randomNumber
                            break;
                        }
                    }
                    textView.text = "${numberArray[index]}"
                }
            }

            override fun onFinish() {
            }
        }

        lotteryWhirl.setOnClickListener {
            if (lotteryWhirl.isAnimating) { //애니매이션이 동작중이면
                lotteryWhirl.cancelAnimation() //애니매이션 취소
                countDownTimer.cancel() //카운트다운 타이머 취소
            } else {
                lotteryWhirl.playAnimation()
                countDownTimer.start()
            }
        }
    }
}