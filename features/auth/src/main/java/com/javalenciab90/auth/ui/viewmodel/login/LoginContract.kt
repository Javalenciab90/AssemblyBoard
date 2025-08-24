package com.javalenciab90.auth.ui.viewmodel.login

import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException

class LoginContract {

    data class State(
        val email: String = "test_01@gmail.com",
        val password: String = ""
    )

    sealed interface Effect {
        data object GoToRegister : Effect
        data object GoToResetPassword : Effect
        data object GoToHome : Effect
        data object LaunchGoogleSignIn : Effect
    }

    sealed interface Intent {
        data class UpdateEmail(val email: String) : Intent
        data class UpdatePassword(val password: String) : Intent
        data object RegisterAction : Intent
        data object SignInWithEmail : Intent
        data object SignInWithGoogle : Intent
        data object ForgotPasswordAction : Intent
        data class GoogleSignInSuccess(val credentialResponse: GetCredentialResponse) : Intent
        data class GoogleSignInFailure(val exception: GetCredentialException) : Intent
    }
}