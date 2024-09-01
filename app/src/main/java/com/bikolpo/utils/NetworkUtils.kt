package com.bikolpo.utils

import android.util.Log
import com.bikolpo.model.IndianBrandsResponseItem
import org.json.JSONArray
import org.json.JSONObject

fun parseBrandJsonResult(jsonArray: JSONArray): ArrayList<IndianBrandsResponseItem> {
    val brandList = ArrayList<IndianBrandsResponseItem>()

    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)

        val id = jsonObject.getLong("id")
        val name = jsonObject.getString("name")
        val enName = jsonObject.getString("en_name")
        val image = jsonObject.getString("image")

        // Get categories and alternatives as lists
        val categories = jsonObject.optJSONArray("categories")
        val category = mutableListOf<Int>()
        if (categories != null) {
            for (index in 0 until  categories.length()) {
                category.add(categories.getInt(index))
            }
        }

        val alternatives = jsonObject.optJSONArray("alternatives")
        val alternative = mutableListOf<Int>()
        if (alternatives != null){
            for (index in 0 until  alternatives.length()) {
                alternative.add(alternatives.getInt(index))
            }
        }

        brandList.add(
            IndianBrandsResponseItem(
                id = id,
                name = name,
                enName = enName,
                image = image,
                categories = listToString(category),
                alternatives = listToString(alternative)
            )
        )
    }

    return brandList
}

fun listToString(intList: List<Int>): String {
    return intList.joinToString(separator = ",")
}

fun stringToList(intString: String): List<Int> {
    return intString.split(",").map { it.trim().toInt() }
}