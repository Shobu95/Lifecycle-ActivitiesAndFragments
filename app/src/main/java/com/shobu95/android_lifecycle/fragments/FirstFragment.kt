package com.shobu95.android_lifecycle.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.shobu95.android_lifecycle.R
import com.shobu95.android_lifecycle.activities.SecondActivity
import com.shobu95.android_lifecycle.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), View.OnClickListener {

    private val myTag = "lifecycle"
    private lateinit var binding: FragmentFirstBinding

    /**
     * Called First and ONCE when the fragment is attached to the
     * FragmentManager or Activity
     * Appropriate place to restore the any saved state of the fragment
     * through SavedStateRegistry
     * View is not created at this time
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v(myTag, "FirstFragment-onAttach")
    }


    /**
     * Called ONCE after onAttach
     * Receives a savedInstanceStateBundle of any previously
     * saved state, initially null
     * Can be used for initializing non-view related data
     * such as LiveData, Adapters etc.
     * View is still not created here, its in process
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(myTag, "FirstFragment-onCreate")
    }

    /**
     * Called after onCreate
     * View is inflated and initialized here
     * Recommended to only put view inflation code here
     * Operations on view should be placed in the next callback
     * that is onViewCreated.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        Log.v(myTag, "FirstFragment-onCreateView")
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity),
            R.layout.fragment_first,
            container,
            false)

        return binding.root
    }


    /**
     * Called after onCreateView
     * Any operations related with the state of the view
     * should be kept here.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenSecondFragment.setOnClickListener(this)
        binding.btnOpenSecondActivity.setOnClickListener(this)
        Log.v(myTag, "FirstFragment-onViewCreated")
    }

    /**
     * Called after onViewCreated and before onStart
     * used to initialize saved state of the view hierarchy
     * such as status of checkbox widgets.
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v(myTag, "FirstFragment-onViewStateRestored")
    }

    /**
     * Called when the fragment is visible to the user but
     * not interactive
     * Tied with the onStart of the Activity
     */
    override fun onStart() {
        super.onStart()
        Log.v(myTag, "FirstFragment-onStart")
    }


    /**
     * Called after onStart
     * Fragment is visible and interactive
     * Animation and Transition effects have finished
     * Tied to the onResume of the Activity
     */
    override fun onResume() {
        super.onResume()
        Log.v(myTag, "FirstFragment-onResume")
    }

    /**
     * Called when user begin to leave the fragment
     * while the fragment is still visible
     * Tied to the onPause of the Activity
     */
    override fun onPause() {
        super.onPause()
        Log.v(myTag, "FirstFragment-onPause")

    }

    /**
     * Called when the fragment is completely invisible
     * from the screen.
     * Tied to the onStop of the Activity
     */
    override fun onStop() {
        super.onStop()
        Log.v(myTag, "FirstFragment-onStop")
    }


    /**
     * Called to ask the fragment to save its current state,
     * which later be reconstructed in a new instance when process restarts
     * Bundle saved here will be available in onCreate, onCreateView and onViewCreated
     * Called before onStop prior to Api 28
     * Called after onStop in Api 28+
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(myTag, "FirstFragment-onSaveInstanceState")
    }

    /**
     * Called when the view created in onCreateView
     * is been detached from the fragment container
     * All references of the fragments view should be released
     * Called after onStop and before onDestroy
     */
    override fun onDestroyView() {
        super.onDestroyView()
        Log.v(myTag, "FirstFragment-onDestroyView")
    }


    /**
     * Called when the view is completely removed from the
     * fragment container
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.v(myTag, "FirstFragment-onDestroy")

    }

    /**
     * Final fragment callback, called when fragment
     * is detached from the Activity
     * Called after onDestroy
     */
    override fun onDetach() {
        super.onDetach()
        Log.v(myTag, "FirstFragment-onDetach")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_open_second_fragment -> {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.root_layout, SecondFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }

            R.id.btn_open_second_activity -> {
                activity?.startActivity(Intent(activity?.applicationContext,
                    SecondActivity::class.java))
            }
        }
    }
}