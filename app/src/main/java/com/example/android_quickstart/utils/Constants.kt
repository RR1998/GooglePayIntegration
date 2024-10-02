package com.example.android_quickstart.utils

import com.google.android.gms.wallet.WalletConstants
import org.json.JSONArray
import java.math.BigDecimal

/**
 * This file contains several constants you must edit before proceeding.
 * Please take a look at PaymentsUtil.java to see where the constants are used and to potentially
 * remove ones not relevant to your integration.
 *
 *
 * Required changes:
 *
 *  1.  Update SUPPORTED_NETWORKS and SUPPORTED_METHODS if required (consult your processor if
 * unsure)
 *  1.  Update CURRENCY_CODE to the currency you use.
 *  1.  Update SHIPPING_SUPPORTED_COUNTRIES to list the countries where you currently ship. If this
 * is not applicable to your app, remove the relevant bits from PaymentsUtil.java.
 *  1.  If you're integrating with your `PAYMENT_GATEWAY`, update
 * PAYMENT_GATEWAY_TOKENIZATION_NAME and PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS per the
 * instructions they provided. You don't need to update DIRECT_TOKENIZATION_PUBLIC_KEY.
 *  1.  If you're using `DIRECT` integration, please edit protocol version and public key as
 * per the instructions.
 */
object Constants {
    /**
     * Changing this to ENVIRONMENT_PRODUCTION will make the API return chargeable card information.
     * Please refer to the documentation to read about the required steps needed to enable
     * ENVIRONMENT_PRODUCTION.
     *
     * @value #PAYMENTS_ENVIRONMENT
     */
    const val PAYMENTS_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST

    /**
     * The allowed networks to be requested from the API. If the user has cards from networks not
     * specified here in their account, these will not be offered for them to choose in the popup.
     *
     * @value #SUPPORTED_NETWORKS
     */
    val SUPPORTED_NETWORKS = listOf(
        "AMEX",
        "DISCOVER",
        "JCB",
        "MASTERCARD",
        "VISA"
    )

    /**
     * The Google Pay API may return cards on file on Google.com (PAN_ONLY) and/or a device token on
     * an Android device authenticated with a 3-D Secure cryptogram (CRYPTOGRAM_3DS).
     *
     * @value #SUPPORTED_METHODS
     */
    val SUPPORTED_METHODS = listOf(
        "PAN_ONLY",
        "CRYPTOGRAM_3DS"
    )

    /**
     * Required by the API, but not visible to the user.
     *
     * @value #COUNTRY_CODE Your local country
     */
    const val COUNTRY_CODE = "US"

    /**
     * Required by the API, but not visible to the user.
     *
     * @value #CURRENCY_CODE Your local currency
     */
    const val CURRENCY_CODE = "USD"

    /**
     * Supported countries for shipping (use ISO 3166-1 alpha-2 country codes). Relevant only when
     * requesting a shipping address.
     *
     * @value #SHIPPING_SUPPORTED_COUNTRIES
     */
    val SHIPPING_SUPPORTED_COUNTRIES = listOf("US", "GB")

    /**
     * The name of your payment processor/gateway. Please refer to their documentation for more
     * information.
     *
     * @value #PAYMENT_GATEWAY_TOKENIZATION_NAME
     */
    private const val PAYMENT_GATEWAY_TOKENIZATION_NAME = "example"

    /**
     * Custom parameters required by the processor/gateway.
     * In many cases, your processor / gateway will only require a gatewayMerchantId.
     * Please refer to your processor's documentation for more information. The number of parameters
     * required and their names vary depending on the processor.
     *
     * @value #PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS
     */
    val PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS = mapOf(
        "gateway" to PAYMENT_GATEWAY_TOKENIZATION_NAME,
        "gatewayMerchantId" to "exampleGatewayMerchantId"
    )

    /**
     * Only used for `DIRECT` tokenization. Can be removed when using `PAYMENT_GATEWAY`
     * tokenization.
     *
     * @value #DIRECT_TOKENIZATION_PUBLIC_KEY
     */
    const val DIRECT_TOKENIZATION_PUBLIC_KEY = "REPLACE_ME"

    /**
     * Parameters required for `DIRECT` tokenization.
     * Only used for `DIRECT` tokenization. Can be removed when using `PAYMENT_GATEWAY`
     * tokenization.
     *
     * @value #DIRECT_TOKENIZATION_PARAMETERS
     */
    val DIRECT_TOKENIZATION_PARAMETERS = mapOf(
        "protocolVersion" to "ECv1",
        "publicKey" to DIRECT_TOKENIZATION_PUBLIC_KEY
    )

    const val TYPE = "type"
    const val CARD = "CARD"
    const val PARAMETERS = "parameters"
    const val PAYMENT_API_VERSION_TITLE = "apiVersion"
    const val PAYMENT_API_VERSION = 2
    const val PAYMENT_API_VERSION_MINOR_TITLE = "apiVersionMinor"
    const val PAYMENT_API_VERSION_MINOR = 0
    const val PAYMENT_GATEWAY = "PAYMENT_GATEWAY"
    const val PAYMENT_GATEWAY_KEY = "gateway"
    const val PAYMENT_GATEWAY_VALUE = "example"
    const val PAYMENT_GATEWAY_MERCHANT = "gatewayMerchantId"
    const val PAYMENT_GATEWAY_MERCHANT_VALUE = "exampleGatewayMerchantId"
    const val PAYMENT_ALLOWED_METHOD_KEY = "allowedAuthMethods"
    const val PAYMENT_ALLOWED_NETWORKS_KEY = "allowedCardNetworks"
    const val PAYMENT_BILLING_ADDRESS_KEY = "billingAddressRequired"
    const val TOKEN_SPECIFICATION = "tokenizationSpecification"
    const val PAYMENT_ALLOWED_METHODS_KEY = "allowedPaymentMethods"
    const val FORMAT_VALUE = "FULL"
    const val PAYMENT_BILLING_KEY = "format"
    const val PAYMENT_BILLING_ADDRESS_PARAMETERS_KEY = "billingAddressParameters"
    const val PAYMENT_TOTAL_PRICE = "totalPrice"
    const val PAYMENT_TOTAL_PRICE_STATUS =  "totalPriceStatus"
    const val PAYMENT_TOTAL_PRICE_STATUS_VALUE = "FINAL"
    const val PAYMENT_COUNTRY_CODE = "countryCode"
    val PAYMENT_COUNTRY_CODE_STATUS = Pair("US", "GB")
    const val PAYMENT_CURRENCY_CODE = "currencyCode"
    const val PAYMENT_CURRENCY_CODE_STATUS = "USD"
    const val PAYMENT_MERCHANT_NAME = "merchantName"
    const val PAYMENT_MERCHANT_NAME_VALUE = "Example Merchant"
    const val PAYMENT_TRANSACTION_INFO = "transactionInfo"
    const val PAYMENT_TOTAL_CENTS = 100
    const val TWO_VALUE = 2
    const val PAYMENT_MERCHANT_INFO = "merchantInfo"
    const val PAYMENT_SHIPPING_ADDRESS = "shippingAddressRequired"
    const val PAYMENT_SHIPPING_ADDRESS_PARAMETERS = "shippingAddressParameters"
    const val PAYMENT_PHONE_NUMBER_REQUIRED = "phoneNumberRequired"
    const val PAYMENT_ALLOWED_COUNTRY_CODES = "allowedCountryCodes"


    val PAYMENT_NETWORKS = JSONArray(
        listOf(
            "AMEX",
            "DISCOVER",
            "INTERAC",
            "JCB",
            "MASTERCARD",
            "VISA"
        )
    )

    val PAYMENT_ALLOWED_METHODS = JSONArray(
        listOf(
            "PAN_ONLY",
            "CRYPTOGRAM_3DS"
        )
    )
}