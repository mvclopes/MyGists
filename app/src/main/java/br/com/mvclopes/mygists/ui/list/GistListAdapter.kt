package br.com.mvclopes.mygists.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.mvclopes.mygists.databinding.ListItemBinding
import br.com.mvclopes.mygists.model.Gist

class GistListAdapter: ListAdapter<Gist, GistListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        return GistListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        val gist = getItem(position) as Gist
        holder.bind(gist)
    }
}

class DiffCallback: DiffUtil.ItemCallback<Gist>(){
    override fun areItemsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem.gist == newItem.gist
    }

    override fun areContentsTheSame(oldItem: Gist, newItem: Gist): Boolean {
        return oldItem == newItem
    }

}

class GistListViewHolder private constructor(private val binding: ListItemBinding)
    :RecyclerView.ViewHolder(binding.root) {

    fun bind(gist: Gist){
        binding.gists = gist
        binding.executePendingBindings()
    }

    companion object{
        fun from(parent: ViewGroup): GistListViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(inflater, parent, false)

            return GistListViewHolder(binding)
        }
    }
}
