package com.marion.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marion.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }

    fun getProducts() {
        val retrofit = Apiclient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getProducts()
        request.enqueue(object : Callback<productResponse> {
            override fun onResponse(
                call: Call<productResponse>,
                response: Response<productResponse>
            ) {
                if (response.isSuccessful) {

                    var products = response.body()?.products

                    var productAdapter=adapter(products?: emptyList())
                    binding.rvproducts.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvproducts.adapter = productAdapter

                    Toast.makeText(
                        baseContext,
                        "fetched ${products?.size}products",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG)
                        .show()
                }

            }

            override fun onFailure(call: Call<productResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })


    }
}