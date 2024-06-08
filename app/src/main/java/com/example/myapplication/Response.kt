package com.example.myapplication

data class Response(
	val data: List<DataItem?>? = null,
	val timestamp: Long? = null
)

data class DataItem(
	val symbol: String? = null,
	val volumeUsd24Hr: String? = null,
	val marketCapUsd: String? = null,
	val priceUsd: String? = null,
	val vwap24Hr: String? = null,
	val changePercent24Hr: String? = null,
	val name: String? = null,
	val explorer: String? = null,
	val rank: String? = null,
	val id: String? = null,
	val maxSupply: String? = null,
	val supply: String? = null
)

