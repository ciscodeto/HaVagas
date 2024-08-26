package com.ciscodeto.havagas

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val nameET: EditText by lazy { findViewById(R.id.nameET) }
    private val emailET: EditText by lazy { findViewById(R.id.emailET) }
    private val joinEmailListCB: CheckBox by lazy { findViewById(R.id.joinEmailCB) }
    private val phoneET: EditText by lazy { findViewById(R.id.phoneET) }
    private val businessRB: RadioButton by lazy { findViewById(R.id.businessRB) }
    private val homeRB: RadioButton by lazy { findViewById(R.id.homeRB) }
    private val cellPhoneET: EditText by lazy { findViewById(R.id.cellPhoneET) }
    private val birthDateET: EditText by lazy { findViewById(R.id.birthDateET) }
    private val joinEmailCB: CheckBox by lazy { findViewById(R.id.joinEmailCB) }
    private val addCellPhoneCB: CheckBox by lazy { findViewById(R.id.addCellPhoneCB) }
    private val sexSpn: Spinner by lazy { findViewById(R.id.sexSpn) }
    private val clearBtn: Button by lazy { findViewById(R.id.clearBtn) }
    private val saveBtn: Button by lazy { findViewById(R.id.saveBtn) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}