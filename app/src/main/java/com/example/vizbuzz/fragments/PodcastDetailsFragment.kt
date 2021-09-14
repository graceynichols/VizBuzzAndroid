package com.example.vizbuzz.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.vizbuzz.R
import com.example.vizbuzz.models.Podcast
/**
 * Fragment to show details for a podcast including transcript.
 */
class PodcastDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var podcastName: String? = null
    private var podcastTranscript: String? = null
    private var title: TextView? = null
    private var transcript: TextView? = null
    // TODO this will probably be a different structure
    private var transcriptColor: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            podcastName = it.getString(KEY_NAME)
            podcastTranscript = it.getString(KEY_TRANSCRIPT)
            transcriptColor = it.getString(KEY_COLOR)
            Log.i(TAG, "Color $transcriptColor")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podcast_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.title)
        transcript = view.findViewById(R.id.transcript)
        title?.text = podcastName
        transcript?.text = podcastTranscript
        // TODO parse color
        if (transcriptColor.equals("red")) {
            transcript?.setTextColor(resources.getColor(R.color.red))
        } else if (transcriptColor.equals("green")) {
            transcript?.setTextColor(resources.getColor(R.color.green))
        }
    }

    companion object {
        private const val KEY_NAME = "podname"
        private const val KEY_TRANSCRIPT = "podtrans"
        private const val KEY_COLOR = "color"
        private const val TAG = "PodcastDetailsFragment"
        @JvmStatic
        fun newInstance(podcast: Podcast) =
            PodcastDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, podcast.name)
                    putString(KEY_TRANSCRIPT, podcast.transcript)
                    putString(KEY_COLOR, podcast.color)
                }
            }
    }
}