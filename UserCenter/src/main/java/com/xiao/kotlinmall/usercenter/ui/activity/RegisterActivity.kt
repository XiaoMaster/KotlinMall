package com.xiao.kotlinmall.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.xiao.kotlinmall.usercenter.R
import com.xiao.kotlinmall.usercenter.presenter.RegisterPresenter
import com.xiao.kotlinmall.usercenter.presenter.view.RegisterView
import com.xiao.kotlinmalll.baselibrary.ui.activity.BaseActivity
import com.xiao.kotlinmalll.baselibrary.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        buttonClick.setOnClickListener { button ->
            mPresenter.register("", "", "")
        }
    }

    override fun onRegisterResult(result: Boolean) {

        val content = if (result) "注册成功" else "注册失败"
        toast(content)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
