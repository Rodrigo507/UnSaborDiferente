package com.example.unsabordiferente.screens.recursos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.unsabordiferente.Huevos
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentRecursosBinding
import com.example.unsabordiferente.network.Repository
import java.text.SimpleDateFormat
import java.util.*

class RecursosFragment : Fragment() {
    private lateinit var binding: FragmentRecursosBinding
    private lateinit var huevosRecolectado: Huevos
    private var cantidadHuevosNuevos = 0
    val sdf = SimpleDateFormat("dd-M-yyyy")
    var fecha: String = sdf.format(Date())
    val repository = Repository()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recursos, container, false)
        binding.btnAgregarRecursoFragment.setOnClickListener {
            if (binding.nuevosHuevos.text.isNotEmpty()) {
                cantidadHuevosNuevos = binding.nuevosHuevos.text.toString().toIntOrNull() ?: 0
                huevosRecolectado = Huevos(fecha,cantidadHuevosNuevos)
                repository.agregarRecurso(huevosRecolectado)
            }
        }

        return binding.root
    }


}