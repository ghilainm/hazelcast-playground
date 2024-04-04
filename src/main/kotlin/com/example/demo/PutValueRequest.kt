package com.example.demo

data class PutValueRequest(val key: String, val value: String, val ttl: Long?)
