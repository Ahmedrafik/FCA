package org.fca.rsapi.enum

enum class BottleType(val value: Int) {
    PASTIS(1),
    GET(2),
    VODKA(3),
    RHUM(4);

    companion object {
        fun getBottleTypeByType(type: String) = valueOf(type.toUpperCase())
        fun getBottleTypeByvalue(value: Int):BottleType?{
            values().forEach {
                if (it.value == value) return it
            }
            return null
        }
    }
}