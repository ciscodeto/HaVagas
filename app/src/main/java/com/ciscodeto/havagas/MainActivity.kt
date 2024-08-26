package com.ciscodeto.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ciscodeto.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(amb.root)

        amb.addCellPhoneCB.setOnCheckedChangeListener { _, isChecked ->
            amb.cellPhoneET.visibility = if (isChecked) View.VISIBLE else View.GONE
            amb.cellPhoneTV.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        amb.academicSpn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0, 1 -> { 
                        fundamentalView(amb)
                    }
                    2, 3 -> { 
                        graduationView(amb)
                    }
                    4, 5 -> {
                        masterDegreeView(amb)
                    }
                    else -> {
                        allGoneView(amb)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun fundamentalView(amb: ActivityMainBinding) {
        amb.finalYearTV.visibility = View.VISIBLE
        amb.finalYearET.visibility = View.VISIBLE
        amb.institutionTV.visibility = View.GONE
        amb.institutionET.visibility = View.GONE
        amb.monographTitleTV.visibility = View.GONE
        amb.monographTitleET.visibility = View.GONE
        amb.adviserTV.visibility = View.GONE
        amb.adviserET.visibility = View.GONE
    }

    private fun graduationView(amb: ActivityMainBinding) {
        amb.finalYearTV.visibility = View.VISIBLE
        amb.finalYearET.visibility = View.VISIBLE
        amb.institutionTV.visibility = View.VISIBLE
        amb.institutionET.visibility = View.VISIBLE
        amb.monographTitleTV.visibility = View.GONE
        amb.monographTitleET.visibility = View.GONE
        amb.adviserTV.visibility = View.GONE
        amb.adviserET.visibility = View.GONE
    }

    private fun masterDegreeView(amb: ActivityMainBinding) {
        amb.finalYearTV.visibility = View.VISIBLE
        amb.finalYearET.visibility = View.VISIBLE
        amb.institutionTV.visibility = View.VISIBLE
        amb.institutionET.visibility = View.VISIBLE
        amb.monographTitleTV.visibility = View.VISIBLE
        amb.monographTitleET.visibility = View.VISIBLE
        amb.adviserTV.visibility = View.VISIBLE
        amb.adviserET.visibility = View.VISIBLE
    }

    private fun allGoneView(amb: ActivityMainBinding) {
        amb.finalYearTV.visibility = View.GONE
        amb.finalYearET.visibility = View.GONE
        amb.institutionTV.visibility = View.GONE
        amb.institutionET.visibility = View.GONE
        amb.monographTitleTV.visibility = View.GONE
        amb.monographTitleET.visibility = View.GONE
        amb.adviserTV.visibility = View.GONE
        amb.adviserET.visibility = View.GONE
    }
}
