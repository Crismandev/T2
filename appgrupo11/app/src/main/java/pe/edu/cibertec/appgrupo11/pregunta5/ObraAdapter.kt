package pe.edu.cibertec.appgrupo11.pregunta5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo11.databinding.ItemObraBinding

class ObraAdapter(private val listaObras: List<Obra>) :
    RecyclerView.Adapter<ObraAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemObraBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemObraBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listaObras[position]) {
                binding.tvTitulo.text = titulo
                binding.tvAutor.text = autor

                Glide.with(itemView.context)
                    .load(urlImagen)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_report_image)
                    .into(binding.ivObra)
            }
        }
    }

    override fun getItemCount(): Int {
        return listaObras.size
    }
}
