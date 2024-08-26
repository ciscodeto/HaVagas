package com.ciscodeto.havagas

import android.app.AlertDialog
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

        amb.saveBtn.setOnClickListener {
            val name = amb.nameET.text.toString()
            val email = amb.emailET.text.toString()
            val joinEmailList = if (amb.joinEmailCB.isChecked) "Sim" else "Não"
            val phone = amb.phoneET.text.toString()
            val phoneType = when {
                amb.businessRB.isChecked -> "Comercial"
                amb.homeRB.isChecked -> "Residencial"
                else -> "Não especificado"
            }
            val cellPhone =  amb.cellPhoneET.text.toString()
            val sex = amb.sexSpn.selectedItem.toString()
            val birthDate = amb.birthDateET.text.toString()
            val academicBackground = amb.academicSpn.selectedItem.toString()
            val finalYear = amb.finalYearET.text.toString()
            val institution = amb.institutionET.text.toString()
            val monographTitle = amb.monographTitleET.text.toString()
            val adviser = amb.adviserET.text.toString()
            val interest = amb.interestET.text.toString()

            val message = """
                Nome: $name
                Email: $email
                Receber Emails: $joinEmailList
                Telefone: $phone ($phoneType)
                ${if (amb.addCellPhoneCB.isChecked) "Telefone Celular: $cellPhone" else ""}
                Sexo: $sex
                Data de Nascimento: $birthDate
                Formação: $academicBackground
                ${if (finalYear.isEmpty()) "" else "Ano de Conclusão: $finalYear"}
                ${if (institution.isEmpty()) "" else "Instituição: $institution"}
                ${if (monographTitle.isEmpty()) "" else "Título da Monografia: $monographTitle"}
                ${if (adviser.isEmpty()) "" else "Orientador: $adviser"}
                ${ if (interest.isEmpty()) "" else "Vagas de Interesse: $interest"}
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Dados Cadastrados")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        }

        amb.clearBtn.setOnClickListener {
            amb.nameET.text.clear()
            amb.emailET.text.clear()
            amb.joinEmailCB.isChecked = false
            amb.phoneET.text.clear()
            amb.businessRB.isChecked = false
            amb.homeRB.isChecked = false
            amb.addCellPhoneCB.isChecked = false
            amb.cellPhoneET.text.clear()
            amb.sexSpn.setSelection(0)
            amb.birthDateET.text.clear()
            amb.academicSpn.setSelection(0)
            amb.finalYearET.text.clear()
            amb.institutionET.text.clear()
            amb.monographTitleET.text.clear()
            amb.adviserET.text.clear()
            amb.interestET.text.clear()
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
