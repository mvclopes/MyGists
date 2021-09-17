package br.com.mvclopes.mygists.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import br.com.mvclopes.mygists.R
import br.com.mvclopes.mygists.model.Gist

class GistListAdapter(private val gistList: LiveData<MutableList<Gist>>) : RecyclerView.Adapter<GistListAdapter.GistListViewHolder>() {

    class GistListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //Referência aos campos inseridos no layout exibido no Recycler View
        val txtNameOwner : TextView = itemView.findViewById(R.id.txt_name_owner)
        val txtTypeGist : TextView = itemView.findViewById(R.id.txt_type_gist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return GistListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        val currentItem = gistList.value?.get(position)

        if (currentItem != null) {
            holder.txtNameOwner.text = currentItem.name
            holder.txtTypeGist.text = currentItem.gistType
        }
    }

    override fun getItemCount(): Int {
        return gistList.value?.size ?: 0
    }
}