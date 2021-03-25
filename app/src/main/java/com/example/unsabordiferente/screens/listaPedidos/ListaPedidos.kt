package com.example.unsabordiferente.screens.listaPedidos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentListaPedidosBinding
import com.example.unsabordiferente.network.Repository

class ListaPedidos : Fragment() {

    private lateinit var binding: FragmentListaPedidosBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_pedidos, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        val repository = Repository()

        repository.listaClientesPedidos.observeForever {
            for (x in it) {
                Log.i("lista", x.nombre)
            }
        }

//        repository.listaClientesPedidos.observe(viewLifecycleOwner, Observer {
//            for (x in it) {
//
//                Log.i("lista", x.nombre)
//            }
//        })

        return binding.root
    }

}