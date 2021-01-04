package com.tugasakhirsemester.Siska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.tugasakhirsemester.Siska.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){ //function untuk request data
        ApiService.endpoint.getData() //memanggil ApiService endpoint
            .enqueue(object : Callback<List<MainModel>> { //pastikan import menggunakan retrofit
                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    if (response.isSuccessful){
                        val mainModel: List<MainModel> = response.body()!!
                        setResponse(mainModel)
                    }
                }

            })
    }

    private fun setResponse(mainModel: List<MainModel>) { //function untuk menampilkan data sesuai id di TextView
        val response = mainModel[0]
        val resultPositif = findViewById<TextView>(R.id.viewPositif)
        val resultMeninggal = findViewById<TextView>(R.id.viewMeninggal)
        val resultSembuh = findViewById<TextView>(R.id.viewSembuh)

        resultPositif.setText(response.positif)
        resultMeninggal.setText(response.meninggal)
        resultSembuh.setText(response.sembuh)
    }
}
