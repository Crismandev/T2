package pe.edu.cibertec.appgrupo11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo11.databinding.ActivityHomeBinding
import pe.edu.cibertec.appgrupo11.pregunta5.Pregunta5Fragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(Pregunta1Fragment())
        }
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_p1 -> {
                    replaceFragment(Pregunta1Fragment())
                    true
                }
                R.id.nav_p2 -> {
                    replaceFragment(Pregunta4FragmentP2())
                    true
                }
                R.id.nav_p3 -> {
                    replaceFragment(Pregunta5Fragment())
                    true
                }
                R.id.nav_p4 -> {
                    replaceFragment(Pregunta4Fragment())
                    true
                }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}