package daniil.kobitskoy.worktest.cardgamenew.windowFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import daniil.kobitskoy.worktest.cardgamenew.R
import daniil.kobitskoy.worktest.cardgamenew._binding
import daniil.kobitskoy.worktest.cardgamenew.databinding.Window1Binding

class window1 : Fragment() {
    private var binding: Window1Binding? = null
    private val binding1  get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Window1Binding.inflate(inflater,container,false)
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

    fun newInstance() = window1()

}

}
