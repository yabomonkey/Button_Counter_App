package com.example.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG2 = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG2, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById(R.id.editText)
        val button: Button = findViewById<Button>(R.id.button)
        userInput.text.clear()
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?){
                Log.d(TAG2, "onClick: called")
                textView?.append(userInput.text)
                textView?.append(("\n"))
                userInput.text.clear()
            }
        })

    }

    override fun onStart() {
        Log.d(TAG2, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG2, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
//        val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
//        textView?.text = savedString
        textView?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG2, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG2, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG2, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onRestart() {
        Log.d(TAG2, "onRestart: called")
        super.onRestart()
    }

    override fun onStop() {
        Log.d(TAG2, "onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG2, "onDestroy: called")
        super.onDestroy()
    }


}