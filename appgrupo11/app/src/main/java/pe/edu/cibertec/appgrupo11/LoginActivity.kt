package pe.edu.cibertec.appgrupo11

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta1Binding
import pe.edu.cibertec.appgrupo11.pregunta1.Usuario

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    private val usuariosMock = listOf(
        Usuario(identificador = "Admin", contrasena = "12345678"),
        Usuario(identificador = "i201710756", contrasena = "72775974"),
        Usuario(identificador = "i202311030", contrasena = "12345678"),
        Usuario(identificador = "i202335548", contrasena = "12345678"),
        Usuario(identificador = "I201710829", contrasena = "12345678"),
        Usuario(identificador = "I202407865", contrasena = "12345678"),
        Usuario(identificador = "i201522893", contrasena = "12345678"),
        Usuario(identificador = "i202506392", contrasena = "12345678")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == binding.btnIngresar.id) {
            ejecutarLogin()
        }
    }

    private fun ejecutarLogin() {
        val inputUsuario = binding.etUsuario.text.toString().trim()
        val inputContrasena = binding.etContrasena.text.toString().trim()

        if (inputUsuario.isBlank() || inputContrasena.isBlank()) {
            Toast.makeText(this, "Las credenciales no pueden estar vacías ni contener solo espacios.", Toast.LENGTH_SHORT).show()
            return
        }

        if (credencialesSonValidas(inputUsuario, inputContrasena)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Credenciales incorrectas o usuario no registrado.", Toast.LENGTH_LONG).show()
        }
    }

    private fun credencialesSonValidas(usuario: String, contrasena: String): Boolean {
        return usuariosMock.any { 
            it.identificador.equals(usuario, ignoreCase = true) && it.contrasena == contrasena 
        }
    }
}
