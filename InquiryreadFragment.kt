package com.example.prelim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prelim.data.InquiryViewModel
import com.example.prelim.databinding.FragmentInquiryreadBinding
import kotlinx.android.synthetic.main.fragment_inquiryread.view.*

class InquiryreadFragment : Fragment() {

    private lateinit var mInquiryViewModel: InquiryViewModel

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
        val view = inflater.inflate(R.layout.fragment_inquiryread, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mInquiryViewModel = ViewModelProvider(this).get(InquiryViewModel::class.java)
        mInquiryViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })
        view.backhome.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_inquiryreadFragment_to_homeFragment)
        }
        return view
    }
}
