package com.example.prelim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.prelim.data.Inquiry
import com.example.prelim.data.InquiryViewModel
import com.example.prelim.databinding.FragmentInquirypostBinding

private lateinit var mInquiryViewModel: InquiryViewModel

class InquirypostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInquirypostBinding>(inflater,
            R.layout.fragment_inquirypost,container,false)

        mInquiryViewModel = ViewModelProvider(this).get(InquiryViewModel::class.java)

        binding.submit.setOnClickListener { view : View ->
            if(binding.inquiry.text.toString().isNotEmpty() && binding.name.text.toString().isNotEmpty()){
                var name = binding.name.text.toString()
                var user_inquiry: String = binding.inquiry.text.toString()
                val inquiry = Inquiry(0,name,user_inquiry)
                mInquiryViewModel.addInquiry(inquiry)
                Toast.makeText(requireContext(), "Inquiry posted!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
            }
        }

        binding.readInquiry.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_inquirypostFragment_to_inquiryreadFragment)
        }
        return binding.root
    }
}