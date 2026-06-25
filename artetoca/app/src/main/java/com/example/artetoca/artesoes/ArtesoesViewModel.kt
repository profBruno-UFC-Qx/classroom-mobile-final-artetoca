package com.example.artetoca.artesoes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtesaosViewModel(
    private val repository: ArtesaoRepository = ArtesaoRepository()
) : ViewModel() {

    private val _artesaos = MutableStateFlow<List<Artesao>>(emptyList())
    val artesaos: StateFlow<List<Artesao>> = _artesaos.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchArtesaos()
    }

    private fun fetchArtesaos() {
        viewModelScope.launch {
            try {
                _artesaos.value = repository.getArtesaos()
            } finally {
                _isLoading.value = false
            }
        }
    }
}