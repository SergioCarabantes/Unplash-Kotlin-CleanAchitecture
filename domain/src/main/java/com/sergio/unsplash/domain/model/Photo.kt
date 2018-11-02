package com.sergio.unsplash.domain.model

data class Photo(val id: String,
                 val url: String,
                 val username: String,
                 val description: String?,
                 val created_at: String)
