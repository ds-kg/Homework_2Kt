package com.example.homework_2kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_2kt.databinding.ActivityMainBinding
import com.example.homework_2kt.extenstions.load
import com.example.homework_2kt.extenstions.showToast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val url = mutableListOf(
        "https://commons.bmstu.wiki/images/8/88/Java_logo.png",
        "https://avatao.com/file/2020/08/1_fnbqF0xNVwINs_RkygkX1g.png",
        "https://chel.ligarobotov.ru/wp-content/uploads/sites/9/2020/07/py.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/ISO_C%2B%2B_Logo.svg/800px-ISO_C%2B%2B_Logo.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Unity_Technologies_logo.svg/1200px-Unity_Technologies_logo.svg.png"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLinkImage.setOnClickListener {
            httpLink()
        }
        binding.btnRandomLink.setOnClickListener {
            randomImage()
        }
    }

    private fun randomImage() {
        val random = Random.nextInt(url.size)
        val randomImage = url.get(random)
        binding.ivUrlImage.load(randomImage)
    }

    private fun httpLink() {
        val httpLink = binding.etUrlLink.text.toString()
        if (httpLink.isEmpty()) {
            showToast("Find is failed!")
        } else {
            url.add(httpLink)
            binding.etUrlLink.setText("")
            showToast("Success")
        }
    }
}