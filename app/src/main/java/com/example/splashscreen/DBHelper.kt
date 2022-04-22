package com.example.splashscreen

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VER){
    companion object{
        private val DB_NAME = "StudentDB"
        private val DB_VER = 1
        private val TB_NAME = "Student"

        private val F1_STUDENT = "id"
        private val F2_STUDENT = "email"
        private val F3_STUDENT ="password"
        private val F4_STUDENT = "name"
        private val F5_STUDENT = "Age"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var q = "CREATE TABLE $TB_NAME ($F1_STUDENT INTEGER PRIMARY KEY AUTOINCREMENT, $F2_STUDENT TEXT," +
                "$F3_STUDENT TEXT,$F4_STUDENT TEXT,$F5_STUDENT INTEGER)"

        p0?.execSQL(q)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(st:Student) : Boolean
    {
        var db  = writableDatabase
        var cv = ContentValues()
        cv.put(F2_STUDENT,st.email)
        cv.put(F3_STUDENT,st.password)
        cv.put(F4_STUDENT,st.name)
        cv.put(F5_STUDENT,st.Age)

        var flag = db.insert(TB_NAME,null,cv)
        if(flag>0)
        {
            return true
        }
        else
            return  false
    }
    fun readData(email:String) :  ArrayList<Student>
    {
        var db = readableDatabase
        var arr = ArrayList<Student>()
        var q  = "Select * from $TB_NAME where $F2_STUDENT = '$email'"
        var cursor = db.rawQuery(q,null)

        while (cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var email = cursor.getString(1)
            var pass = cursor.getString(2)
            var name= cursor.getString(3)
            var age = cursor.getInt(4)

            var st = Student(id,email,pass,name,age)
            arr.add(st)
        }
        return arr
    }
}