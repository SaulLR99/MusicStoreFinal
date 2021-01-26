package com.example.musicstore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_registry.*

class Registry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        val btnRegistrar1 = findViewById<Button>(R.id.btnRegistrar3)


        btnRegistrar1.setOnClickListener {
            if (editNombre.text.isNotEmpty() && editApellidoP.text.isNotEmpty() && editApellidoM.text.isNotEmpty() && editEdad.text.isNotEmpty() && editSexo.text.isNotEmpty() && editCorreoE.text.isNotEmpty() && editPass.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(editCorreoE.text.toString(),
                    editPass.text.toString()).addOnCompleteListener {

                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }

            if (editNombre.text.isEmpty()) {
                Toast.makeText(this, "Debe ingresar su nombre", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (editApellidoP.text.isEmpty()) {
                Toast.makeText(this, "Debe ingresar su apellido paterno", Toast.LENGTH_LONG)
                        .show()
                return@setOnClickListener
            }

            if (editApellidoM.text.isEmpty()) {
                Toast.makeText(this, "Debe ingresar su apellido materno", Toast.LENGTH_LONG)
                        .show()
                return@setOnClickListener
            }

            if (editEdad.text.isEmpty()) {
                Toast.makeText(this, "Debe ingresar su edad", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (editSexo.text.isEmpty()) {
                Toast.makeText(this, "Debe ingresar su sexo", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (editCorreoE.text.isEmpty()) {
                Toast.makeText(this, "Debe definir su correo electrónico", Toast.LENGTH_LONG)
                        .show()
                return@setOnClickListener
            }

            if (editPass.text.isEmpty()) {
                Toast.makeText(this, "Debe definir su contraseña", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}