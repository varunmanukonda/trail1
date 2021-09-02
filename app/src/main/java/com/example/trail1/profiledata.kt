package com.example.trail1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class profiledata : Fragment() {
    private lateinit var namefinal: TextView
    private lateinit var emailfinal: TextView
    private lateinit var genderfinal: TextView
    private lateinit var datefinal: TextView
    private lateinit var timefinal: TextView
    private lateinit var btnhome: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_profiledata, container, false)

        btnhome = view.findViewById(R.id.gohome)
        btnhome.setOnClickListener {
            val homecomming = recyclerview()
//            profiledetais.arguments=bundle
//       setFragmentResult(RESULT_OK.toString(),bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_layout, homecomming)
                ?.commit()
        }


         namefinal=view.findViewById<TextView>(R.id.namestore)
         emailfinal=view.findViewById<TextView>(R.id.emailstore)
         genderfinal=view.findViewById<TextView>(R.id.genderstore)
         datefinal=view.findViewById<TextView>(R.id.datestore)
         timefinal=view.findViewById<TextView>(R.id.timestore)
//         imagestore=view.findViewById<TextView>(R.id.imagestore)


        val name = this.arguments?.get("Name")
        val email = this.arguments?.get("Email")
        val gender = this.arguments?.get("Gender")
        val date = this.arguments?.get("Date")
        val time=this.arguments?.get("Time")
//        val resId: Int = requireArguments().getInt("MyImg")


        namefinal.text = "Name:$name"
        emailfinal.text = "Email:$email"
        genderfinal.text = "Gender:$gender"
        datefinal.text="Dob:$date"
        timefinal.text="Time:$time"
//        imageView.setImageResource(resId)


        return view

    }


}