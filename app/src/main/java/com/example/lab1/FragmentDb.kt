package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FragmentDb : Fragment() {

    private lateinit var mTextViewDbInfo: TextView

    private lateinit var mButtonShowDb: Button
    private lateinit var mButtonDeleteDb: Button

    private lateinit var mDBManager: DBManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_db, container, false)

        mTextViewDbInfo = view.findViewById(R.id.textView_db_info)
        mButtonShowDb = view.findViewById(R.id.button_show_db)
        mButtonDeleteDb = view.findViewById(R.id.button_delete_db)

        mDBManager = DBManager(activity!!.applicationContext)
        mDBManager.open()

        mButtonShowDb.setOnClickListener {
            mTextViewDbInfo.text = mDBManager.getAllAsText()
        }

        mButtonDeleteDb.setOnClickListener {
            mDBManager.deleteAll()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mDBManager.close()
    }
}