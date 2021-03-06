package br.com.mvclopes.mygists.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.mvclopes.mygists.databinding.FragmentGistListBinding

class GistListFragment : Fragment() {

    private lateinit var binding: FragmentGistListBinding
    private val viewModel: GistListViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(this, GistListViewModel.Factory(activity.application)).get(GistListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGistListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val adapter = GistListAdapter(GistListener {
            it?.let {
               this.findNavController()
                   .navigate(GistListFragmentDirections
                       .actionGistListFragmentToGistDetailFragment(it))
            }
        })

        binding.recyclerGists.adapter = adapter

//      Observer para atualização dos itens do RecyclerView
        viewModel.gist.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })

        return binding.root
    }

}