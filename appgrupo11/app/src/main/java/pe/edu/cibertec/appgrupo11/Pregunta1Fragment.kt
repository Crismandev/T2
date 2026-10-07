package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo11.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCalcular.id) {
            calcularConsumoAgua()
        }
    }

    private fun calcularConsumoAgua() {
        val consumoStr = binding.etConsumo.text.toString().trim()
        if (consumoStr.isEmpty()) {
            Toast.makeText(requireContext(), "Por favor ingrese el volumen consumido.", Toast.LENGTH_SHORT).show()
            return
        }

        val consumo = consumoStr.toDoubleOrNull()
        if (consumo == null || consumo < 0) {
            Toast.makeText(requireContext(), "Ingrese un volumen válido.", Toast.LENGTH_SHORT).show()
            return
        }

        if (consumo <= 20.0) {
            binding.tvResultado.text = "Consumo dentro de la asignación regular."
        } else {
            val exceso = consumo - 20.0
            val recargo = 45.00 + (exceso * 8.50)
            val recargoFormateado = String.format(Locale.US, "S/ %.2f", recargo)

            binding.tvResultado.text = "Volumen consumido: ${String.format(Locale.US, "%.2f", consumo)} m³\n\n" +
                    "Exceso: ${String.format(Locale.US, "%.2f", exceso)} m³\n\n" +
                    "Monto total del recargo: $recargoFormateado"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}