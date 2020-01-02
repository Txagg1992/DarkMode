package com.curiousca.darkmode

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.NightTheme)
        }else{setTheme(R.style.AppTheme)}
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        night_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Log.d("MainSwitch", "Night")
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Log.d("MAinSwitch", "Day")
            }
        })
        //val currentNightMode = Configuration.UI_MODE_NIGHT_MASK
        button_change_back.setOnClickListener(View.OnClickListener {
            Log.d("MainActivity Button", "**Clicked**")
//            when(currentNightMode){
//                Configuration.UI_MODE_NIGHT_YES -> {
//                    setTheme(R.style.NightTheme)
//                }
//                Configuration.UI_MODE_NIGHT_NO -> {
//                    setTheme(R.style.AppTheme)
//                }
//            }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        })

        button_change.setOnClickListener {
            Log.d("Other Button", "Day Again")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}
