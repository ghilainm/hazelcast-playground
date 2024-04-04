package com.example.demo

import com.hazelcast.core.HazelcastInstance
import org.springframework.web.bind.annotation.*

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/key-value")
class KeyValueController(val hazelcast: HazelcastInstance) {

    @PutMapping
    fun put(@RequestBody putValueRequest: PutValueRequest) {
        if(putValueRequest.ttl != null) {
            keyValueStore().put(putValueRequest.key, putValueRequest.value, putValueRequest.ttl, java.util.concurrent.TimeUnit.SECONDS)
        } else {
            keyValueStore().put(putValueRequest.key, putValueRequest.value)
        }
    }

    @GetMapping
    fun get(getValueRequest: GetValueRequest): String {
        val keyValueStore = keyValueStore()
        return keyValueStore[getValueRequest.key]?: "Key not found"
    }


    @GetMapping("/view")
    fun getView(getValueRequest: GetValueRequest): Any {
        val keyValueStore = keyValueStore()
        return keyValueStore.getEntryView(getValueRequest.key)?: "Key not found"
    }

    @DeleteMapping
    fun clear() {
        keyValueStore().clear()
    }


    private fun keyValueStore() = this.hazelcast.getMap<String, String>("key-value-store")
}
