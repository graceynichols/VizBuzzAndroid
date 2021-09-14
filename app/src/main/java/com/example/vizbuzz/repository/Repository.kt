package com.example.vizbuzz.repository

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.vizbuzz.models.Podcast

class Repository(private val context: Context) {
    private val queue = Volley.newRequestQueue(context)

    /* Query the server to get podcasts and their details, calls successListener on success or failureListener */
    fun queryPodcasts(successListener: Response.Listener<String>, failureListener: Response.ErrorListener) {
        // TODO: Query server to get podcasts and their details in JSON format then convert
        val stringRequest = StringRequest(Request.Method.GET, URL, successListener, failureListener)
        queue.add(stringRequest)
    }

    companion object {
        private const val URL = "https://vizbuzz-backend.herokuapp.com/view-transcripts"
        private const val TAG = "Repository"
    }
}