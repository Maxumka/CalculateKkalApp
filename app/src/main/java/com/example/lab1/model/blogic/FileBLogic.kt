package com.example.lab1.model.blogic

import java.io.FileInputStream
import java.io.FileOutputStream

class FileBLogic(val path: String) {

    fun writeFile(data: String) {
        val fileOutputStream = FileOutputStream(path)
        fileOutputStream.write(data.toByteArray())
    }

    fun readFile(): String = FileInputStream(path).bufferedReader().use { it.readText() }

}