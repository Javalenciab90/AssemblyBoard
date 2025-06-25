package com.javalenciab90.auth.ui.viewmodel.splash

import app.cash.turbine.test
import com.javalenciab90.base.CoroutineTestRule
import com.javalenciab90.domain.Result
import com.javalenciab90.domain.usecases.IsLoggedInUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    @get: Rule
    var coroutineTestRule = CoroutineTestRule()

    private val isLoggedInUseCase = mockk<IsLoggedInUseCase>()

    private lateinit var viewModel: SplashViewModel

    @Before
    fun setUp() {
        viewModel = SplashViewModel(
            isLoggedInUseCase = isLoggedInUseCase,
            context = coroutineTestRule.coroutineContextProvider
        )
    }

    @Test
    fun `when user is logged in, should emit InitHomeScreen effect`() = runTest {
        // Given
        coEvery { isLoggedInUseCase.invoke() } returns flowOf(Result.Success(true))

        // when
        viewModel.handleIntent(SplashContract.Intent.CheckUserIsLoggedIn)

        // then
        viewModel.sideEffect.test {
            val result = awaitItem()
            assert(result is SplashContract.Effect.InitHomeScreen)
        }
    }

    @Test
    fun `when check user is Not logged in, should emit InitLoginScreen effect`() = runTest {
        // given
        coEvery { isLoggedInUseCase.invoke() } returns flowOf(Result.Success(false))

        // when
        viewModel.handleIntent(SplashContract.Intent.CheckUserIsLoggedIn)

        // then
        viewModel.sideEffect.test {
            val result = awaitItem()
            assert(result is SplashContract.Effect.InitLoginScreen)
        }
    }

}