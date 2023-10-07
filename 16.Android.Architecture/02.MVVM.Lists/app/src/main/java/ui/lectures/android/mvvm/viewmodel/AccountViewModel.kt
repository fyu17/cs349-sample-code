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

    /**
     * The current balance of the model; observe to receive notifications when the value changes.
     */
    val balance : LiveData<String>
        get() {
            return _balance
        }

    // stores a list of the five most recently executed commands
    private val _recentCommands = MutableLiveData<List<String>>()

    /**
     * A list of the five most recently executed commands, i.e., increments and resets; observe to receive notifications when the value changes.
     */
    val recentCommands : LiveData<List<String>>
        get() {
            return _recentCommands
        }

    // Map of all existing currency formatters
    private val currencyFormatter = mapOf( // type: Currencies to (String) -> String
        Currency.CAD to { amount: String -> "C$$amount" },
        Currency.EUR to { amount: String -> "$amount €" }
    )

    // Currently active currency formatter
    private var currentCurrencyFormatter = currencyFormatter[Currency.CAD]!! // type: (String) -> String

    init {
        model.balance.observeForever {
            // converts / formats the Int from model.balance into a String using the currentCurrencyFormatter
            _balance.value = "Current balance is ${currentCurrencyFormatter("${it / 100}.${it % 100 / 10}${it % 10}")}"
        }
        model.commandLog.observeForever {
            // re-formats the List<String> from model.balance
            _recentCommands.value = it.mapIndexed { index, value -> "Command #$index was $value" }. takeLast(5)
        }
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

    /**
     * Sets the currency format.
     */
    fun setCurrency(currency: Currency) {
        currentCurrencyFormatter = currencyFormatter[currency]!!
        _balance.value = "Current balance is ${currentCurrencyFormatter("${model.balance.value!! / 100}.${model.balance.value!! % 100 / 10}${model.balance.value!! % 10}")}"
    }
}