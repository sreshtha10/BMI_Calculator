package com.example.bmi_calculator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_display_result.*


class DisplayResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val bmi = intent.getFloatExtra("BMI",0F)


        val gender = intent.getStringExtra("Gender")

        val formatted_bmi = "%.2f".format(bmi)

        tvBMI.text = formatted_bmi

        if(gender.equals("F")){
            if(bmi < 18.5){
                tvMessage.text = "You're Underweight"
                ivResultImage.setImageResource(R.drawable.girl_normal)
            }
            else if(bmi >= 18.5 && bmi < 24.9){
                tvMessage.text = "Normal"
                ivResultImage.setImageResource(R.drawable.girl_normal)
            }
            else{
                tvMessage.text = "You're Overweight"
                ivResultImage.setImageResource(R.drawable.girl_overweight)
            }

        }
        else{
            if(bmi < 18.5){
                tvMessage.text = "You're Underweight"
                ivResultImage.setImageResource(R.drawable.boy_normal)
            }
            else if(bmi >= 18.5 && bmi < 24.9){
                tvMessage.text = "Normal"
                ivResultImage.setImageResource(R.drawable.boy_normal)
            }
            else{
                tvMessage.text = "You're Overweight"
                ivResultImage.setImageResource(R.drawable.boy_overweight)
            }

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menuHome -> finish()
            R.id.menuClose -> finishAffinity()
            R.id.menuSC -> Intent(Intent.ACTION_VIEW).also {
                it.setData(Uri.parse("http://www.github.com/sreshtha10/BMI_Calculator"))
                startActivity(it)
            }
        }
        return true
    }
}