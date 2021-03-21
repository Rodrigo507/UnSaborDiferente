package com.example.unsabordiferente.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        // var currentUser = auth.currentUser

//        if(currentUser!=null){
//            val navController = findNavController()
//            navController.navigate(R.id.menu_fragment)
////            view?.findNavController()?.navigate(LoginDirections.actionLoginToMenu())
////            View.findNavController()!!.navigate(LoginDirections.actionLoginToMenu())
//        }


        binding.btnLogin.setOnClickListener {
            var user = binding.userIdCorreo.text.toString().trim()
            var pswd = binding.userPassword.text.toString().trim()
            Log.i("testLogin", user)
            Log.i("testLogin", pswd)
            if (user != "" && pswd != "") {
                binding.progressCircular.visibility = View.VISIBLE
                FirebaseAuth.getInstance().signInWithEmailAndPassword(user, pswd)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Login Correcto", Toast.LENGTH_SHORT).show()
                            it.findNavController().navigate(LoginDirections.actionLoginToMenu())
                        } else {
                            Toast.makeText(context, "USUARIO INCORRECTO", Toast.LENGTH_LONG).show()
                        }
                        binding.progressCircular.visibility = View.GONE
                    }
            } else {
                Toast.makeText(context, "INGRESE LOS DATOS", Toast.LENGTH_LONG).show()

            }
        }


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        var currentUser = auth.currentUser
        if (currentUser != null) {
            requireView().findNavController().navigate(LoginDirections.actionLoginToMenu())
        }
        Log.i("xd", currentUser.toString())
    }
}