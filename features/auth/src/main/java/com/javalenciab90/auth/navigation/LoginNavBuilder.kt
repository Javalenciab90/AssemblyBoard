package com.javalenciab90.auth.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.login.LoginContent
import com.javalenciab90.auth.ui.components.login.LoginScreen
import com.javalenciab90.auth.ui.viewmodel.login.LoginContract
import com.javalenciab90.auth.ui.viewmodel.login.LoginViewModel
import com.javalenciab90.base.effect.ObserveEffects
import com.javalenciab90.base.providers.AppProvider
import com.javalenciab90.deeplinks.routes.Deeplink
import com.javalenciab90.domain.util.generateSecureRandomNonce
import kotlinx.coroutines.launch

fun NavGraphBuilder.buildLoginScreen(
    navController: NavController
) {
    composable<AuthRoutes.Login> {

        val context = LocalContext.current
        val viewModel = hiltViewModel<LoginViewModel>()
        val coroutineScope = rememberCoroutineScope()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()

        ObserveEffects(flow = viewModel.sideEffect) { effect ->
            when (effect) {
                LoginContract.Effect.GoToRegister -> {
                    navController.navigateToRegister()
                }
                LoginContract.Effect.GoToResetPassword -> {
                    navController.navigateToReset()
                }
                LoginContract.Effect.GoToHome -> {
                    navigateDeeplinkToHome(context = context)
                }
                LoginContract.Effect.LaunchGoogleSignIn -> {
                    coroutineScope.launch {
                        try {
                            val credentialManager = CredentialManager.create(context)
                            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                                .setFilterByAuthorizedAccounts(false)
                                .setServerClientId(context.getString(R.string.default_web_client_id))
                                .setNonce(generateSecureRandomNonce())
                                .build()
                            val request = GetCredentialRequest.Builder().addCredentialOption(googleIdOption).build()
                            val response = credentialManager.getCredential(context, request)
                            viewModel.handleIntent(LoginContract.Intent.GoogleSignInSuccess(response))
                        } catch (e: GetCredentialException) {
                            viewModel.handleIntent(LoginContract.Intent.GoogleSignInFailure(e))
                        }
                    }
                }
            }
        }

        LoginScreen { paddingValues ->
            LoginContent(
                modifier = Modifier.padding(paddingValues),
                uiState = uiState.value,
                onHandleIntent = {
                    viewModel.handleIntent(it)
                }
            )
        }
    }
}

fun NavController.navigateToRegister() {
    navigate(AuthRoutes.Register)
}

fun NavController.navigateToReset() {
    navigate(AuthRoutes.Reset)
}

fun navigateDeeplinkToHome(context: Context) {
    (context.applicationContext as AppProvider)
        .deeplinkHandler
        .process(context, Deeplink.Home.route)
}
