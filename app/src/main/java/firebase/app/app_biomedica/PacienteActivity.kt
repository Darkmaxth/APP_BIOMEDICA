package firebase.app.app_biomedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_paciente.*

class PacienteActivity : AppCompatActivity() {

    var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        buttonAgregar.setOnClickListener{

            val naddDNIPaciente = addDNIPaciente.text.toString()
            val naddSeguroPaciente = addSeguroPaciente.text.toString()
            val naddCelularPaciente= addCelularPaciente.text.toString()
            val naddNombrePaciente = addNombrePaciente.text.toString()
            val naddMaternoPaciente = addMaternoPaciente.text.toString()
            val naddPaternoPaciente = addPaternoPaciente.text.toString()
            val naddCivilPaciente = addCivilPaciente.text.toString()
            val naddDireccionPaciente= addDireccionPaciente.text.toString()
            val naddPesoPaciente = addPesoPaciente.text.toString()
            val naddAlturaPaciente = addAlturaPaciente.text.toString()
            val naddEnfermedadPaciente = addEnfermedadPaciente.text.toString()
            val naddSaludPaciente = addSaludPaciente.text.toString()
            val naddGeneroPaciente = addGeneroPaciente.text.toString()


            guardarPaciente(naddDNIPaciente,naddSeguroPaciente,naddCelularPaciente,naddNombrePaciente,
                naddMaternoPaciente,naddPaternoPaciente,naddCivilPaciente,naddDireccionPaciente,
                naddPesoPaciente,naddAlturaPaciente,naddEnfermedadPaciente,naddSaludPaciente,naddGeneroPaciente )

        }
    }


    private fun guardarPaciente(
        naddDNIPaciente: String,
        naddSeguroPaciente: String,
        naddCelularPaciente: String,
        naddNombrePaciente: String,
        naddMaternoPaciente: String,
        naddPaternoPaciente: String,
        naddCivilPaciente: String,
        naddDireccionPaciente: String,
        naddPesoPaciente: String,
        naddAlturaPaciente: String,
        naddEnfermedadPaciente: String,
        naddSaludPaciente: String,
        naddGeneroPaciente: String,
        ) {


        var datosinsertar = hashMapOf(
            "Nombre" to naddNombrePaciente,
            "Apellido_Paterno"   to naddPaternoPaciente,
            "Apellido_Materno" to naddMaternoPaciente,
            "DNI" to naddDNIPaciente,
            "Tipo_de_Seguro" to naddSeguroPaciente,
            "Celular" to naddCelularPaciente,
            "Estado_Civil" to naddCivilPaciente,
            "Direccion" to naddDireccionPaciente,
            "Peso" to naddPesoPaciente,
            "Altura" to naddAlturaPaciente,
            "Enfermedad" to naddEnfermedadPaciente,
            "Estado_de_Salud" to naddSaludPaciente,
            "Genero" to  naddGeneroPaciente
        )

        db.collection("Pacientes").document(naddDNIPaciente).set(datosinsertar)
            .addOnSuccessListener {
                Toast.makeText(this,"Se agrego correctamente", Toast.LENGTH_LONG).show()
                addDNIPaciente.setText("")
                addSeguroPaciente.setText("")
                addCelularPaciente.setText("")
                addNombrePaciente.setText("")
                addMaternoPaciente.setText("")
                addPaternoPaciente.setText("")
                addCivilPaciente.setText("")
                addDireccionPaciente.setText("")
                addPesoPaciente.setText("")
                addAlturaPaciente.setText("")
                addEnfermedadPaciente.setText("")
                addSaludPaciente.setText("")
                addGeneroPaciente.setText("")
            }





    }
}