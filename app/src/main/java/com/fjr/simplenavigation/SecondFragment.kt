package com.fjr.simplenavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import androidx.navigation.navOptions
import com.fjr.simplenavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    // private val navGraphVM by viewModels<NavScopeVM2>()


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding?.root


        binding?.textView2?.setOnClickListener {
            if (view != null) {
                // Navigation.findNavController(view).navigate(R.id.firstFragment, null, navOptions {
                //     popUpTo(R.id.firstFragment) {
                //         inclusive = true
                //     }
                // })
                // Navigation.findNavController(view).popBackStack()
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }

        return view
    }
}