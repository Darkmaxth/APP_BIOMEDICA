package firebase.app.app_biomedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*

class MonitoreoActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    private lateinit var myAdapter : MyAdapter

    private lateinit var db : FirebaseFirestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoreo)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()



        myAdapter = MyAdapter(userArrayList)


        recyclerView.adapter = myAdapter





        EventChangeListener()

    }

    private fun EventChangeListener(){


        db = FirebaseFirestore.getInstance()



        db.collection("Pacientes").

            addSnapshotListener(object : EventListener<QuerySnapshot> {

                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if(error != null){

                        Log.e("Firestore Error", error.message.toString())
                        return
                    }

                    for(dc : DocumentChange in value?.documentChanges!!){

                        if(dc.type == DocumentChange.Type.ADDED){

                            userArrayList.add(dc.document.toObject(User::class.java))


                        }

                    }


                    myAdapter.notifyDataSetChanged()
                }



             })



//la parte de hacer click
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {


                //Toast.makeText(this@VerActivity, "You clicked on item no ${position} ",Toast.LENGTH_LONG).show()

                val intent = Intent(this@MonitoreoActivity, InformacionActivity::class.java)

                intent.putExtra("dni",userArrayList[position].DNI)
                intent.putExtra("genero",userArrayList[position].Genero)
                intent.putExtra("seguro",userArrayList[position].Tipo_de_Seguro)
                intent.putExtra("celular",userArrayList[position].Celular)
                intent.putExtra("nombre",userArrayList[position].Nombre)
                intent.putExtra("paterno",userArrayList[position].Apellido_Paterno)
                intent.putExtra("materno",userArrayList[position].Apellido_Materno)
                intent.putExtra("civil",userArrayList[position].Estado_Civil)
                intent.putExtra("direccion",userArrayList[position].Direccion)
                intent.putExtra("edad",userArrayList[position].Edad)
                intent.putExtra("peso",userArrayList[position].Peso)
                intent.putExtra("altura",userArrayList[position].Altura)
                intent.putExtra("enfermedad",userArrayList[position].Enfermedad)
                intent.putExtra("estado",userArrayList[position].Estado_de_Salud)

                startActivity(intent)





            }




        })




    }



}