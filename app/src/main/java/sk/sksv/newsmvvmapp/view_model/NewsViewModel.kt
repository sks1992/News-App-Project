package sk.sksv.newsmvvmapp.view_model

import androidx.lifecycle.ViewModel
import sk.sksv.newsmvvmapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {
}