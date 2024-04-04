package com.example.demo

import org.springframework.web.bind.annotation.RequestParam

data class GetValueRequest(@RequestParam val key: String)
