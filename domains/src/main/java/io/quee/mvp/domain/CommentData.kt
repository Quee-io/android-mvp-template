package io.quee.mvp.domain

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

class CommentData(
    @param:JsonProperty var id: Int,
    @param:JsonProperty var body: String,
    @param:JsonProperty var postId: String
) {
    override fun toString(): String {
        return "id: $id, body: $body, postId: $postId"
    }
}