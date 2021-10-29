package com.fjr.simplenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.fjr.simplenavigation.databinding.FragmentSecondBinding
import com.fjr.simplenavigation.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val view = binding?.root

        binding?.textView3?.setOnClickListener {
            //ini jika mw langsung popback stack ke root bisa pakai ini
            val navBackStackEntry = findNavController().getBackStackEntry(R.id.firstFragment)
            navBackStackEntry.savedStateHandle.set("key", "getBackStackEntry")
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}