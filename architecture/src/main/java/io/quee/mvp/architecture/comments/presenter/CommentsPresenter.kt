package io.quee.mvp.architecture.comments.presenter

import io.quee.mvp.architecture.comments.contract.CommentsContract

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

class CommentsPresenter : CommentsContract.CommentsPresenter() {
    override fun comments() {
        manager().add(model?.comments!!.subscribe({
            view?.onCommentsLoaded(it)
        }, {
            view?.onError(it)
        }))
    }
}