package com.kotlin.kiumee.presentation.form

import android.content.Intent
import android.view.View
import com.kotlin.kiumee.R
import com.kotlin.kiumee.core.base.BindingActivity
import com.kotlin.kiumee.core.util.context.toast
import com.kotlin.kiumee.databinding.ActivityFormBinding
import com.kotlin.kiumee.presentation.home.HomeActivity

class FormActivity : BindingActivity<ActivityFormBinding>(R.layout.activity_form) {
    override fun initView() {
        initFormAdapter()
    }

    private fun initFormAdapter() {
        val storeList = mutableListOf(
            Store(
                "data:image/png;base64,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",
                "스타벅스",
                ""
            ),
            Store(
                "data:image/png;base64,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",
                "커피빈",
                "강남점"
            ),
            Store(
                "data:image/jpeg;base64,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",
                "컴포즈",
                "홍대점"
            )
        )

        if (storeList.isEmpty()) {
            binding.layoutFormEmpty.visibility = View.VISIBLE
        } else {
            val adapter = FormGridviewAdapter(this, storeList)
            binding.gvForm.adapter = adapter

            adapter.onItemClick = { item ->
                toast("클릭된 항목: ${item.name}")
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }
}
