package com.example.coroutines1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener {
            test1()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            test2()
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            test3()
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            test4()
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            test5()
        }
    }

    private fun test5() {
        TODO("Not yet implemented")
    }

    private fun test4() {
        val start = System.currentTimeMillis()
        Log.d("test4", "Startttt!")
        runBlocking {
            for (i in 1..10) {
                launch {
                    delay(3000L - i * 300)
                    Log.d("test4", "Countdown: $i")
                }
            }
        }
        // Execution continues when all coroutines in the scope have finished
        Log.d("test4", "Stopppp!")
    }

    private fun test3() {
        runBlocking {
            val job = launch {
                Log.d("test2", "World")
            }
            Log.d("test2", "Hello")
            job.join()
            Log.d("test2", "Done")
        }
    }

    private fun test2() {
        runBlocking {
            val job = launch {
                Log.d("test2", "World")
            }
            Log.d("test2", "Hello")
            Log.d("test2", "Done")
        }
    }

    private fun test1() {
        runBlocking {
            launch {
                delay(1000)
                Log.d("test1", "World")
            }
            Log.d("test1", "Hello")
        }
    }

    suspend fun delayAndPrint() {
        delay(1000)
        Log.d("test1", "World")
    }
}