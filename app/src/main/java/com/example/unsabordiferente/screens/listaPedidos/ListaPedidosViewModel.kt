package com.example.unsabordiferente.screens.listaPedidos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.network.Repository

class ListaPedidosViewModel : ViewModel() {
    val repository = Repository()
    private val _listasPedidos = MutableLiveData<MutableList<Clientes>>()
    val listasPedidos: LiveData<MutableList<Clientes>>
        get() = _listasPedidos

    init {
        Log.i("debug", "ViewModelStart")
        xd()
    }


    private fun xd() {
        repository.listaClientesPedidos.observeForever {
            _listasPedidos.postValue(it)
//            for (x in it) {
//                Log.i("lista", x.nombre)
//            }
        }
    }
}