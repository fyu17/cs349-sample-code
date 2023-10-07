package ui.lectures.android.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ui.lectures.android.mvvm.model.AccountModel

/**
 * AccountViewModel facilitates data exchange between the [Model][ui.lectures.android.mvvm.model.AccountModel] and the View.
 */
class AccountViewModel : ViewModel() {

    private val model = AccountModel()

    // stores the balance
    private val _balance = MutableLiveData<String>()

    // stores the command counter
    private val _commandCounter = MutableLiveData<String>()

    /**
     * The current balance of the model; observe to receive notifications when the value changes.
     */
    val balance : LiveData<String>
        get() {
            return _balance
        }

    /**
     * The number of executed command, i.e., increments and resets; observe to receive notifications when the value changes.
     */
    val commandCounter : LiveData<String>
        get() {
            return _commandCounter
        }

    init {
        model.balance.observeForever { _balance.value = "Current balance is C$ ${it / 100}.${it % 100 / 10}${it % 10}" }
        model.commandCounter.observeForever { _commandCounter.value = "So far, $it command have been executed on this account" }
    }

    /**
     * Attempts to increment the value of the [Model][ui.lectures.android.mvvm.model.AccountModel] by one.
     */
    fun increment() {
        model.increment()
    }

    /**
     * Attempts ro resets the value of the [Model][ui.lectures.android.mvvm.model.AccountModel].
     */
    fun reset() {
        model.reset()
    }
}