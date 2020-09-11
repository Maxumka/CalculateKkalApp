package com.example.lab1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_browser_call.view.*


class FragmentBrowserCall : Fragment() {

    private lateinit var mEditTextLink: EditText

    private lateinit var mButtonOpen: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_browser_call, container, false)

        mEditTextLink = view.editText_browser_link

        mButtonOpen = view.button_open

        mButtonOpen.setOnClickListener {
            openLink()
        }

        return view
    }

    private fun openLink() {
        var link = mEditTextLink.text.toString()
        var intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(link)
        startActivity(intent)
    }
}