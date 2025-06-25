package com.javalenciab90.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlin.coroutines.CoroutineContext

/**
 *  @OptIn(ExperimentalCoroutinesApi::class)
 * ✅ What it does: Enables usage of APIs marked as experimental in kotlinx.coroutines,
 * like TestScope, TestDispatcher, or Dispatchers.setMain.
 * 📌 Why it's needed: The testing utilities in kotlinx.coroutines.test
 * are still experimental, so you need to explicitly "opt in" to use them.
 */

/**
 * 🧪 class CoroutineTestRule(...) : TestWatcher()
 * ✅ What it does: Defines a JUnit test rule that wraps coroutine setup and cleanup logic.
 * 📌 Why it's needed: TestWatcher allows you to hook into the test lifecycle (starting()
 * and finished()) so you can replace Dispatchers.Main and clean up properly after tests.
 */

/**
 * 🧵 private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
 * ✅ What it does: Sets up a coroutine dispatcher that executes tasks immediately
 * and without delays.
 * 📌 Why it's helpful:
 * UnconfinedTestDispatcher makes testing simpler — no need to advance time manually.
 * You can also swap this with StandardTestDispatcher() for more control
 * (especially when testing delays or async chains).
 */

/**
 * 🧪 val testScope = TestScope(testDispatcher)
 * ✅ What it does: Creates a coroutine scope specifically for tests using the provided dispatcher.
 * 📌 Why it's useful: You can use this scope to launch and control coroutines in your test.
 * It integrates well with structured testing and time control.
 */

@ExperimentalCoroutinesApi
class CoroutineTestRule : TestWatcher() {

    private val job = SupervisorJob()
    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    val coroutineContextProvider = object : CoroutineContextProvider {
        override val mainContext: CoroutineContext
            get() = testCoroutineDispatcher
        override val backgroundContext: CoroutineContext
            get() = testCoroutineDispatcher
        override val immediateContext: CoroutineContext
            get() = testCoroutineDispatcher
    }

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    override fun finished(description: Description) {
        job.cancel()
        Dispatchers.resetMain()
        super.finished(description)
    }
}