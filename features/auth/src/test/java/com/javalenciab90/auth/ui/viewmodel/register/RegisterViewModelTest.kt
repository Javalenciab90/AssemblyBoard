package com.javalenciab90.auth.ui.viewmodel.register

import app.cash.turbine.test
import com.javalenciab90.base.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setUp() {
         viewModel = RegisterViewModel(
              coroutineTestRule.coroutineContextProvider
         )
    }

     @Test
     fun `given text as email, when updateEmail, then update email field`() = runTest {
         // given
         val emailText = "register_email@gmail.com"

         // when
         viewModel.handleIntent(RegisterContract.Intent.UpdateEmail(emailText))

         // then
         viewModel.uiState.test {
             val result = awaitItem()
             assert(result.email == emailText)
         }
     }

    @Test
    fun `given text as password, when updatePassword, then update password field`() = runTest {
        // given
        val passwordText = "new_password"

        // when
        viewModel.handleIntent(RegisterContract.Intent.UpdatePassword(passwordText))

        // then
        viewModel.uiState.test {
            val result = awaitItem()
            assert(result.password == passwordText)
        }
    }

    @Test
    fun `given text as confirm password, when updatePassword, then update password confirm field`() = runTest {
        // given
        val passwordText = "confirm_password"

        // when
        viewModel.handleIntent(RegisterContract.Intent.UpdateConfirmPassword(passwordText))

        // then
        viewModel.uiState.test {
            val result = awaitItem()
            assert(result.confirmPassword == passwordText)
        }
    }

    @Test
    fun `when login in, then navigate to login screen`() = runTest {
        // when
        viewModel.handleIntent(RegisterContract.Intent.LoginAction)

        // then
        viewModel.sideEffect.test {
            val result = awaitItem()
            assert(result == RegisterContract.Effect.GoToLogin)
        }
    }

}