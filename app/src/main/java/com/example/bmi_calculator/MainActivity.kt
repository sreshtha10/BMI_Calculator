package com.example.bmi_calculator

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var height = 1F
        var weight= 0F


        btnCalculateBMI.setOnClickListener {

            try {
                height = etHeight.text.toString().toFloat()
                weight = etWeight.text.toString().toFloat()
            }
            catch(e:Exception){
                Toast.makeText(this,"Wrong Format !",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var gender = "F"

            if(rbMale.isChecked){
                 gender = "M"
            }

            val bmi:Float = calcBMI(height,weight)

            etHeight.text.clear()
            etWeight.text.clear()

            // start second activity
            Intent(this,DisplayResultActivity::class.java).also {
                it.putExtra("BMI",bmi)
                it.putExtra("Gender",gender)
                startActivity(it)
            }

        }
    }

    private fun calcBMI(height: Float, weight: Float): Float{
        return (weight)/((height*height)/10000)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menuClose -> finishAffinity()
            R.id.menuSC -> Intent(ACTION_VIEW).also {
                it.setData(Uri.parse("http://www.github.com/sreshtha10/BMI_Calculator"))
                startActivity(it)
            }
        }
        return true
    }


}