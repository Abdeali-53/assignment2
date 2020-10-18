package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView

class CheckoutDisplayActivity : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_display)

        //defining an intent object
        val intent =getIntent()

        // Since, I am using putExtra in my activity1 here I have to get values from previous activity using intent object
        val message1=intent.getStringExtra("Customer's Name")
        val message2=intent.getStringExtra("Address")
        val message3=intent.getStringExtra("Postal Code")
        //val message4=intent.getStringExtra("Mobile Number")
        //val message5=intent.getStringExtra("Card Type")
        //val message6=intent.getStringExtra("Credit Card Number")
        //val message7=intent.getStringExtra("Expiry Date")

        val cust_name=findViewById<TextView> (R.id.txtCustomerName)
        val addr=findViewById<TextView> (R.id.txtAddr)
        val postcode=findViewById<TextView> (R.id.txtPostalCode)
        //val mob_Num=findViewById<TextView> (R.id.txtMoileNumber)
        //val cType =findViewById<TextView> (R.id.txtCardType)
        //val ccNum=findViewById<TextView> (R.id.txtCCNum)
        //val exp_date =findViewById<TextView> (R.id.txtExpiryDate)

        //assigning message value to textview control And I am also concatenating the above input with the below variable.
        cust_name.text= "Customer's Name :" +message1.toString()
        addr.text="Address :" +message2.toString()
        postcode.text="Postal Code :" +message3.toString()
        //mob_Num.text="Mobile Number :" +message4.toString()
        //cType.text="Card Type :" +message5.toString()
        //ccNum.text="Credit Card Number :" +message6.toString()
        //exp_date.text="Expiry Date :" +message7.toString()

    }
}