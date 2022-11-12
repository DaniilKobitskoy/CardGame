package daniil.kobitskoy.testwork.cardgame

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private var mGrid: GridView? = null
private var mAdapter: GridAdapter? = null

var GRID_SIZE = 4


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mGrid = findViewById<View>(R.id.field) as GridView
        mGrid!!.setNumColumns(GRID_SIZE)
        mGrid!!.setEnabled(true)

        mAdapter = GridAdapter(this, GRID_SIZE, GRID_SIZE)
        mGrid!!.setAdapter(mAdapter)

        mGrid!!.setOnItemClickListener(OnItemClickListener { parent, v, position, id ->
            mAdapter!!.checkOpenCells()
            mAdapter!!.openCell(position)
            if (mAdapter!!.checkGameOver()) Toast.makeText(
                applicationContext,
                "Игра закончена",
                Toast.LENGTH_SHORT
            ).show()
        })



    }
}