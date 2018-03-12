package net.terzeron.a11optionmenutest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.simple_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_red -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.RED)
                return true
            }
            R.id.menu_green -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.GREEN)
                return true
            }
            R.id.menu_yellow -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.YELLOW)
                return true
            }
            R.id.menu_blue -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.BLUE)
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }
}
