package com.example.vizbuzz.models

import org.json.JSONObject

class Podcast() {
    var name: String? = null
    var transcript: String? = null
    var color: String? = null

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_COLOR = "color"
        private const val KEY_TRANSCRIPT = "all_text"
        @JvmStatic
        fun newInstance(title: String?, trans: String?, color: String?): Podcast {
            val newPodcast = Podcast()
            newPodcast.name = title
            newPodcast.transcript = trans
            newPodcast.color = color
            return newPodcast
        }
        @JvmStatic
        fun fromJson(json: JSONObject): Podcast {
            val newPodcast = Podcast()
            newPodcast.name = json.getString(KEY_NAME)
            newPodcast.color = json.getString(KEY_COLOR)
            newPodcast.transcript = json.getString(KEY_TRANSCRIPT)

            return newPodcast
        }

    }
}