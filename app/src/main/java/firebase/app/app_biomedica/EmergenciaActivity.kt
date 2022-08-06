package firebase.app.app_biomedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_emergencia.*

class EmergenciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergencia)

        val bundle : Bundle?= intent.extras

        val nombrez = bundle!!.getString("nombre")

        button_ambulancia.setOnClickListener{

            Toast.makeText(this,"Solicitando Ambulancia al paciente ${nombrez}", Toast.LENGTH_LONG).show()

        }

        button_ubicacion.setOnClickListener{


            Toast.makeText(this,"Obteniendo Ubicacion actual del paciente ${nombrez}", Toast.LENGTH_LONG).show()




        }

    }
}