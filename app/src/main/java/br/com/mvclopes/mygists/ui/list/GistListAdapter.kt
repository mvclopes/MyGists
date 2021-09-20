package br.com.mvclopes.mygists.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.mvclopes.mygists.databinding.ListItemBinding
import br.com.mvclopes.mygists.model.GistItem

class GistListAdapter(private val clickListener: GistListener): ListAdapter<GistItem, GistListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        return GistListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        val gist = getItem(position) as GistItem
        holder.bind(clickListener, gist)
    }
}

class GistListener(val clickListener: (gist: GistItem) -> Unit) {
    fun onClick(gist: GistItem) = clickListener(gist)
}

class DiffCallback: DiffUtil.ItemCallback<GistItem>(){
    override fun areItemsTheSame(oldItem: GistItem, newItem: GistItem): Boolean {
        return oldItem.owner == newItem.owner
    }

    override fun areContentsTheSame(oldItem: GistItem, newItem: GistItem): Boolean {
        return oldItem == newItem
    }

}

class GistListViewHolder private constructor(private val binding: ListItemBinding)
    :RecyclerView.ViewHolder(binding.root) {

    fun bind(clickListener: GistListener, gist: GistItem){
        binding.gists = gist
        binding.clickListener = clickListener
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
