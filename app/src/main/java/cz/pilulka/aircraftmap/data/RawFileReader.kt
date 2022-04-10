package cz.pilulka.aircraftmap.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedReader
import javax.inject.Inject

class RawFileReader @Inject constructor(@ApplicationContext private val context: Context) {

    fun getContent(resId: Int): String {
        val rawResourceStream = context.resources.openRawResource(resId)
        val reader = BufferedReader(rawResourceStream.reader())
        val content = StringBuilder()

        reader.use {
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        }

        return content.toString()
    }
}