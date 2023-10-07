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


    private val _commandList = mutableListOf<String>()
    private val _commandLog = MutableLiveData(_commandList as List<String>)

    val commandLog : LiveData<List<String>>
        get() {
            return _commandLog
        }

    /**
     * Increments the balance by one.
     */
    fun increment() {
        _balance.value = balance.value!! + 1
        _commandList.add("Increment")
        _commandLog.postValue(_commandLog.value)
    }

    /**
     * Resets the balance to zero.
     */
    fun reset() {
        _balance.value = 0
        _commandList.add("Reset")
        _commandLog.postValue(_commandLog.value)
    }
}