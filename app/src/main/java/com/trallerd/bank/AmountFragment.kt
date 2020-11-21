package com.trallerd.bank

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_recipient.*
import java.math.BigDecimal


class AmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.amount_send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.amount_cancel_btn).setOnClickListener(this)
        val message= getString(R.string.sendingTo, recipient)
        view.findViewById<TextView>(R.id.recipientName).text = message
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.amount_send_btn->{
                if (!TextUtils.isEmpty(amountMoney.text.toString())){
                    val amount = Money(BigDecimal(amountMoney.text.toString()))
                    val bundle = bundleOf(
                            "recipient" to recipient,
                            "amount" to amount
                    )
                    navController.navigate(R.id.amountToConfirmation, bundle)
                }else{
                    Toast.makeText(activity,R.string.toastAmount,Toast.LENGTH_SHORT).show()
                }

            }
            R.id.amount_cancel_btn->activity?.onBackPressed()
        }

    }
}