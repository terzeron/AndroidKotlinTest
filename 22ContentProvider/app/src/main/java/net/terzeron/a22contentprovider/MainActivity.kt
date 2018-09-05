package net.terzeron.a22contentprovider

import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val AUTHORITY = "com.example.nhnent.contentprovider"
    private val CONTENT_URI: Uri = Uri.parse("content://" + AUTHORITY)
    private val COLUMN_CITY = "city"
    private val COLUMN_TEMPERATURE = "temperature"

    fun query(view: View) {
        val cursor: Cursor = contentResolver.query(CONTENT_URI, null, null, null, null)
        try {
            while (cursor.moveToNext()) {
                Log.i("test", COLUMN_CITY + " : "  + cursor.getString(0))
                Log.i("test", COLUMN_TEMPERATURE + " : "  + cursor.getInt(1))
            }
        } finally {
            cursor.close()
        }
    }

    fun insert(view: View) {
        val newData = ContentValues()
        newData.put(COLUMN_CITY, "new york")
        newData.put(COLUMN_TEMPERATURE, 10)
        contentResolver.insert(CONTENT_URI, newData)
    }

    fun update(view: View) {
        val updateData = ContentValues()
        updateData.put(COLUMN_CITY, "new york")
        updateData.put(COLUMN_TEMPERATURE, 20)
        contentResolver.update(CONTENT_URI, updateData, null, null)
    }

    fun delete(view: View) {
        contentResolver.delete(CONTENT_URI, "new york", null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
