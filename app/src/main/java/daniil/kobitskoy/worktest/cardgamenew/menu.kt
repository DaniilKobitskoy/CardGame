package daniil.kobitskoy.worktest.cardgamenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import daniil.kobitskoy.worktest.cardgamenew.databinding.ActivityMainBinding
import daniil.kobitskoy.worktest.cardgamenew.databinding.ActivityMenuBinding
import daniil.kobitskoy.worktest.cardgamenew.windowFragments.*

lateinit var _binding: ActivityMenuBinding

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.egipetbutton1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window1.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
_binding.containerfragment.visibility = View.VISIBLE

        }
        _binding.egipetbutton2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window2.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
            _binding.containerfragment.visibility = View.VISIBLE

        }
        _binding.egipetbutton3.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window3.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
            _binding.containerfragment.visibility = View.VISIBLE

        }
        _binding.egipetbutton4.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window4.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
            _binding.containerfragment.visibility = View.VISIBLE

        }
        _binding.egipetbutton5.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window5.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
            _binding.containerfragment.visibility = View.VISIBLE

        }
        _binding.egipetbutton6.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerfragment, window6.newInstance())
                .commit()
            _binding.linerMain.visibility = View.GONE
            _binding.containerfragment.visibility = View.VISIBLE

        }
    }

}