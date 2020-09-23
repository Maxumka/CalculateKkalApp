package com.example.lab1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lab1.model.blogic.FileBLogic

class FragmentFileServiceViewModel(app: Application): AndroidViewModel(app) {

    private val context = getApplication<Application>().applicationContext

    private val mFileBLogic = FileBLogic("test.txt")

    private var _fileInfo = MutableLiveData<String>()
    val mFileInfo: MutableLiveData<String> = _fileInfo

    fun readFile() {
        mFileInfo.value = mFileBLogic.readFile()
    }


}