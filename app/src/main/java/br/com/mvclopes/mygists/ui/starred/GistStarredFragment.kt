package br.com.mvclopes.mygists.ui.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mvclopes.mygists.databinding.FragmentGistStarredBinding

class GistStarredFragment : Fragment() {

    private lateinit var binding: FragmentGistStarredBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGistStarredBinding.inflate(inflater, container, false)

        return binding.root
    }

}