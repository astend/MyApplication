package com.example.myapplication.view.programmerlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.ProgrammerGenerator
import com.example.myapplication.model.Programmer
import com.example.myapplication.mvvm.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class FragmentProgrammerListVM : BaseViewModel() {

  val programmers: MutableLiveData<List<Programmer>?> = MutableLiveData()

  fun mockLoadProgrammers() {
    disposable.add(
      Observable.timer(2200, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          { programmers.value = ProgrammerGenerator.generateProgrammers(10) },
          {
            Log.e("TAG", "ERROR", it)
            programmers.value = null
          }
        )
    )
  }

}
