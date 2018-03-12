package net.terzeron.a13fragmenttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity

class MainActivity : FragmentActivity() {
    val firstFragment = FragmentOne()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFragment.arguments = intent.extras
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainActivity_layout, firstFragment)
        transaction.addToBackStack(null)
        transaction.commit()

/*        val secondFragment = FragmentTwo()
        var transaction2 = supportFragmentManager.beginTransaction()
        transaction2.replace(R.id.mainActivity_layout, secondFragment)
        transaction2.addToBackStack(null)
        transaction2.commit()*/
    }
}
