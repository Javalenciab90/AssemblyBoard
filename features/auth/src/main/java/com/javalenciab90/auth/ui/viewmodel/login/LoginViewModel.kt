package com.javalenciab90.auth.ui.viewmodel.login

import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.javalenciab90.auth.domain.models.UserCredentialsModel
import com.javalenciab90.auth.domain.usecases.SignInWithEmailUseCase
import com.javalenciab90.auth.domain.usecases.SignInWithGoogleUseCase
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
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
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
            LoginContract.Intent.SignInWithEmail -> {
                loginValidation()
            }
            LoginContract.Intent.SignInWithGoogle -> {
                launchGoogleSignIn()
            }
            is LoginContract.Intent.GoogleSignInSuccess -> {
                signInWithGoogleSuccess(intent.credentialResponse)
            }
            is LoginContract.Intent.GoogleSignInFailure -> {
                // Handle error failed to log in
                signInWithGoogleFailure(intent.exception)
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
                signInWithEmail(credentials.email, credentials.password)
            }
            is ValidationResult.Failure -> {
                showCredentialsError(result.error)
            }
        }
    }

    private fun signInWithEmail(email: String, password: String) {
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

    private fun launchGoogleSignIn() {
        postSideEffect(LoginContract.Effect.LaunchGoogleSignIn)
    }

    private fun signInWithGoogleSuccess(credentialResponse: GetCredentialResponse) {
        launchInBackground {
            val credential = credentialResponse.credential
            if (credential is GoogleIdTokenCredential) {
                signInWithGoogleUseCase(credential.idToken).collect { resource ->
                    when (resource) {
                        is Resource.Success -> postSideEffect(LoginContract.Effect.GoToHome)
                        is Resource.Error -> { /* Handle error */ }
                    }
                }
            }
        }
    }

    private fun signInWithGoogleFailure(exception: GetCredentialException) {
        // Todo: Handle error failed to log in with google
    }
}