package com.example.unsabordiferente.screens

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentPedidosBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class Pedidos : Fragment() {
    private lateinit var binding: FragmentPedidosBinding
    var db = FirebaseFirestore.getInstance()
    var celular: String = ""
    var cantidad: String = ""
    var nombre: String = ""
    var ubicacion: String = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pedidos, container, false)


        binding.btnAgregar.setOnClickListener {
            celular = binding.editCelular.text.toString()
            cantidad = binding.editCantidad.text.toString()
            nombre = binding.editNombre.text.toString()
            ubicacion = binding.editUbic.text.toString()
            if (celular.isNotBlank() and cantidad.isNotBlank() and nombre.isNotEmpty() and ubicacion.isNotBlank()) {
                var cliente= Clientes(nombre,cantidad,celular,ubicacion)
                db.collection("clientes")
                    .document(celular).set(cliente)
//                myRefPedidos.child(nombre).child("datatos").setValue(cliente)
            }

        }




        return binding.root
    }



}