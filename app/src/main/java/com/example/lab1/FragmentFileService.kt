package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.io.*

class FragmentFileService : Fragment() {

    private lateinit var mTextViewInfoFile: TextView

    private lateinit var mButtonShowFile: Button
    private lateinit var mButtonDeleteFile: Button

    private lateinit var mFile: File

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_file_service, container, false)

        mTextViewInfoFile = view.findViewById(R.id.textView_file_info)
        mButtonShowFile = view.findViewById(R.id.button_show_file)
        mButtonDeleteFile = view.findViewById(R.id.button_delete_file)

        // использую Internal Storage так как получить доступ к External Storage никак не получается
        val fileDir: File = context!!.filesDir
        mFile = File(fileDir, "test.txt")

        mButtonShowFile.setOnClickListener {
            mTextViewInfoFile.text = readFile()
        }

        mButtonDeleteFile.setOnClickListener {
            deleteFile()
        }

        return view
    }

    private fun readFile(): String {
        var text = ""
        try {
            text = FileInputStream(mFile).bufferedReader().use {
                it.readText()
            }
        }
        catch (e: IOException) {
            Log.d("FileTest", e.toString())
        }
        return text
    }

    private fun deleteFile() {
        try {
            FileOutputStream(mFile).use {
                it.write("".toByteArray())
            }
        }
        catch (e: IOException) {
            Log.d("FileTest", e.toString())
        }
    }
}