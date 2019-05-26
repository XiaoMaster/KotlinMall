package com.xiao.kotlinmall.usercenter.presenter

import android.widget.Toast
import com.xiao.kotlinmall.usercenter.presenter.view.RegisterView
import com.xiao.kotlinmall.usercenter.service.impl.UserServiceImpl
import com.xiao.kotlinmalll.baselibrary.presenter.BasePresenter
import com.xiao.kotlinmalll.baselibrary.rx.BaseSubscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, verifyCode: String, pwd: String) {
        mView.onRegisterResult(true)

        val userService = UserServiceImpl()

        userService.register(mobile, verifyCode, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object :BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {

                        mView.onRegisterResult(t)

                    }

                    override fun onCompleted() {
                    }

                    override fun onError(e: Throwable?) {
                    }

                })

    }
}