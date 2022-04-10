package cz.pilulka.aircraftmap.timer

import android.os.CountDownTimer
import javax.inject.Inject

class PeriodicalTaskManager @Inject constructor() {

    companion object {
        private const val ONE_SECOND = 1_000L
    }

    private lateinit var timer: CountDownTimer

    fun startExecuting(period: Long, onTicking: (Long) -> Unit, task: () -> Unit) {
        timer = object : CountDownTimer(period, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                onTicking(millisUntilFinished / ONE_SECOND)
            }

            override fun onFinish() {
                task()
                timer.start()
            }
        }
        task()
        timer.start()
    }

    fun stop() = timer.cancel()
}