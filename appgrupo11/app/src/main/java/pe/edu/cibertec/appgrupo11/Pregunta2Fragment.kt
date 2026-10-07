package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo11.databinding.FragmentPregunta2Binding
import java.util.Locale

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCalcular.id) {
            calcularConsumoEnergia()
        }
    }

    private fun calcularConsumoEnergia() {
        val consumoStr = binding.etConsumo.text.toString().trim()
        if (consumoStr.isEmpty()) {
            Toast.makeText(requireContext(), "Ingrese el consumo energético.", Toast.LENGTH_SHORT).show()
            return
        }

        val consumo = consumoStr.toDoubleOrNull()
        if (consumo == null || consumo < 0) {
            Toast.makeText(requireContext(), "Ingrese un consumo válido.", Toast.LENGTH_SHORT).show()
            return
        }

        val limite = 150.0
        if (consumo <= limite) {
            binding.tvResultado.text = "Consumo eficiente sin sobrecosto."
        } else {
            val exceso = consumo - limite
            val recargo = 60.0 + (exceso * 1.80)

            binding.tvResultado.text = String.format(
                Locale.US,
                "Consumo ingresado: %.2f kWh\n\n" +
                        "Exceso: %.2f kWh\n\n" +
                        "Monto total a pagar por recargo: S/ %.2f",
                consumo,
                exceso,
                recargo
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}