package br.com.mvclopes.mygists.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import br.com.mvclopes.mygists.R
import br.com.mvclopes.mygists.databinding.FragmentGistDetailBinding

class GistDetailFragment : Fragment() {

    private lateinit var binding: FragmentGistDetailBinding
    private val gistArgs by navArgs<GistDetailFragmentArgs>()

    private val viewModel: GistDetailViewModel by lazy {
        ViewModelProvider(this, GistDetailViewModel.Factory(gistArgs.gistSelected)).get(GistDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGistDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val isStarred: Boolean = viewModel.gist.value!!.isStarred

        binding.iconStar.setOnClickListener {
            viewModel.setStarredGist()
            val isStarred = viewModel.gist.value!!.isStarred
            if (isStarred){
                binding.iconStar.setImageResource(R.drawable.ic_star_full)
            }else{
                binding.iconStar.setImageResource(R.drawable.ic_star_border)
            }
        }

        return binding.root
    }

}