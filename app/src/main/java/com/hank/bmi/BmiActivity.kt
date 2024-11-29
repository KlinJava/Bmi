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
                .setTitle(getString(R.string.bmi_result))
                .setMessage("${getString(R.string.your_bmi_is)} ${viewModel.result}")
                .setPositiveButton("OK",null)
                .show()
        })
    }

    fun calculateBmi(view:View) {
        val w = binding.weightValue.text.toString()
        val h = binding.heightValue.text.toString()
        if (!(w.equals("") && h.equals(""))){
            viewModel.calculate(BmiWH(w.toFloat(),h.toFloat()))
        } else {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.bmi_error))
                .setMessage(getString(R.string.weight_height_value_arent_empty))
                .setPositiveButton("OK",null)
                .show()
        }
    }

    fun resetBmi(view:View) {
        binding.weightValue.setText("")
        binding.heightValue.setText("")
    }
}

