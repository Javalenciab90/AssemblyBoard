package com.javalenciab90.auth.ui.viewmodel.login

import com.javalenciab90.auth.domain.models.UserCredentialsModel
import com.javalenciab90.auth.domain.usecases.SignInWithEmailUseCase
import com.javalenciab90.auth.domain.usecases.validators.CredentialsValidationError
import com.javalenciab90.auth.domain.usecases.validators.ValidateLoginCredentialsUseCase
import com.javalenciab90.auth.domain.usecases.validators.ValidationResult
import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginUseCase: ValidateLoginCredentialsUseCase,
    private val signInWithEmailUseCase: SignInWithEmailUseCase,
    context: CoroutineContextProvider
) : MviViewModel<LoginContract.State, LoginContract.Effect, LoginContract.Intent>(context) {

    override fun setInitialState(): LoginContract.State = LoginContract.State()

    override fun handleIntent(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.UpdateEmail -> {
                updateNow {
                    it.copy(email = intent.email)
                }
            }
            is LoginContract.Intent.UpdatePassword -> {
                updateNow {
                    it.copy(password = intent.password)
                }
            }
            LoginContract.Intent.RegisterAction -> {
                postSideEffect(LoginContract.Effect.GoToRegister)
            }
            LoginContract.Intent.ForgotPasswordAction -> {
                postSideEffect(LoginContract.Effect.GoToResetPassword)
            }
            LoginContract.Intent.LoginAction -> {
                loginValidation()
            }
        }
    }

    private fun loginValidation() {
        val credentials = UserCredentialsModel(
            email = currentUiState.email,
            password = currentUiState.password,
            confirmPassword = null
        )
        when (val result = validateLoginUseCase(credentials)) {
            ValidationResult.Success -> {
                logIn(credentials.email, credentials.password)
            }
            is ValidationResult.Failure -> {
                showCredentialsError(result.error)
            }
        }
    }

    private fun logIn(email: String, password: String) {
        launchInBackground {
            signInWithEmailUseCase(email, password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        postSideEffect(LoginContract.Effect.GoToHome)
                    }
                    is Resource.Error -> {
                        // Handle error failed to log in
                        handleError(Exception("Failed to log in"))
                    }
                }
            }
        }
    }

    private fun showCredentialsError(error: CredentialsValidationError) {
        when (error) {
            CredentialsValidationError.EmailInvalid -> {
                // Handle error email invalid
            }
            CredentialsValidationError.PasswordInvalid -> {
                // Handle error password invalid
            }
            else -> {
                // Handle other errors
            }
        }
    }
}