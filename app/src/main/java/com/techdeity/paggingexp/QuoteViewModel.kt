package com.techdeity.paggingexp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.techdeity.paggingexp.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(val quotesRepository: QuotesRepository):ViewModel() {
    val list = quotesRepository.getQuotes().cachedIn(viewModelScope)
}