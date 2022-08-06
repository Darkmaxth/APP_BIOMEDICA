package firebase.app.app_biomedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_paciente.*

class AlertaActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    private lateinit var myAdapter : MyAdapter1

    private lateinit var db : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerta)

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()



        myAdapter = MyAdapter1(userArrayList)


        recyclerView.adapter = myAdapter





        EventChangeListener()


    }

    private fun EventChangeListener(){


        db = FirebaseFirestore.getInstance()



        db.collection("Pacientes").whereEqualTo("Estado_de_Salud", "Critico").

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
        myAdapter.setOnItemClickListener(object : MyAdapter1.onItemClickListener{

            override fun onItemClick(position: Int) {


                //Toast.makeText(this@VerActivity, "You clicked on item no ${position} ",Toast.LENGTH_LONG).show()

                val intent = Intent(this@AlertaActivity, EmergenciaActivity::class.java)
                intent.putExtra("nombre",userArrayList[position].Nombre)

                startActivity(intent)





            }




        })




    }



}