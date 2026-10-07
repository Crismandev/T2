package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo11.databinding.ActivityPregunta3Binding
import java.util.Locale

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {
            val dias = binding.etDiasDemora.text.toString().toInt()
            if (dias <= 3) {

                binding.tvResultado.text =
                    "Préstamo regularizado dentro de la prórroga."

            } else {

                val diasCobro = dias - 3
                val multa = 12.00 + (diasCobro * 3.50)
                val multaFormateada =
                    String.format(Locale.US, "S/ %.2f", multa)

                binding.tvResultado.text =
                    "Días de demora: $dias\n" +
                    "Días sujetos a cobro: $diasCobro\n" +
                    "Multa administrativa: $multaFormateada"
            }
        }
    }
}