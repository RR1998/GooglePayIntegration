package com.example.android_quickstart

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android_quickstart.checkout.CheckoutViewModel
import com.example.android_quickstart.checkout.PaymentUiState
import com.example.android_quickstart.checkout.ProductScreen
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import com.google.android.gms.wallet.WalletConstants
import com.google.android.gms.wallet.contract.TaskResultContracts.GetPaymentDataResult

class MainActivity : ComponentActivity() {

    private lateinit var paymentsClient: PaymentsClient
    private val viewModel: CheckoutViewModel by viewModels()

    private val paymentDataLauncher =
        registerForActivityResult(GetPaymentDataResult()) { taskResult ->
            when (taskResult.status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    taskResult.result?.let {
                        Log.i("Google Pay result:", it.toJson())
                        viewModel.setPaymentData(it)
                    }
                }
                //CommonStatusCodes.CANCELED -> The user canceled
                //AutoResolveHelper.RESULT_ERROR -> The API returned an error (it.status: Status)
                //CommonStatusCodes.INTERNAL_ERROR -> Handle other unexpected errors
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentsClient = createPaymentsClient(this)
        setContent {
            val payState: PaymentUiState by viewModel.paymentUiState.collectAsStateWithLifecycle()
            ProductScreen(
                title = stringResource(R.string.payment_title),
                description = stringResource(R.string.payment_subtitle),
                price = stringResource(R.string.payment_price),
                image = R.drawable.ts_10_11019a,
                payUiState = payState,
                onGooglePayButtonClick = this::requestPayment,
            )
        }
    }

    private fun createPaymentsClient(activity: Activity): PaymentsClient {
        val walletOptions = Wallet.WalletOptions.Builder()
            .setEnvironment(WalletConstants.ENVIRONMENT_TEST).build()
        return Wallet.getPaymentsClient(activity, walletOptions)
    }

    private fun requestPayment() {
        val task = viewModel.getLoadPaymentDataTask(priceCents = 1L)
        task.addOnCompleteListener(paymentDataLauncher::launch)
    }
}