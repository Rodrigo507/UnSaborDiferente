package com.example.unsabordiferente.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentPedidosBinding
import com.example.unsabordiferente.network.Repository
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore


class Pedidos : Fragment() {
    private lateinit var binding: FragmentPedidosBinding
    val repository = Repository()
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
                var cliente = Clientes(nombre, cantidad, celular, ubicacion)
                repository.agregarPedido(celular,cliente)
                Snackbar.make(it, "Pedido Agregado Correctamente", Snackbar.LENGTH_LONG).show()
//                myRefPedidos.child(nombre).child("datatos").setValue(cliente)
            } else {
                Snackbar.make(it, "LLenar todos los campos correctamente", Snackbar.LENGTH_SHORT).show()

            }

        }




        return binding.root
    }


}