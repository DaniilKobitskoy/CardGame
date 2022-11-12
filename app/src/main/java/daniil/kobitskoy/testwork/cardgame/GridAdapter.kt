package daniil.kobitskoy.testwork.cardgame

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import java.util.*


internal class GridAdapter(
    private val mContext: Context,
    private val mCols: Int,
    private val mRows: Int
) :
    BaseAdapter() {
    private val arrPict // массив картинок
            : ArrayList<String?> = ArrayList()
    private val PictureCollection // Префикс набора картинок
            : String = "animal"
    private val mRes // Ресурсы приложени
            : Resources = mContext.resources

    private enum class Status {
        CELL_OPEN, CELL_CLOSE, CELL_DELETE
    }

    private val arrStatus // состояние ячеек
            : ArrayList<Status> = ArrayList()

    init {

        // Пока определяем префикс так, позже он будет браться из настроек

        // Получаем все ресурсы приложения

        // Метод заполняющий массив vecPict
        makePictArray()

        // Метод устанавливающий всем ячейкам статус CELL_CLOSE
        closeAllCells()
    }

    private fun makePictArray() {
        // очищаем вектор
        arrPict.clear()
        // добавляем
        for (i in 0 until mCols * mRows / 2) {
            arrPict.add(PictureCollection + Integer.toString(i))
            arrPict.add(PictureCollection + Integer.toString(i))
        }
        // перемешиваем
        Collections.shuffle(arrPict)
    }

    private fun closeAllCells() {
        arrStatus.clear()
        for (i in 0 until mCols * mRows) arrStatus.add(Status.CELL_CLOSE)
    }

    override fun getCount(): Int {
        return mCols * mRows
    }

    override fun getItem(position: Int): Any? {
        // TODO Auto-generated method stub
        return null
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: ImageView =
            if (convertView == null) ImageView(mContext) else convertView as ImageView // выводиться у нас будет картинка
        when (arrStatus[position]) {
            Status.CELL_OPEN -> {
                // Получаем идентификатор ресурса для картинки, которая находится в векторе vecPict на позиции position
                val drawableId =
                    mRes.getIdentifier(arrPict[position], "drawable", mContext.packageName)
                view.setImageResource(drawableId)
            }
            Status.CELL_CLOSE -> view.setImageResource(R.drawable.closecard)
            else -> view.setImageResource(R.drawable.delete)
        }
        return view
    }

    fun checkOpenCells() {
        val first = arrStatus.indexOf(Status.CELL_OPEN)
        val second = arrStatus.lastIndexOf(Status.CELL_OPEN)
        if (first == second) return
        if (arrPict[first] == arrPict[second]) {
            arrStatus[first] = Status.CELL_DELETE
            arrStatus[second] = Status.CELL_DELETE
        } else {
            arrStatus[first] = Status.CELL_CLOSE
            arrStatus[second] = Status.CELL_CLOSE
        }
        return
    }

    fun openCell(position: Int) {
        if (arrStatus[position] != Status.CELL_DELETE) arrStatus[position] = Status.CELL_OPEN
        notifyDataSetChanged()
        return
    }

    fun checkGameOver(): Boolean {
        return arrStatus.indexOf(Status.CELL_CLOSE) < 0
    }
}