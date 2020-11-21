package com.trallerd.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.transactionBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.sendMoneyBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.balanceBtn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.transactionBtn->navController!!.navigate(R.id.mainToTransactions)
            R.id.sendMoneyBtn->navController!!.navigate(R.id.mainToRecipient)
            R.id.balanceBtn->navController!!.navigate(R.id.mainToBalance)
        }

    }
}