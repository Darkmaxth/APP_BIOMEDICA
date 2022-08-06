package firebase.app.app_biomedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InformacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)


        val dni_new : TextView = findViewById(R.id.mdni)
        val genero_new : TextView = findViewById(R.id.mgenero)
        val seguro_new : TextView = findViewById(R.id.mseguro)
        val celular_new : TextView = findViewById(R.id.mcelular)
        val nombre_new : TextView = findViewById(R.id.mnombre)
        val paterno_new : TextView = findViewById(R.id.mpaterno)
        val materno_new : TextView = findViewById(R.id.mmaterno)
        val civil_new : TextView = findViewById(R.id.mcivil)
        val direccion_new : TextView = findViewById(R.id.mdireccion)
        val edad_new : TextView = findViewById(R.id.medad)
        val peso_new : TextView = findViewById(R.id.mpeso)
        val altura_new : TextView = findViewById(R.id.maltura)
        val enfermedad_new : TextView = findViewById(R.id.menfermedad)
        val salud_new : TextView = findViewById(R.id.msalud)


        val bundle : Bundle?= intent.extras

        val dniy = bundle!!.getString("dni")
        val generoy = bundle!!.getString("genero")
        val seguroy = bundle!!.getString("seguro")
        val celulary = bundle!!.getString("celular")
        val nombrey = bundle!!.getString("nombre")
        val paternoy = bundle!!.getString("paterno")
        val maternoy = bundle!!.getString("materno")
        val civily = bundle!!.getString("civil")
        val direcciony = bundle!!.getString("direccion")
        val edady = bundle!!.getString("edad")
        val pesoy = bundle!!.getString("peso")
        val alturay = bundle!!.getString("altura")
        val enfermedady = bundle!!.getString("enfermedad")
        val saludy = bundle!!.getString("estado")

        dni_new.text = dniy
        genero_new.text =generoy
        seguro_new.text=seguroy
        celular_new.text=celulary
        nombre_new.text=nombrey
        paterno_new.text=paternoy
        materno_new.text=maternoy
        civil_new.text=civily
        direccion_new.text=direcciony
        edad_new.text=edady
        peso_new.text=pesoy
        altura_new.text=alturay
        enfermedad_new.text=enfermedady
        salud_new.text=saludy
    }
}