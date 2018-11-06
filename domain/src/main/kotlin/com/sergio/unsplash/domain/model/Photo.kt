package com.sergio.unsplash.domain.model

data class Photo(val id: String,
                 val url: String,
                 val name: String,
                 val description: String?,
                 val created_at: String)
