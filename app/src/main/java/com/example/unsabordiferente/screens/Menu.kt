package com.example.unsabordiferente.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentMenuBinding
import com.google.firebase.auth.FirebaseAuth


class Menu : Fragment() {
    private lateinit var binding : FragmentMenuBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_menu,container,false)

        irTomaPedido()



        return binding.root

    }

    //funcion para ir al formulario de tomar pedidos
    fun irTomaPedido(){
        binding.btnPedidos.setOnClickListener {
            it.findNavController().navigate(MenuDirections.actionMenuToPedidos())
        }
    }


}