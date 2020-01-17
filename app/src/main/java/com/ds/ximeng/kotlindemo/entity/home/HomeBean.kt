package com.ds.ximeng.kotlindemo.entity.home

data class HomeBean(
    val errorType: String,
    val message: String,
    val resultMap: ResultMap,
    val status: Int,
    val success: Boolean
)

data class ResultMap(
    val posts: List<Post>,
    val topics: List<Topic>,
    val types: List<Type>
)

data class Post(
    val avatar: String,
    val content: String,
    val like: Boolean,
    val likeCount: Int,
    val nickname: String,
    val postCode: String,
    val postMainImage: String
)

data class Topic(
    val follow: Any,
    val followCount: Int,
    val topicCode: String = "",
    val topicName: String
)

data class Type(
    val typeCode: String,
    val typeImage: String,
    val typeName: String
)