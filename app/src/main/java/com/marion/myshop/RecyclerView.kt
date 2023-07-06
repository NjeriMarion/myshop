package com.marion.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marion.myshop.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }
}