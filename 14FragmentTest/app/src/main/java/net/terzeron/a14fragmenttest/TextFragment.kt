package net.terzeron.a14fragmenttest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.text_fragment.*

/**
 * Created by terzeron on 2018. 3. 19..
 */
class TextFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.text_fragment, container, false)
    }

    fun changeTextProperties(fontsize: Int, text: String) {
        textView1.textSize = fontsize.toFloat()
        textView1.text = text
    }
}