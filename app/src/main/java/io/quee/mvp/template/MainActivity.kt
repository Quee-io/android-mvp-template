package io.quee.mvp.template

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.quee.mvp.architecture.comments.contract.CommentsContract
import io.quee.mvp.architecture.comments.model.CommentsModel
import io.quee.mvp.architecture.comments.presenter.CommentsPresenter
import io.quee.mvp.domain.CommentData
import io.quee.mvp.template.adapter.CommentsAdapter
import io.quee.mvp.template.databinding.ActivityMainBinding
import io.quee.mvp.ui.activity.QueeMvpActivity

class MainActivity :
    QueeMvpActivity<ActivityMainBinding, CommentsContract.CommentsPresenter, CommentsContract.CommentsModel, CommentsContract.CommentsView>(
        R.layout.activity_main
    ), CommentsContract.CommentsView {
    private lateinit var commentsAdapter: CommentsAdapter

    override fun afterMvpInit(bundle: Bundle?) {
        commentsAdapter = CommentsAdapter(this)
        binding.recyclerView.adapter = commentsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.swipeRefreshLayout.setOnRefreshListener {
            initData()
        }
    }

    override fun createModel(): CommentsContract.CommentsModel = CommentsModel()

    override fun createPresenter(): CommentsContract.CommentsPresenter = CommentsPresenter()
    override fun createView(): CommentsContract.CommentsView = this

    override fun initData() {
        showLoading()
        presenter.comments()
    }

    override fun onCommentsLoaded(items: List<CommentData>) {
        hideLoading()
        commentsAdapter.updateAll(items)
    }

    override fun hideLoading() {
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun onError(throwable: Throwable) {
        hideLoading()
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.swipeRefreshLayout.isRefreshing = true
    }
}