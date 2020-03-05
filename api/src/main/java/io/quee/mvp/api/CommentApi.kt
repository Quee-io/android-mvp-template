package io.quee.mvp.api

import io.quee.mvp.domain.CommentData
import io.reactivex.Observable
import retrofit2.http.GET

interface CommentApi {
    @GET("/typicode/demo/comments")
    fun comments(): Observable<List<CommentData>>
}