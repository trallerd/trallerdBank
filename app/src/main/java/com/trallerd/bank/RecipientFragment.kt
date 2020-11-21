package com.trallerd.bank

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_recipient.*

class RecipientFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.nextRecipient).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancelRecipient).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.nextRecipient->{
                if (!TextUtils.isEmpty(resRecipient.text.toString())){
                    val bundle = bundleOf("recipient" to resRecipient.text.toString())
                    navController!!.navigate(R.id.recipientToAmount, bundle)
                }else{
                    Toast.makeText(activity,R.string.recipientMessage, Toast.LENGTH_SHORT).show()
                }

            }

            R.id.cancelRecipient-> activity?.onBackPressed()
        }
    }
}