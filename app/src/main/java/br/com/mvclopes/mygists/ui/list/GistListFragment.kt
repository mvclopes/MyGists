package br.com.mvclopes.mygists.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.mvclopes.mygists.databinding.FragmentGistListBinding

class GistListFragment : Fragment() {

    private lateinit var binding: FragmentGistListBinding
    private val viewModel: GistListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGistListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

}