package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.RegExp

//import kotlin.jvm.JvmStatic as

class CheckoutActivity1 : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating a function with listener.
        buttonOrder.setOnClickListener{

            var validInputs = true
            var msg = ""

            //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
            val customer_Name = findViewById<EditText>(R.id.txtCustomerName)
            val address = findViewById<EditText>(R.id.txtAddr)
            val postal_code = findViewById<EditText>(R.id.txtPostalCode)
            val mobile_num = findViewById<EditText>(R.id.txtMoileNumber)
            val card_Type = findViewById<View>(R.id.txtCardType) as Spinner
            val card_Num = findViewById<EditText>(R.id.txtCCNum)
            val expiry_date = findViewById<EditText>(R.id.txtExpiryDate)

            //Converting the above input into string assign to below variables
            val name = customer_Name.text.toString()
            val addr = address.text.toString()
            val postcode = postal_code.text.toString()
            val mobNum = mobile_num.text.toString()
            val cType = card_Type.selectedView as TextView
            val cNum = card_Num.text.toString()
            val exp_Date = expiry_date.text.toString()

            if (name == ""){
                validInputs= false
                msg = "Please Enter Your Name"
            }
            if (addr == "") {
                validInputs= false
                msg = "Please Enter Your Address"
            }
            if (postcode.length <= 6) {
                    validInputs= false
                    msg = "Incorrect Postal Code"
                }
            if (checkLuhn(cNum) == false) {
                validInputs = false
                msg = "Please Enter the Valid Card Number"
            }
            if (mobNum.length != 10) {
                validInputs = false
                msg ="Please Enter Valid Mobile Number"
            }


            // Passing values using intent
            val i = Intent(this, CheckoutDisplayActivity::class.java)

            //storing value with key values pair of intent object using putExtra() method
            i.putExtra("Customer's Name", name)
            i.putExtra("Address", addr)
            i.putExtra("Postal Code", postcode)
            //i.putExtra("Mobile Number", mobNum)
            //i.putExtra("Card Type", cType)
            //i.putExtra("Credit Card Number", cNum)
            //i.putExtra("Expiry Date", exp_Date)

            //this method helps to navigate first activity screen to second activity screen.
            if(validInputs){
                startActivity(i)
            }
            else{
                Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
            }

        }
    }

    //The Luhn algorithm, is a simple checksum formula used to validate a variety of identification numbers, such as credit card numbers.
    fun checkLuhn(txtCCNum:String):Boolean {
        var nDigits = txtCCNum.length
        var nSum = 0
        var isSecond = false
        for (i in nDigits - 1 downTo 0)
        {
            var d = txtCCNum.get(i) - '0'
            if (isSecond == true)
                d = d * 2

            // We add two digits to handle
            // cases that make two digits
            // after doubling
            nSum += d / 10
            nSum += d % 10
            isSecond = !isSecond
        }
        return (nSum % 10 == 0)
    }
}