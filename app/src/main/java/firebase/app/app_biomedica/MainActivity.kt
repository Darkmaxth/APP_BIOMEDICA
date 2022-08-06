package firebase.app.app_biomedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_paciente.setOnClickListener{
            val miIntent = Intent(this,PacienteActivity::class.java)
            startActivity(miIntent)
        }

        button_monitoreo.setOnClickListener{
            val miIntent = Intent(this,MonitoreoActivity::class.java)
            startActivity(miIntent)
        }

        button_alerta.setOnClickListener{
            val miIntent = Intent(this,AlertaActivity::class.java)
            startActivity(miIntent)
        }

        button_receta.setOnClickListener{
            val miIntent = Intent(this,RecetasActivity::class.java)
            startActivity(miIntent)
        }



    }



}