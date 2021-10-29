package com.fjr.simplenavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
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
                findNavController().navigate(
                    FirstFragmentDirections
                        .actionFirstFragmentToSecondFragment()
                )
            }
        }

        // We use a String here, but any type that can be put in a Bundle is supported
        // findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("key")
        //     ?.observe(
        //         viewLifecycleOwner
        //     ) { result ->
        //         // Do something with the result.
        //         Log.e("TAG", "ini hasil dari previous fragment $result")
        //     }

        val navBackStackEntry = findNavController().currentBackStackEntry
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME
                && navBackStackEntry?.savedStateHandle?.contains("key") == true
            ) {
                val result = navBackStackEntry?.savedStateHandle?.get<String>("key");
                Toast.makeText(requireContext(), "ini hasil dari previous fragment $result",
                    Toast.LENGTH_SHORT).show()
            }
        }
        navBackStackEntry?.lifecycle?.addObserver(observer)

        viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                navBackStackEntry?.lifecycle?.removeObserver(observer)
            }
        })

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}