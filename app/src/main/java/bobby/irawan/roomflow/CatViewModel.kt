package bobby.irawan.roomflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
class CatViewModel(private val catDao: CatDao) : ViewModel() {

    private var _cats = MutableLiveData<List<Cat>>()
    val cats = _cats as LiveData<List<Cat>>

    init {
       preloadCatData()
    }

    private fun preloadCatData() {
        viewModelScope.launch {
            catDao.addCat(CatEntity.preloadData())
        }
    }

    fun getAllCat() {
        viewModelScope.launch {
            catDao.getCats().collect { catEntities ->
                val catList = catEntities.map { catEntity ->
                    Cat.from(catEntity)
                }
                _cats.postValue(catList)
            }
        }
    }

    fun deleteCat(catEntity: CatEntity) {
        viewModelScope.launch {
            catDao.deleteCat(catEntity)
        }
    }

}