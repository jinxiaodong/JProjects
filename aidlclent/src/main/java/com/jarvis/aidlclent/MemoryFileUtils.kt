package com.jarvis.aidlclent

import android.os.MemoryFile
import java.io.FileDescriptor
import java.io.IOException

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/14
 */
object MemoryFileUtils {

    fun createMemoryFile(name: String?, length: Int): MemoryFile? {
        try {
            return MemoryFile(name, length)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    fun getFileDescriptor(memoryFile: MemoryFile): FileDescriptor {
        return ReflectUtils.invoke(
            "android.os.MemoryFile",
            memoryFile,
            "getFileDescriptor"
        ) as FileDescriptor
    }
}