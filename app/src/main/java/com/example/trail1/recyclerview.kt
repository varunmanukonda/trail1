package com.example.trail1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class recyclerview : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_recyclerview, container, false)
        btnValidate = view.findViewById(R.id.button)
        btnValidate.setOnClickListener{
            val profiledetais=registrationform()
//            profiledetais.arguments=bundle
//       setFragmentResult(RESULT_OK.toString(),bundle)
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_layout,profiledetais)?.commit()
        }
        return view
    }


}