package com.javalenciab90.auth.ui.viewmodel.login

import app.cash.turbine.test
import com.javalenciab90.base.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
       viewModel = LoginViewModel(
          coroutineTestRule.coroutineContextProvider
       )
    }

    @Test
    fun `given text as email, when updateEmail, then update text as email`() = runTest {
        // given
        val emailText = "new_email@gmail.com"

        // when
        viewModel.handleIntent(LoginContract.Intent.UpdateEmail(emailText))

        // then
        viewModel.uiState.test {
            val result = awaitItem()
            assert(result.email == emailText)
        }
    }

    @Test
    fun `given text as password, when updatePassword, then change password`() = runTest {
        // given
        val passwordText = "new_password"

        // when
        viewModel.handleIntent(LoginContract.Intent.UpdateEmail(passwordText))

        // then
        viewModel.uiState.test {
            val result = awaitItem()
            assert(result.email == passwordText)
        }
    }

    @Test
    fun `when register action, then navigate to register screen`() = runTest {
        // when
        viewModel.handleIntent(LoginContract.Intent.RegisterAction)

        // then
        viewModel.sideEffect.test {
            val result = awaitItem()
            assert(result == LoginContract.Effect.GoToRegister)
        }
    }

    @Test
    fun `when forget password action, then navigate to reset password screen`() = runTest {
        // when
        viewModel.handleIntent(LoginContract.Intent.ForgotPasswordAction)

        // then
        viewModel.sideEffect.test {
            val result = awaitItem()
            assert(result == LoginContract.Effect.GoToResetPassword)
        }
    }

}