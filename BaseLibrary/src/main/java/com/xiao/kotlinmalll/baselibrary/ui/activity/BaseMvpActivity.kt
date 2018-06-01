package com.xiao.kotlinmalll.baselibrary.ui.activity

import com.xiao.kotlinmalll.baselibrary.presenter.BasePresenter
import com.xiao.kotlinmalll.baselibrary.presenter.view.BaseView

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    lateinit var mPresenter: T
}