package com.luisdev.tvphotosapp.presentation.screens.overview



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisdev.tvphotosapp.data.entities.Photo
import com.luisdev.tvphotosapp.data.entities.PhotoList
import com.luisdev.tvphotosapp.data.network.api.DataState
import com.luisdev.tvphotosapp.data.network.api.convertToDataState
import com.luisdev.tvphotosapp.data.repositories.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OverviewScreenViewModel @Inject constructor (
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _searchState: MutableLiveData<DataState<PhotoList>> =
        MutableLiveData(DataState.Init)

    var searchState: LiveData<DataState<PhotoList>> = _searchState


    private var _cachedSearchText = ""
    private val _searchText = mutableStateOf("")
    val getSearchText = _searchText
    fun setSearchText(newSearchText: String) {
        _searchText.value = newSearchText
    }

    private val _noMoreResults = mutableStateOf(false)
    val getNoMoreResults = _noMoreResults

    private val _searchedList = mutableStateOf(emptyList<Photo>())
    val getSearchedList = _searchedList

    private var _count = 20


    private val _showTextField = mutableStateOf(false)
    val getShowTextField = _showTextField
    fun setShowTextField(value: Boolean) {
        _showTextField.value = value
    }


    fun init() = getSearchQuery(false)


    private fun _clear() {
        _searchText.value = ""
        _cachedSearchText = ""
        _noMoreResults.value = false
        _showTextField.value = false
        _searchedList.value = emptyList()
    }

    fun getSearchQuery(isRefreshing: Boolean = false) {

        if (_noMoreResults.value) return
        if (isRefreshing) _clear()
        _search(_searchText.value)


    }

    fun getSearchQuery(queryString: String) {

        if (_searchText.equals(_cachedSearchText)) {
            _showTextField.value = false
            return
        }

        _clear()
        _cachedSearchText = queryString
        _searchText.value = queryString
        _search(queryString)

    }

    private fun _search(queryString: String) {
        viewModelScope.launch {

            _searchState.postValue(DataState.Init)
            val resultCor = async { photoRepository.getPhotos(queryString, _count) }
            val result = awaitAll(resultCor)

            _searchState.postValue(result[0].convertToDataState() as DataState<PhotoList>)

            if (result[0].convertToDataState() is DataState.Success) {
                val list =
                    (result[0].convertToDataState() as DataState.Success<PhotoList>).data.value
                if (list.isEmpty()) {
                    _noMoreResults.value = true
                }
                _searchedList.value = _searchedList.value + list
            }
        }
    }
}
