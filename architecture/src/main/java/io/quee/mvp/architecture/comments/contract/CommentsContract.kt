package io.quee.mvp.architecture.comments.contract

import io.quee.mvp.common.QueeModel
import io.quee.mvp.common.QueePresenter
import io.quee.mvp.common.QueeView
import io.quee.mvp.domain.CommentData
import io.reactivex.Observable

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

interface CommentsContract {
    interface CommentsModel : QueeModel {
        val comments: Observable<List<CommentData>>
    }

    interface CommentsView : QueeView {
        fun onCommentsLoaded(items: List<CommentData>)
    }

    abstract class CommentsPresenter : QueePresenter<CommentsModel, CommentsView>() {
        abstract fun comments()
    }
}