package br.com.mvclopes.mygists.ui.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.mvclopes.mygists.databinding.FragmentGistStarredBinding
import br.com.mvclopes.mygists.ui.list.GistListAdapter
import br.com.mvclopes.mygists.ui.list.GistListFragmentDirections
import br.com.mvclopes.mygists.ui.list.GistListViewModel
import br.com.mvclopes.mygists.ui.list.GistListener

class GistStarredFragment : Fragment() {

    private lateinit var binding: FragmentGistStarredBinding
    private val viewModel: GistStarredViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(this, GistStarredViewModel.Factory(activity.application)).get(
            GistStarredViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGistStarredBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        val adapter = GistListAdapter(GistListener {
            it?.let {
                this.findNavController()
                    .navigate(
                        GistStarredFragmentDirections
                        .actionGistStarredFragmentToGistDetailFragment(it))
            }
        })

        binding.recyclerGists.adapter = adapter

//      Observer para atualização dos itens do RecyclerView
        viewModel.gistStarred.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })

        return binding.root
    }

}