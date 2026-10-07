package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo11.databinding.FragmentPregunta4P2Binding
import java.util.Locale

class Pregunta4FragmentP2 : Fragment() {

    // Variable privada para ViewBinding
    private var _binding: FragmentPregunta4P2Binding? = null

    // Acceso seguro al binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflamos el XML mediante ViewBinding
        _binding = FragmentPregunta4P2Binding.inflate(
            inflater,
            container,
            false
        )

        // Evento del botón Calcular
        binding.buttonCalcular.setOnClickListener {

            // Obtener el consumo ingresado
            val consumoTexto = binding.editTextConsumo.text.toString()

            // Validar que no esté vacío
            if (consumoTexto.isEmpty()) {

                binding.textViewResultado.text =
                    "Ingrese el consumo energético."

                return@setOnClickListener
            }

            // Convertir el valor a Double
            val consumo = consumoTexto.toDoubleOrNull()

            // Validar que sea un número válido
            if (consumo == null || consumo < 0) {

                binding.textViewResultado.text =
                    "Ingrese un consumo válido."

                return@setOnClickListener
            }

            // Límite libre de sobrecargo
            val limite = 150.0

            // Verificar si supera el límite
            if (consumo <= limite) {

                binding.textViewResultado.text =
                    "Consumo eficiente sin sobrecosto."

            } else {

                // Calcular exceso de consumo
                val exceso = consumo - limite

                // Calcular recargo
                val recargo = 60.0 + (exceso * 1.80)

                // Mostrar resultado con 2 decimales
                binding.textViewResultado.text = String.format(
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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Liberar el binding cuando se destruye la vista
        _binding = null
    }
}