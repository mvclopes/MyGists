package br.com.mvclopes.mygists.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mvclopes.mygists.databinding.FragmentGistDetailBinding

class GistDetailFragment : Fragment() {

    private lateinit var binding: FragmentGistDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGistDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

}