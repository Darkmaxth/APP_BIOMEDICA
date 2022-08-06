package firebase.app.app_biomedica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter1(private val userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter1.MyViewHolder>(){

    private lateinit var mListener: onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter1.MyViewHolder{

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item1,
            parent,false)

        return  MyViewHolder(itemView, mListener)


    }

    override fun onBindViewHolder(holder: MyAdapter1.MyViewHolder, position: Int){


        val user : User = userList[position]

        holder.Nombre.text = user.Nombre
        holder.Enfermedad.text = user.Enfermedad
        holder.Salud.text = user.Estado_de_Salud

        if(user.Genero.equals("masculino")){

            holder.Imag.setImageResource(R.drawable.ic_hombre!!)
        }
        if(user.Genero.equals("femenino")){

            holder.Imag.setImageResource(R.drawable.ic_mujer!!)
        }

    }
    override fun getItemCount(): Int {


        return userList.size

    }

    public class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){


        val Nombre : TextView = itemView.findViewById(R.id.tvname)
        val Enfermedad : TextView = itemView.findViewById(R.id.tvenfermedad)
        val Salud : TextView = itemView.findViewById(R.id.tvsalud)
        val Imag : ImageView = itemView.findViewById(R.id.tvimagen)




        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)

            }
        }





    }






}