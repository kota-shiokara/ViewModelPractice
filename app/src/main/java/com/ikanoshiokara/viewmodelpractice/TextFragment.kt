package com.ikanoshiokara.viewmodelpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ikanoshiokara.viewmodelpractice.databinding.FragmentTextBinding

class TextFragment : Fragment() {
    private lateinit var binding: FragmentTextBinding

    private val viewModel = TextViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_text, container, false)
        binding.textViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            val text = binding.editText.text.toString()
            viewModel.submitText(text)
        }
    }
}