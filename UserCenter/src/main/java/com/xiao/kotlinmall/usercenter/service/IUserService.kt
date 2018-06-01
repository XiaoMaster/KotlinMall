package com.xiao.kotlinmall.usercenter.service

import rx.Observable

interface IUserService {

    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>
}