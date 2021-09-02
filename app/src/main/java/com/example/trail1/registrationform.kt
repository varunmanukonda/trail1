package com.example.trail1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [registrationform.newInstance] factory method to
 * create an instance of this fragment.
 */
class registrationform : Fragment() {
    private lateinit var PersonName: EditText
    private lateinit var email: EditText
    private lateinit var button: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var Time: Button
    private lateinit var date: Button
    private lateinit var datestore: TextView
    private lateinit var timestore: TextView


//    private lateinit var rbtn1: RadioButton
//    private lateinit var rbtn2: RadioButton
    var cal = Calendar.getInstance()
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_registrationform, container, false)


         PersonName = view.findViewById<EditText>(R.id.PersonName)
         email = view.findViewById<EditText>(R.id.email)
         radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
         button = view.findViewById<Button>(R.id.Ok)
        Time = view.findViewById<Button>(R.id.TimeBtn)
         date = view.findViewById<Button>(R.id.Datebtn)
         timestore = view.findViewById<TextView>(R.id.Time)
         datestore = view.findViewById<TextView>(R.id.Date)

//        val rbtn1 = view.findViewById<Button>(R.id.MaleRadioButton)
//        val rbtn2 = view.findViewById<Button>(R.id.FemaleRadioButton)

        Time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                timestore.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                context,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }


        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        date.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    context!!,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })


        button.setOnClickListener {
            val Name = PersonName.text.toString().trim()
            val Email = email.text.toString().trim()
            if (Name.isEmpty()) {
                PersonName.error = "User name required"

            } else if (Name.length < 5) {
                PersonName.error = "Name is too short"
            } else if (Email.isEmpty()) {
                email.error = "Email required"

            } else if (!email.text.toString().contains("@gmail.com")) {
                email.setError("Enter valid Email id !")
            } else if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(getActivity(), "Please select a gender !", Toast.LENGTH_LONG).show();
                return@setOnClickListener
            }

val bundle= Bundle()
            bundle.putString("Name", PersonName.text.toString())
            bundle.putString("Email", email.text.toString())
            val radioGroup = radioGroup.checkedRadioButtonId
            val male = view.findViewById<RadioButton>(radioGroup)
            bundle.putString("Gender", male.text.toString())
            bundle.putString("Date", datestore.text.toString())
            bundle.putString("Time", timestore.text.toString())
            bundle.putString("Myimg", R.drawable.image.toString())

val mydetails= profiledata()
mydetails.arguments=bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_layout,mydetails)?.commit()
            Toast.makeText(getActivity(), "Registration Successful !", Toast.LENGTH_LONG).show();



        }



        return view

//                return inflater.inflate(R.layout.fragment_registrationform, container, false)




    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        datestore.text = sdf.format(cal.getTime())
    }
}


