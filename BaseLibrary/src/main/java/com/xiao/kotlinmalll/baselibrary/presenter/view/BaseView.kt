package com.xiao.kotlinmalll.baselibrary.presenter.view

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun onError()
}