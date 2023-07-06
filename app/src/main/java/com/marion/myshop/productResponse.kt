package com.marion.myshop

data class productResponse(
    var products:List<Product>,
    var total :Int,
    var skip: Int,
    var limit :Int
)
