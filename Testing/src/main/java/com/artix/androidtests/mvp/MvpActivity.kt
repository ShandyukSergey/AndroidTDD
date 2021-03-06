package com.artix.androidtests.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.artix.androidtests.R
import kotlinx.android.synthetic.main.activity_main.*

class MvpActivity : AppCompatActivity(), MainScreen.View {
    override val presenter: MainScreen.Presenter = MainScreenPresenter(MainScreenModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoad.setOnClickListener { presenter.loadDataClicked() }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun displayItems(items: List<String>) {
        tvResult.text = items.joinToString { it }
    }
}
