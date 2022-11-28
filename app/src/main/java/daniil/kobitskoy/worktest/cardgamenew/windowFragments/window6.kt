package daniil.kobitskoy.worktest.cardgamenew.windowFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import daniil.kobitskoy.worktest.cardgamenew.GridAdapter
import daniil.kobitskoy.worktest.cardgamenew.MyDialogFragment
import daniil.kobitskoy.worktest.cardgamenew.R
import daniil.kobitskoy.worktest.cardgamenew._binding
import daniil.kobitskoy.worktest.cardgamenew.databinding.Window5Binding
import daniil.kobitskoy.worktest.cardgamenew.databinding.Window6Binding




private var mGrid: GridView? = null
private var mAdapter: GridAdapter? = null

var GRID_SIZE: Int = 4
class window6 : Fragment() {

    private var binding6: Window6Binding? = null
    private val binding66 get() = binding6!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding6 = Window6Binding.inflate(inflater, container, false)
        return binding66?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding66.imageView.setOnClickListener {
            _binding.containerfragment.visibility = View.GONE
            _binding.linerMain.visibility = View.VISIBLE
        }
        binding66.button.setOnClickListener {
            Log.d("check", "check")

            val myDialogFragment = MyDialogFragment()
myDialogFragment.show(childFragmentManager, myDialogFragment.tag)
        ////            if (myDialogFragment.isAdded){
////                return@setOnClickListener
////            }
//            val manager = parentFragmentManager
//            myDialogFragment.show(manager, "dialog")
//            val transaction: FragmentTransaction = manager.beginTransaction()
//            myDialogFragment.show(transaction, "dialog")


        }
        mGrid = binding66.field as? GridView
        mGrid!!.numColumns = GRID_SIZE
        mGrid!!.isEnabled = true

        mAdapter = GridAdapter(requireContext(), GRID_SIZE, GRID_SIZE)
        mGrid!!.adapter = mAdapter

        mGrid!!.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                mAdapter!!.checkOpenCells()
                if (mAdapter!!.checkGameOver()) Toast.makeText(
                    requireContext(),
                    "Игра закончена",
                    Toast.LENGTH_SHORT
                ).show()



            }

    }
    companion object {

        fun newInstance() = window6()

    }
}