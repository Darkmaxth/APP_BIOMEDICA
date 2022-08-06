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
            val xedad = addEdad.text.toString()
            val xdni = addDNIPaciente.text.toString()
            val xseguro = addSeguroPaciente.text.toString()
            val xcelular= addCelularPaciente.text.toString()
            val xnombre = addNombrePaciente.text.toString()
            val xmaterno= addMaternoPaciente.text.toString()
            val xpaterno = addPaternoPaciente.text.toString()
            val xcivil= addCivilPaciente.text.toString()
            val xdireccion= addDireccionPaciente.text.toString()
            val xpeso = addPesoPaciente.text.toString()
            val xaltura = addAlturaPaciente.text.toString()
            val xenfermedad= addEnfermedadPaciente.text.toString()
            val xsalud = addSaludPaciente.text.toString()
            val xgenero= addGeneroPaciente.text.toString()



            guardarPaciente(xedad, xdni,xseguro,xcelular,xnombre,xmaterno,xpaterno,xcivil,xdireccion,xpeso,xaltura,xenfermedad,xsalud,xgenero)

        }
    }

    private fun guardarPaciente(
        xedad: String,
        xdni: String,
        xseguro: String,
        xcelular: String,
        xnombre: String,
        xmaterno: String,
        xpaterno: String,
        xcivil: String,
        xdireccion: String,
        xpeso: String,
        xaltura: String,
        xenfermedad: String,
        xsalud: String,
        xgenero: String
    ) {

        var datosinsertar = hashMapOf(

            "Nombre" to xnombre,
            "Apellido_Paterno" to xpaterno,
            "Apellido_Materno" to xmaterno,
            "DNI" to xdni,
            "Tipo_de_Seguro" to xseguro,
            "Celular" to xcelular,
            "Estado_Civil" to xcivil,
            "Direccion" to xdireccion,
            "Peso" to xpeso,
            "Altura" to xaltura,
            "Enfermedad" to xenfermedad,
            "Edad" to xedad,
            "Estado_de_Salud" to xsalud,
            "Genero" to xgenero
        )




        db.collection("Pacientes").document(xdni).set(datosinsertar)
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
                addEdad.setText("")
                addGeneroPaciente.setText("")
            }


///
    }



}