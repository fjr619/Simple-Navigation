package com.fjr.simplenavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.navArgument
import androidx.navigation.navGraphViewModels
import com.fjr.simplenavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    // private val navGraphVM by viewModels<NavScopeVM>()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        val view = binding?.root

        binding?.textView?.setOnClickListener {
            if (view != null) {
                Navigation.findNavController(view).navigate(FirstFragmentDirections
                    .actionFirstFragmentToSecondFragment())
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}