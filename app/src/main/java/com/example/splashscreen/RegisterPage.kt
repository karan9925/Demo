package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_page.*

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        btnRegister.setOnClickListener {
            if(edtRegisterName.text.toString().equals("")||edtRegisterAge.text.toString().equals("")||
                    edtRegisterEmail.text.toString().equals("")||edtRegisterpass.text.toString().equals(""))
            {
                Toast.makeText(this,"Enter Data Accurately",Toast.LENGTH_LONG).show()
            }
            else
            {
                var st = Student(edtRegisterEmail.text.toString(),edtRegisterpass.text.toString(),
                    edtRegisterName.text.toString(),edtRegisterAge.text.toString().toInt())

                var db = DBHelper(this)
                var flag = db.insert(st)
                if(flag)
                {
                    Toast.makeText(this,"Record Inserted Successfully",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this,"Having Error!",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}