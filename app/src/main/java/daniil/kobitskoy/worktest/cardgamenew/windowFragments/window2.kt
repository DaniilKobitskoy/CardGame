package daniil.kobitskoy.worktest.cardgamenew.windowFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import daniil.kobitskoy.worktest.cardgamenew._binding

import daniil.kobitskoy.worktest.cardgamenew.databinding.Window2Binding


class window2 : Fragment() {
    private var binding: Window2Binding? = null
    private val binding1  get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Window2Binding.inflate(inflater,container,false)
        return binding1?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1.imageView.setOnClickListener {
            _binding.containerfragment.visibility = View.GONE
            _binding.linerMain.visibility = View.VISIBLE
        }
    }
    companion object{

        fun newInstance() = window2()

    }
}