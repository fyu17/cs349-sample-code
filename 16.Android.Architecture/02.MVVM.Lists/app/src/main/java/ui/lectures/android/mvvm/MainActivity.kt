package ui.lectures.android.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.chip.ChipGroup
import ui.lectures.android.mvvm.viewmodel.AccountViewModel
import ui.lectures.android.mvvm.viewmodel.Currency

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val balanceViewModel = ViewModelProvider(this)[AccountViewModel::class.java]

        findViewById<TextView>(R.id.balanceView).also { view ->
            balanceViewModel.balance.observe(this) { balance ->
                view.text = balance
            }
        }

        findViewById<Button>(R.id.incrementButton).apply {
            setOnClickListener {
                balanceViewModel.increment()
            }
        }

        findViewById<Button>(R.id.resetButton).apply {
            setOnClickListener {
                balanceViewModel.reset()
            }
        }

        findViewById<TextView>(R.id.recentCommands).also { view ->
            balanceViewModel.recentCommands.observe(this) { activities ->
                view.text = activities.fold("") { acc, cur -> "$acc\n$cur"}
            }
        }

        findViewById<ChipGroup>(R.id.currencyChips).apply {
            isSingleSelection = true
            isSelectionRequired = true
            check(R.id.cadChip)
            setOnCheckedStateChangeListener { _, checkedIds ->
                when(checkedIds.firstOrNull()) {
                    R.id.cadChip -> balanceViewModel.setCurrency(Currency.CAD)
                    R.id.eurChip -> balanceViewModel.setCurrency(Currency.EUR)
                }
            }
        }
    }
}