package com.example.unsabordiferente.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unsabordiferente.Clientes
import com.google.firebase.firestore.FirebaseFirestore

class Repository {
    var db = FirebaseFirestore.getInstance()

    var listaClientesPedidos :LiveData<MutableList<Clientes>> = obtenerDatos()
    fun obtenerDatos(): LiveData<MutableList<Clientes>> {
        val mutableData = MutableLiveData<MutableList<Clientes>>()
        db.collection("clientes")
            .whereEqualTo("pedido", true)
            .addSnapshotListener{resultado,e->
                val clientex = mutableListOf<Clientes>()
                for (pedido in resultado!!.documents){
                    var cliente = pedido.toObject(Clientes::class.java)
                    clientex.add(cliente!!)
                }
                mutableData.value = clientex
            }
        return mutableData
    }
}