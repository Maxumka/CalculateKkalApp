package com.example.lab1.model.blogic

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class FileBLogic(val context: Context) {

    private val mFile: File

    init {
        val fileDir = context.filesDir
        mFile = File(fileDir, "test.txt")
    }

    fun readFile(): String {
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

    fun writeFile(text: String) {
        try {
            mFile.appendText(text)
            Log.d("FileTest", text)
        }
        catch (e: IOException) {
            Log.d("FileTest", e.toString())
        }
    }

    fun clearFile() {
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