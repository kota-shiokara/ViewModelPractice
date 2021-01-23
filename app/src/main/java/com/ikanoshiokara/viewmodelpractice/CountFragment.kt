package com.ikanoshiokara.viewmodelpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ikanoshiokara.viewmodelpractice.databinding.FragmentCountBinding

class CountFragment : Fragment() {
    private val cViewModel: CountViewModel by viewModels()
    private lateinit var binding: FragmentCountBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_count, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = cViewModel
        cViewModel.initScore()
        binding.root.setOnClickListener{
            Log.d("click", "Click")
            cViewModel.score.value = Integer.parseInt(cViewModel.score.value.toString()) + 1
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cViewModel.score.observe(viewLifecycleOwner, Observer {
            binding.countText.text = it.toString()
        })
    }

}