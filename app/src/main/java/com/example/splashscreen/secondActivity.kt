package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtregister.setOnClickListener{
            var intent = Intent(this,RegisterPage::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            var db = DBHelper(this)
            var arr = ArrayList<Student>()
            arr = db.readData(edtloginid.text.toString())

            if((edtloginid.text.toString().equals(arr[0].email)) &&
                (edtloginpass.text.toString().equals(arr[0].password)))
            {
                Toast.makeText(this,"Validate User",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Not Validate User",Toast.LENGTH_LONG).show()
            }
        }
    }
}