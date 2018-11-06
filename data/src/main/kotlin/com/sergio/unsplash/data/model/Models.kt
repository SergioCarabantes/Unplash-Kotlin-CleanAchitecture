package com.sergio.unsplash.data.model

import com.google.gson.annotations.SerializedName
import com.sergio.unsplash.domain.model.Photo

data class PhotoModel(
    @SerializedName("id") val id: String,
    @SerializedName("created_at")val createdAt: String,
    @SerializedName("updated_at")val updatedAt: String,
    @SerializedName("width") val width: Long,
    @SerializedName("height") val height: Long,
    @SerializedName("color") val color: String,
    @SerializedName("likes") val likes: Long,
    @SerializedName("liked_by_user") val likedByUser: Boolean,
    @SerializedName("description") val description: String?,
    @SerializedName("user") val user: UserModel,
    @SerializedName("urls") val urls: UrlsModel,
    @SerializedName("links") val links: LinksModel
)

data class UserModel(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("name") val name: String,
    @SerializedName("portfolio_url") val portfolio_url: String?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("total_likes") val totalLikes: String?,
    @SerializedName("total_photos") val totalPhotos: String?,
    @SerializedName("total_collections") val totalCollections: String?,
    @SerializedName("instagram_username") val instagramUsername: String?,
    @SerializedName("twitter_username") val twitterUsername: String?,
    @SerializedName("profile_image") val profileImage: ProfileImageModel,
    @SerializedName("links") val links: ProfileLinksModel)


data class UrlsModel(
    @SerializedName("raw") val raw: String,
    @SerializedName("full") val full: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("small") val small: String,
    @SerializedName("thumb") val thumb: String)

data class ProfileImageModel(
    @SerializedName("small") val small: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("large") val large: String)

data class ProfileLinksModel(
    @SerializedName("self") val self: String,
    @SerializedName("html") val html: String,
    @SerializedName("photos") val photos: String,
    @SerializedName("likes") val likes: String,
    @SerializedName("portfolio") val portfolio: String)

data class LinksModel(
    @SerializedName("self") val self: String,
    @SerializedName("html") val html: String,
    @SerializedName("download") val download: String,
    @SerializedName("download_location") val downloadLocation: String)

fun List<PhotoModel>.mapToDomain(): List<Photo> = this.map { it.mapToDomain() }

fun PhotoModel.mapToDomain(): Photo = Photo(
    this.id,
    this.urls.regular,
    this.user.name,
    this.description,
    this.createdAt)
