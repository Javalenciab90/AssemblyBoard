package com.javalenciab90.auth.ui.viewmodel.reset

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetViewModel @Inject constructor(
    context: CoroutineContextProvider
) : MviViewModel<ResetContract.State, ResetContract.Effect, ResetContract.Intent>(context) {

    override fun setInitialState(): ResetContract.State = ResetContract.State()

    override fun handleIntent(intent: ResetContract.Intent) {
        when(intent) {
            is ResetContract.Intent.UpdateEmail -> {
                updateNow {
                    it.copy(email = intent.email)
                }
            }
            ResetContract.Intent.SendResetEmailAction -> {
                //sendResetEmail()
            }
        }
    }
}