package com.cristiangarrido.daggerandroid

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cristiangarrido.daggerandroid.base.ProjectApp
import com.cristiangarrido.daggerandroid.di.English
import com.cristiangarrido.daggerandroid.di.French
import com.cristiangarrido.daggerandroid.di.Spanish
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {
    @field:[Inject Spanish]
    lateinit var holaMundoText: String

    @Inject @field:English
    lateinit var helloWorldText: String

    @Inject @field:French
    lateinit var bonjourText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloWorldLabel.text = arrayOf(holaMundoText, helloWorldText, bonjourText).joinToString("\n")
    }
}
