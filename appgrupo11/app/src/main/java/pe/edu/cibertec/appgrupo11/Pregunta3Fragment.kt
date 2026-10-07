package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo11.databinding.FragmentPregunta3Binding
import pe.edu.cibertec.appgrupo11.pregunta5.Obra
import pe.edu.cibertec.appgrupo11.pregunta5.ObraAdapter

class Pregunta3Fragment : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)

        binding.rvObras.layoutManager = LinearLayoutManager(requireContext())
        binding.rvObras.adapter = ObraAdapter(getObras())

        return binding.root
    }

    private fun getObras(): List<Obra> {
        return listOf(
            Obra(1, "La ciudad y los perros", "Mario Vargas Llosa", "https://picsum.photos/seed/obra01/300/400"),
            Obra(2, "La casa verde", "Mario Vargas Llosa", "https://picsum.photos/seed/obra02/300/400"),
            Obra(3, "Conversación en La Catedral", "Mario Vargas Llosa", "https://picsum.photos/seed/obra03/300/400"),
            Obra(4, "Pantaleón y las visitadoras", "Mario Vargas Llosa", "https://picsum.photos/seed/obra04/300/400"),
            Obra(5, "La tía Julia y el escribidor", "Mario Vargas Llosa", "https://picsum.photos/seed/obra05/300/400"),
            Obra(6, "Yawar fiesta", "José María Arguedas", "https://picsum.photos/seed/obra06/300/400"),
            Obra(7, "Los ríos profundos", "José María Arguedas", "https://picsum.photos/seed/obra07/300/400"),
            Obra(8, "Todas las sangres", "José María Arguedas", "https://picsum.photos/seed/obra08/300/400"),
            Obra(9, "El zorro de arriba y el zorro de abajo", "José María Arguedas", "https://picsum.photos/seed/obra09/300/400"),
            Obra(10, "Los heraldos negros", "César Vallejo", "https://picsum.photos/seed/obra10/300/400"),
            Obra(11, "Trilce", "César Vallejo", "https://picsum.photos/seed/obra11/300/400"),
            Obra(12, "Poemas humanos", "César Vallejo", "https://picsum.photos/seed/obra12/300/400"),
            Obra(13, "La serpiente de oro", "Ciro Alegría", "https://picsum.photos/seed/obra13/300/400"),
            Obra(14, "Los perros hambrientos", "Ciro Alegría", "https://picsum.photos/seed/obra14/300/400"),
            Obra(15, "El mundo es ancho y ajeno", "Ciro Alegría", "https://picsum.photos/seed/obra15/300/400"),
            Obra(16, "Tradiciones peruanas", "Ricardo Palma", "https://picsum.photos/seed/obra16/300/400"),
            Obra(17, "La palabra del mudo", "Julio Ramón Ribeyro", "https://picsum.photos/seed/obra17/300/400"),
            Obra(18, "Los gallinazos sin plumas", "Julio Ramón Ribeyro", "https://picsum.photos/seed/obra18/300/400"),
            Obra(19, "Ese puerto existe", "Blanca Varela", "https://picsum.photos/seed/obra19/300/400"),
            Obra(20, "Canto villano", "Blanca Varela", "https://picsum.photos/seed/obra20/300/400")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvObras.adapter = null
        _binding = null
    }
}