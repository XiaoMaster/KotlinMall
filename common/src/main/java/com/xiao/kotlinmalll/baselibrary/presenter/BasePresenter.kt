package com.xiao.kotlinmalll.baselibrary.presenter

import com.xiao.kotlinmalll.baselibrary.presenter.view.BaseView

open class BasePresenter<T : BaseView> {

    lateinit var mView: T
}