package com.example.unsabordiferente.screens.listaPedidos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.network.Repository
import kotlinx.coroutines.launch

class ListaPedidosViewModel : ViewModel() {
    val repository = Repository()
    private val _listasPedidos = MutableLiveData<MutableList<Clientes>>()
    val listasPedidos: LiveData<MutableList<Clientes>>
        get() = _listasPedidos

    init {
        Log.i("debug", "ViewModelStart")
        obtenerListaPedidos()
    }

    //Obtenemos del repository la lista de pedidos
    private fun obtenerListaPedidos() {
        viewModelScope.launch {
            repository.listaClientesPedidos.observeForever {
                _listasPedidos.postValue(it)
            }
        }
    }
}