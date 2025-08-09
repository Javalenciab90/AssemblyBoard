package com.javalenciab90.auth.ui.viewmodel.register

import com.javalenciab90.auth.domain.models.UserCredentialsModel
import com.javalenciab90.auth.domain.usecases.CreateUserWithEmailUseCase
import com.javalenciab90.auth.domain.usecases.validators.CredentialsValidationError
import com.javalenciab90.auth.domain.usecases.validators.ValidateRegisterCredentialsUseCase
import com.javalenciab90.auth.domain.usecases.validators.ValidationResult
import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateRegisterUseCase: ValidateRegisterCredentialsUseCase,
    private val createUserWithEmailUseCase: CreateUserWithEmailUseCase,
    context: CoroutineContextProvider
): MviViewModel<RegisterContract.State, RegisterContract.Effect, RegisterContract.Intent>(context) {

    override fun setInitialState(): RegisterContract.State = RegisterContract.State()

    override fun handleIntent(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.UpdateEmail -> {
                updateNow {
                    it.copy(email = intent.email)
                }
            }
            is RegisterContract.Intent.UpdatePassword -> {
                updateNow {
                    it.copy(password = intent.password)
                }
            }
            is RegisterContract.Intent.UpdateConfirmPassword -> {
                updateNow {
                    it.copy(confirmPassword = intent.confirmPassword)
                }
            }
            RegisterContract.Intent.RegisterAction -> {
                registerValidation()
            }
            RegisterContract.Intent.LoginAction -> {
                postSideEffect(RegisterContract.Effect.GoToLogin)
            }
        }
    }

    private fun registerValidation() {
        val credentials = UserCredentialsModel(
            email = currentUiState.email,
            password = currentUiState.password,
            confirmPassword = currentUiState.confirmPassword
        )
        when (val result = validateRegisterUseCase(credentials)) {
            ValidationResult.Success -> {
                createUserWithEmail(credentials.email, credentials.password)
            }
            is ValidationResult.Failure -> {
                showCredentialsError(result.error)
            }
        }
    }

    private fun createUserWithEmail(email: String, password: String) {
        launchInBackground {
            createUserWithEmailUseCase(email, password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        postSideEffect(RegisterContract.Effect.GoToLogin)
                    }
                    is Resource.Error -> {
                        // Handle error failed to create user
                        handleError(Exception("Failed to create user"))
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
            CredentialsValidationError.PasswordsDoNotMatch -> {
                // Handle error passwords do not match
            }
        }
    }
}