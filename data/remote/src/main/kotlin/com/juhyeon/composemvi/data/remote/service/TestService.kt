package com.juhyeon.composemvi.data.remote.service

import com.juhyeon.composemvi.data.remote.feature.test.response.PostResponse
import retrofit2.http.GET

interface TestService {

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>
}