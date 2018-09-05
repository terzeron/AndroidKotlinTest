package net.terzeron.a21contentprovidertest.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log

class MyContentProvider : ContentProvider() {

    private val LOG_TAG = javaClass.name;
    private val COLUMN_CITY = "city"
    private val COLUMN_TEMPERATURE = "temperature"
    private val weatherData: MutableMap<String, Integer> = HashMap();

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        Log.d(LOG_TAG, "delete")

        selection?.let {
            return weatherData.remove(it)?.let { 1 } ?: 0
        }
        return 0
    }

    override fun getType(uri: Uri): String? {
        Log.d(LOG_TAG, "getType")
        return "vnd.android.cursor.dir/vnd.com.example.nhnent.contentprovider.provider.weather"
    }

    override fun insert(uri: Uri, values: ContentValues): Uri? {
        Log.d(LOG_TAG, "insert")

        values?.let {
            weatherData.put(it.getAsString(COLUMN_CITY), Integer(it.getAsInteger(COLUMN_TEMPERATURE)))
        }
        return uri
    }

    override fun onCreate(): Boolean {
        Log.d(LOG_TAG, "onCreate")
        weatherData.put("Seoul", Integer(14))
        weatherData.put("Busan", Integer(10))
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        Log.d(LOG_TAG, "query")
        val columns = MatrixCursor(arrayOf(COLUMN_CITY, COLUMN_TEMPERATURE))

        weatherData.forEach {
            entry -> columns.addRow(arrayOf(entry.key, entry.value))
        }
        return columns
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        Log.d(LOG_TAG, "update")

        values?.let {
            if (weatherData.containsKey(values.getAsString(COLUMN_CITY))) {
                weatherData.put(values.getAsString(COLUMN_CITY), Integer(values.getAsString(COLUMN_TEMPERATURE)))
                return 1
            }
        }
        return 0
    }
}
