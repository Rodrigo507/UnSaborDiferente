package com.example.unsabordiferente.screens.listaPedidos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentListaPedidosBinding
import com.example.unsabordiferente.network.Repository
import com.google.android.material.snackbar.Snackbar

class ListaPedidos : Fragment() {

    private lateinit var binding: FragmentListaPedidosBinding
    private lateinit var viewModel: ListaPedidosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_pedidos, container, false)
        viewModel = ViewModelProvider(this).get(ListaPedidosViewModel::class.java)

        val adapter =ListaPedidoAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.listasPedidos.observeForever {
            it?.let {
                adapter.submitList(it)
            }

        }


        binding.lifecycleOwner = this

        return binding.root
    }

}