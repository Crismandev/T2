package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo11.adapter.UsuarioAdapter
import pe.edu.cibertec.appgrupo11.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.appgrupo11.model.UsuariosResponse
import pe.edu.cibertec.appgrupo11.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    private lateinit var usuarioAdapter: UsuarioAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Registrar listener del botón utilizando la interfaz View.OnClickListener
        binding.btnCargarUsuarios.setOnClickListener(this)

        configurarRecyclerView()
        obtenerUsuarios()
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCargarUsuarios.id) {
            obtenerUsuarios(esRefrescoManual = true)
        }
    }

    private fun configurarRecyclerView() {
        usuarioAdapter = UsuarioAdapter(emptyList())

        binding.rvUsuarios.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usuarioAdapter
            setHasFixedSize(true)
        }
    }

    private fun obtenerUsuarios(esRefrescoManual: Boolean = false) {
        binding.pbCargando.visibility = View.VISIBLE

        RetrofitClient.usuarioApi.obtenerUsuarios().enqueue(object : Callback<UsuariosResponse> {
            override fun onResponse(
                call: Call<UsuariosResponse>,
                response: Response<UsuariosResponse>
            ) {
                if (isAdded) {
                    binding.pbCargando.visibility = View.GONE
                }
                if (response.isSuccessful) {
                    val usuarios = response.body()?.users.orEmpty()
                    usuarioAdapter.actualizarUsuarios(usuarios)
                    if (esRefrescoManual && isAdded) {
                        Toast.makeText(requireContext(), "Lista de usuarios actualizada con éxito", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    mostrarError("Error al obtener los usuarios: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UsuariosResponse>, t: Throwable) {
                if (isAdded) {
                    binding.pbCargando.visibility = View.GONE
                }
                mostrarError("No se pudo conectar con el servicio: ${t.message}")
            }
        })
    }

    private fun mostrarError(mensaje: String) {
        if (isAdded) {
            Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}