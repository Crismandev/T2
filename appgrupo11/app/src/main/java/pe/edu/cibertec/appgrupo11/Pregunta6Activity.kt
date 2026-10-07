package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo11.adapter.UsuarioAdapter
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta6Binding
import pe.edu.cibertec.appgrupo11.model.Usuario
import pe.edu.cibertec.appgrupo11.model.UsuariosResponse
import pe.edu.cibertec.appgrupo11.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPregunta6Binding
    private lateinit var usuarioAdapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configurarRecyclerView()
        obtenerUsuarios()
    }

    private fun configurarRecyclerView() {
        usuarioAdapter = UsuarioAdapter(emptyList())

        binding.rvUsuarios.apply {
            layoutManager = LinearLayoutManager(this@Pregunta6Activity)
            adapter = usuarioAdapter
            setHasFixedSize(true)
        }
    }

    private fun obtenerUsuarios() {
        RetrofitClient.usuarioApi.obtenerUsuarios().enqueue(object : Callback<UsuariosResponse> {
            override fun onResponse(
                call: Call<UsuariosResponse>,
                response: Response<UsuariosResponse>
            ) {
                if (response.isSuccessful) {
                    usuarioAdapter.actualizarUsuarios(response.body()?.users.orEmpty())
                } else {
                    mostrarError("Error al obtener los usuarios: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UsuariosResponse>, t: Throwable) {
                mostrarError("No se pudo conectar con el servicio")
            }
        })
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}
