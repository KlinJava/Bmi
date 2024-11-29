package com.hank.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hank.bmi.databinding.ActivityBmiBinding

class BmiActivity : AppCompatActivity() {
    private lateinit var viewModel: BmiViewModel
    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bmi)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(BmiViewModel::class.java)
        viewModel.resultView.observe(this, Observer {
            AlertDialog.Builder(this)
                .setTitle("Bmi result")
                .setMessage("Your Bmi is : ${viewModel.result}")
                .setPositiveButton("OK",null)
                .show()
        })
    }

    fun calculateBmi(view:View) {
        val w = binding.weightValue.text.toString().toFloat()
        val h = binding.heightValue.text.toString().toFloat()
        viewModel.calculate(BmiWH(w,h))
    }

    fun resetBmi(view:View) {
        binding.weightValue.setText("")
        binding.heightValue.setText("")
    }
}

