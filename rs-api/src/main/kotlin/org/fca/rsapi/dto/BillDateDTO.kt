package org.fca.rsapi.dto

data class BillDateDTO (

        val labels: MutableList<String> = emptyList<String>().toMutableList(),

        val data: MutableList<MutableList<Double>> = emptyList<MutableList<Double>>().toMutableList(),

        var barColors: MutableList<String> = emptyList<String>().toMutableList()
)