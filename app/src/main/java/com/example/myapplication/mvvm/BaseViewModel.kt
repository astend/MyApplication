package com.example.myapplication.mvvm

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created on 02.01.20.
 */
open class BaseViewModel: ViewModel() {
  val disposable: CompositeDisposable = CompositeDisposable()

  override fun onCleared() {
    super.onCleared()
    disposable.clear()
  }
}