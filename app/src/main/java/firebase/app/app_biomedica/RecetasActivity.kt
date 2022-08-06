package firebase.app.app_biomedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_paciente.*
import kotlinx.android.synthetic.main.activity_recetas.*

class RecetasActivity : AppCompatActivity() {
    var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas)

        buttonAgregarReceta.setOnClickListener{
            val qdni = recetadni.text.toString()
            val qnombre = recetanombre.text.toString()
            val qpaterno = recetapaterno.text.toString()
            val qmaterno = recetamaterno.text.toString()
            val qreceta = recetareceta.text.toString()

            agregarReceta(qdni,qnombre,qpaterno,qmaterno,qreceta)



        }
    }

    private fun agregarReceta(qdni: String, qnombre: String, qpaterno: String, qmaterno: String, qreceta: String) {

        var datosinsertar = hashMapOf(

            "DNI" to qdni,
            "Nombre" to qnombre,
            "Apellido_Paterno" to qpaterno,
            "Apellido_Materno" to qmaterno,
            "Receta_Medica" to qreceta

        )


        db.collection("Recetas_Medicas").document(qdni).set(datosinsertar)
            .addOnSuccessListener {
                Toast.makeText(this,"Se agrego correctamente la receta", Toast.LENGTH_LONG).show()
                recetadni.setText("")
                recetanombre.setText("")
                recetapaterno.setText("")
                recetamaterno.setText("")
                recetareceta.setText("")

            }

    }
}