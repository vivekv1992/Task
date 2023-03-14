package com.memeglobal.task.model

data class ImageResponse(
    val dates: Dates?,
    val page: Int?,
    val results: List<Result?>?,
    val total_pages: Int?,
    val total_results: Int?
):java.io.Serializable