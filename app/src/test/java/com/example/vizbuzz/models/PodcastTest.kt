package com.example.vizbuzz.models

import junit.framework.Assert.assertEquals
import org.json.JSONArray
import org.junit.Test

class PodcastTest {
    private val TEST_TITLE = "title1"
    private val TEST_TRANSCRIPT = "transcript1"
    private val TEST_KEY_NAME = "name"
    private val TEST_KEY_ALL_TEXT = "all_text"
    private val TEST_KEY_COLOR = "color"
    private val test_json = JSONArray("[{name:hello1,alias:world1,color:green,all_text:Hello1 transcript},{name:hello2,alias:world2,color:red,all_text:Hello2 transcript}]")
    private val jsonName1 = "hello1"
    @Test
    fun attributes_test() {
        val underTest = Podcast.newInstance(TEST_TITLE, TEST_TRANSCRIPT, "green")
        assertEquals(underTest.name, TEST_TITLE)
        assertEquals(underTest.transcript, TEST_TRANSCRIPT)
    }

    @Test
    fun to_json_test() {
        val firstPod = test_json.getJSONObject(0)
        val p1 = Podcast.fromJson(firstPod)
        assertEquals(p1.name, firstPod.getString(TEST_KEY_NAME))
        assertEquals(p1.transcript, firstPod.getString(TEST_KEY_ALL_TEXT))
        assertEquals(p1.color, firstPod.getString(TEST_KEY_COLOR))

        val secondPod = test_json.getJSONObject(1)
        val p2 = Podcast.fromJson(secondPod)
        assertEquals(p2.name, secondPod.getString(TEST_KEY_NAME))
        assertEquals(p2.transcript, secondPod.getString(TEST_KEY_ALL_TEXT))
        assertEquals(p2.color, secondPod.getString(TEST_KEY_COLOR))
    }

}