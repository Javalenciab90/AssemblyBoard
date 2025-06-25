package com.javalenciab90.auth.ui.viewmodel.reset

import app.cash.turbine.test
import com.javalenciab90.auth.ui.viewmodel.register.RegisterContract
import com.javalenciab90.base.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ResetViewModelTest {

    @get: Rule
    var coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: ResetViewModel

    @Before
    fun setup() {
        viewModel = ResetViewModel(coroutineTestRule.coroutineContextProvider)
    }

    @Test
    fun `given text as email, when updateEmail, then update email field`() = runTest {
       // given
       val emailText = "reset_email@gmail.com"

       // when
       viewModel.handleIntent(ResetContract.Intent.UpdateEmail(emailText))

       // then
       viewModel.uiState.test {
           val result = awaitItem()
           assert(result.email == emailText)
       }
    }
}