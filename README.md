[ ![Download](https://api.bintray.com/packages/cryonyx/nova-lib/nova-lib/images/download.svg) ](https://bintray.com/cryonyx/nova-lib/nova-lib/_latestVersion)

# nova-lib
Kotlin wrapper for [Broxus Nova](https://broxus.com/products/nova)

## Download
### Groovy
* Include reference to the repository in your `repositories` section of your root `build.gradle`:
```groovy
repositories {
    mavenCentral()
}
```
* Add the code to your module's `build.gradle` file:
```groovy
dependencies {
    implementation "com.mazekine:broxus-nova-lib:VERSION"
}
```
### Gradle DSL
* Include reference to the repository in your `repositories` section of your root `build.gradle`:
```gradle  
repositories {
    mavenCentral()
}
```
* Add the code to your module's `build.gradle` file:
```gradle
dependencies {
    implementation("com.mazekine:broxus-nova-lib:VERSION")
}
```

## Usage
1. Configure the API:
```kotlin
val config = ApiConfig(
    apiPath,
    apiKey,
    apiSecret
)
```
2. Initialize the API:
```kotlin
NovaApiService.init(config)
```
3. Call required methods from `NovaApiService` object

## API coverage

### Withdraw
* [ ] `GET /withdraw/fees`
* [ ] `GET /withdraw/{transaction_id}`
* [ ] `POST /withdraw`
* [ ] `POST /withdraw/validate`
* [ ] `POST /withdraw`

### MSISDN
* [ ] `GET /msisdn/{id}`
* [ ] `POST /msisdn/rate`
* [ ] `POST /msisdn`
* [ ] `POST /msisdn/info`

### Users
* [x] `POST /users/balance`
* [x] `POST /users/balances`
* [ ] `POST /users/withdrawals`
* [x] `POST /users/exchanges`
* [ ] `POST /users/exchanges/trades`
* [x] `POST /users/transactions`
* [ ] `POST /users/transactions/groups`
* [ ] `POST /users/invoices`
* [ ] `POST /users/static_addresses`
* [ ] `POST /users/static_addresses/deposits`
* [ ] `POST /users/referral`
* [ ] `POST /users/referral/balance`
* [ ] `POST /users/referral/statistic`
* [ ] `POST /users/referral/transfer`
* [ ] `POST /users/fiat/payments`
* [ ] `POST /users/exchange_fiat/payments`
* [ ] `POST /users/msisdn/orders`

### KYC
* [ ] `GET /kyc/token/{externalUserId}`
* [ ] `POST /kyc/applicant`
* [ ] `POST /kyc/applicant_info`

### Exchange
* [ ] `GET /exchange_fiat/currency_pairs`
* [ ] `GET /exchange_fiat/{id}`
* [ ] `POST /exchange/rate`
* [ ] `POST /exchange`
* [x] `POST /exchange/order_book`
* [x] `POST /exchange/limit`
* [ ] `POST /exchange_fiat/rate`
* [ ] `POST /exchange_fiat`
* [x] `DELETE /exchange/limit/{transactionId}`

### Transfer
* [x] `POST /transfer`
* [ ] `POST /transfer/many`
* [ ] `POST /transfer_batch`
* [ ] `POST /transfer_batch/approve`
* [ ] `POST /transfer_batch/cancel`

### Meta
* [ ] `GET /meta/withdraw`
* [x] `GET /meta/deposit`
* [x] `GET /meta/currencies_pairs`
* [ ] `GET /meta/public_key`
* [ ] `GET /meta/static_address`

### Invoices
* [ ] `GET /invoices/{invoiceId}`
* [ ] `POST /invoices`
* [ ] `DELETE /invoices/{invoiceId}`

### Deposit
* [ ] `GET /deposit/fiat/rate/{id}`
* [ ] `GET /deposit/fiat/{id}`
* [ ] `POST /deposit/fiat/rate`
* [ ] `POST /deposit/fiat/payment`
* [ ] `POST /deposit/fiat`

### Addresses
* [ ] `GET /static_addresses/{staticAddressId}/deposits`
* [ ] `GET /static_addresses/deposits/{transactionId}`
* [ ] `POST /static_addresses`
* [ ] `POST /static_addresses/renew`
* [ ] `POST /address/info`

### Workspace
* [ ] `GET /workspaces`