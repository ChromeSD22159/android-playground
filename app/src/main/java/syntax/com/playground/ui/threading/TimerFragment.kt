package syntax.com.playground.ui.threading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import syntax.com.playground.MainFragment
import syntax.com.playground.databinding.FragmentTimerBinding

class TimerFragment : MainFragment() {

    private lateinit var vb: FragmentTimerBinding
    private val tvm: TimerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentTimerBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addOberservers()
        setAllButtonsOnClickListener()
    }

    private fun addOberservers() {
        tvm.timerValue.observe(viewLifecycleOwner) { timerValueInSec: Long ->
            vb.tvTimer.text = timerValueInSec.toString()
        }
    }

    private fun setAllButtonsOnClickListener() {
        vb.btStart.setOnClickListener {
            tvm.startTimer()
        }

        vb.btPause.setOnClickListener {
            tvm.pauseTimer()
        }

        vb.btReset.setOnClickListener {
            tvm.resetTimer()
        }

        vb.btFaster.setOnClickListener {
            tvm.goFaster()
        }

        vb.btSlower.setOnClickListener {
            tvm.goSlower()
        }
    }
}