package pe.edu.cibertec.appgrupo11.network

import pe.edu.cibertec.appgrupo11.model.UsuariosResponse
import retrofit2.Call
import retrofit2.http.GET

interface UsuarioApi {

    @GET("users")
    fun obtenerUsuarios(): Call<UsuariosResponse>
}
