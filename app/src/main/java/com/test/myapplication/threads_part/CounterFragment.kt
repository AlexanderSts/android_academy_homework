package com.test.myapplication.threads_part;

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myapplication.R
import kotlinx.android.synthetic.main.fragment_threads.*

private const val FRAGMENT_TYPE = "fragment_type"

class CounterFragment : Fragment() {

    companion object {
        fun newInstance(fragmentTitle: String): CounterFragment {
            val fragment = CounterFragment()

            val bundle = Bundle(1).apply {
                putString(FRAGMENT_TYPE, fragmentTitle)
            }
            fragment.arguments = bundle

            return fragment
        }
    }

    private var listener: TaskEventContract.Operationable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_threads, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (activity != null && activity is TaskEventContract.Operationable) {
            listener = activity as TaskEventContract.Operationable
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_create.setOnClickListener { listener?.createTask() }
        button_start.setOnClickListener { listener?.startTask() }
        button_cancel.setOnClickListener { listener?.cancelTask() }

        //UNPACK OUR DATA FROM OUR BUNDLE
        val fragmentText = this.arguments?.getString(FRAGMENT_TYPE)
        text_value.text = fragmentText
    }

    override fun onDetach() {
        super.onDetach()

        listener = null
    }

    fun updateFragmentText(text: String) {
        text_value.text = text
    }
}