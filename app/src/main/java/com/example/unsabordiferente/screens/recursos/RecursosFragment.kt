package com.example.unsabordiferente.screens.recursos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentRecursosBinding

class RecursosFragment : Fragment() {
    private lateinit var binding: FragmentRecursosBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recursos, container, false)


        return binding.root
    }


}