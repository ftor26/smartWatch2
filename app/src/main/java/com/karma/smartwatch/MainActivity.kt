package com.karma.smartwatch

import CreateResponce
import android.app.Activity
import android.os.Bundle
import com.karma.smartwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

class MainActivity : Activity() {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.m3o.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val dataBase = retrofit.create(dataBase::class.java)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.create.setOnClickListener {
            val person = man(
                binding.create.text.toString(),
                binding.create.text.toString()
            )
            val RequestManCreate = CreateRowRequest(person)
            MainScope().launch(Dispatchers.IO){
                dataBase.CreateMan(RequestManCreate).execute()
            }
        }

    }
}
interface dataBase {
    @POST("/v1/DB/Create")
    @Headers("Authorization: Bearer YWMyZjFkMjItNmE0OS00NzFlLWJiMmMtNDFhMDdiNzkyZGEx")
    fun CreateMan ( @Body request : CreateRowRequest ): Call<CreateResponce>
}