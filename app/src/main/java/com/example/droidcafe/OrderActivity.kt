package com.example.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Setup Spinner
        val citySpinner: Spinner = findViewById(R.id.city_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.City, // Referencing string array from strings.xml
            android.R.layout.simple_spinner_item // Layout for spinner items
        )
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        citySpinner.adapter = adapter
    }

    // Method to handle radio button selection
    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked) {
                // Same day service selected
                displayToast(getString(R.string.same_day_messenger_service))
            }

            R.id.nextday -> if (checked) {
                // Next day delivery selected
                displayToast(getString(R.string.next_day_ground_delivery))
            }

            R.id.pickup -> if (checked) {
                // Pick up selected
                displayToast(getString(R.string.pick_up))
            }
        }
    }

    // Helper method to display Toast messages
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
