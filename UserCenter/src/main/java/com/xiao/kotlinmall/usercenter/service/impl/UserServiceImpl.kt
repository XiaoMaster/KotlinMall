package com.xiao.kotlinmall.usercenter.service.impl

import com.xiao.kotlinmall.usercenter.service.IUserService
import rx.Observable

class UserServiceImpl : IUserService {
    override fun register(mobile: String, verifyCode: String, pwd: String):Observable<Boolean> {

        return Observable.just(false)

    }
}