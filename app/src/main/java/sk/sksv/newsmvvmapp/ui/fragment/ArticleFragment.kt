package sk.sksv.newsmvvmapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import sk.sksv.newsmvvmapp.R
import sk.sksv.newsmvvmapp.ui.activity.NewsActivity
import sk.sksv.newsmvvmapp.view_model.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}