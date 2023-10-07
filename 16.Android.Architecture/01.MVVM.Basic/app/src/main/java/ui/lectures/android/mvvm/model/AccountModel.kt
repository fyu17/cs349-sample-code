package ui.lectures.android.mvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * AccountModel models a bank account.
 */
class AccountModel {

    // stores the balance
    private val _balance = MutableLiveData(0)

    /**
     * The current balance of the model; observe to receive notifications when the value changes.
     */
    val balance : LiveData<Int>
        get() {
            return _balance
        }

    // stores the number of calls to increment and reset
    private val _commandCounter = MutableLiveData(0)

    /**
     * The number of executed commands, i.e., increments and resets; observe to receive notifications when the value changes.
     */
    val commandCounter : LiveData<Int>
        get() {
            return _commandCounter
        }

    /**
     * Increments the balance by one.
     */
    fun increment() {
        _balance.value = balance.value!! + 1
        _commandCounter.value = _commandCounter.value!! + 1
    }

    /**
     * Resets the balance to zero.
     */
    fun reset() {
        _balance.value = 0
        _commandCounter.value = _commandCounter.value!! + 1
    }
}