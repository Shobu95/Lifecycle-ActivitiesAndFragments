package com.shobu95.android_lifecycle.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shobu95.android_lifecycle.R


class SecondFragment : Fragment() {

    private val myTag = "lifecycle"


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v(myTag, "SecondFragment-onAttach")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(myTag, "SecondFragment-onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        Log.v(myTag, "SecondFragment-onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(myTag, "SecondFragment-onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v(myTag, "SecondFragment-onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Log.v(myTag, "SecondFragment-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(myTag, "SecondFragment-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(myTag, "SecondFragment-onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(myTag, "SecondFragment-onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(myTag, "SecondFragment-onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v(myTag, "SecondFragment-onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(myTag, "SecondFragment-onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(myTag, "SecondFragment-onDetach")
    }

}