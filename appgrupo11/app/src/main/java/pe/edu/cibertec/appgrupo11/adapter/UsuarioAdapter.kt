package pe.edu.cibertec.appgrupo11.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo11.databinding.ItemUsuarioBinding
import pe.edu.cibertec.appgrupo11.model.Usuario

class UsuarioAdapter(
    private var usuarios: List<Usuario>
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemUsuarioBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size

    fun actualizarUsuarios(nuevosUsuarios: List<Usuario>) {
        usuarios = nuevosUsuarios
        notifyDataSetChanged()
    }

    class UsuarioViewHolder(
        private val binding: ItemUsuarioBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(usuario: Usuario) {
            binding.tvId.text = "ID: ${usuario.id}"
            binding.tvNombre.text = "${usuario.firstName} ${usuario.lastName}"
            binding.tvEmail.text = "Email: ${usuario.email}"
            binding.tvPhone.text = "Phone: ${usuario.phone}"
        }
    }
}
