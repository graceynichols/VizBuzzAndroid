package com.example.vizbuzz.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Response
import com.example.vizbuzz.models.Podcast
import com.example.vizbuzz.repository.Repository
import org.json.JSONObject

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private var allPodcasts: MutableLiveData<List<Podcast>> = MutableLiveData<List<Podcast>>()
    private val TAG = "HomeViewModel"
    private val KEY_TRANSCRIPTS = "transcripts"

    private val repository = Repository(application.applicationContext)

    private val podcastSuccessListener = Response.Listener<String> { response ->
        val json = JSONObject(response)
        // For each podcast, parse and add to list
        val podcasts = ArrayList<Podcast>()
        Log.i(TAG, "Received = $json")
        val podcastsJArray = json.getJSONArray(KEY_TRANSCRIPTS)
        for (i in 0 until podcastsJArray.length()) {
            podcasts.add(Podcast.fromJson(podcastsJArray.getJSONObject(i)))
        }
        allPodcasts.postValue(podcasts)
    }

    private val podcastFailureListener = Response.ErrorListener {
        Log.e(TAG, "Error with network request")
        // TODO show error message to user
    }

    fun allPodcasts(): LiveData<List<Podcast>>? = allPodcasts

    /* Get podcasts from server and post them in allPodcasts live data */
    fun getPodcasts() {
        Log.i(TAG, "In get podcasts")
        repository.queryPodcasts(podcastSuccessListener, podcastFailureListener)

    }
}
