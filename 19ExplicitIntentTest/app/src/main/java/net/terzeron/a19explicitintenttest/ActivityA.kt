package net.terzeron.a19explicitintenttest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {
    private val request_code = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }

    fun onClick(view: View) {
        // explicit intent는 다른 activity를 지정함
        val i = Intent(this, ActivityB::class.java)
        val myString = editTextA.text.toString()
        // intent로 값을 전달함
        i.putExtra("qString", myString)

        // startActivity(i) 대신에 ForResult() 사용하면 stack에 activity가 쌓이지 않음
        // ActivityB가 A의 하위 activity가 됨
        startActivityForResult(i, request_code)
    }

    // 하위 activity가 종료할 때 결과를 받아오는 이벤트 리스너
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if ((requestCode == request_code) && (resultCode == RESULT_OK)) {
            if (data.hasExtra("returnData")) {
                val returnString = data.extras.getString("returnData")
                textViewA.text = returnString
            }
        }
    }
}
