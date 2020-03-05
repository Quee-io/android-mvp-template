package io.quee.mvp.architecture.comments.model

import io.quee.mvp.api.CommentApi
import io.quee.mvp.architecture.comments.contract.CommentsContract
import io.quee.mvp.domain.CommentData
import io.quee.mvp.service.RxService
import io.quee.mvp.utils.RxUtil
import io.reactivex.Observable

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

class CommentsModel() : CommentsContract.CommentsModel {

    override val comments: Observable<List<CommentData>> =
        RxService.createApi(CommentApi::class.java)
            .comments()
            .compose(RxUtil.rxSchedulerHelper())
}