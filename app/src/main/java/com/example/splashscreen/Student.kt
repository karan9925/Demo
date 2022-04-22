package com.example.splashscreen

data class Student (var email:String, var password:String, var name:String, var Age:Int) {
    var id :Int = 0
    constructor(id:Int,email: String,password: String,name: String,Age: Int) :this(email,password,name,Age)
    {
        this.id = id
    }
}