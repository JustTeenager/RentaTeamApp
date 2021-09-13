package com.example.rentateamapp.presenter.users_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.domain.usecases.GetUsersUsecase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val getUsersUsecase: GetUsersUsecase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val usersList: MutableLiveData<List<User>> = MutableLiveData()
    val loadState: MutableLiveData<State> = MutableLiveData()

    fun loadUsers() {
        compositeDisposable.add(
            getUsersUsecase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { loadState.value = State.LOADING }
                .doOnComplete {
                    if (usersList.value.isNullOrEmpty()) loadState.value = State.ERROR
                    else loadState.value = State.IDLE
                }
                .subscribe { usersList.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    enum class State {
        LOADING,
        IDLE,
        ERROR
    }
}