package com.example.unsabordiferente.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentPedidosBinding

class Pedidos : Fragment() {
    private lateinit var binding: FragmentPedidosBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pedidos,container,false)


        binding.btnAgregar.setOnClickListener {
            Toast.makeText(context,"PEDIDO AGREGADO",Toast.LENGTH_LONG).show()
        }




        return binding.root
    }


}