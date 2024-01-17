package com.srhamburguer.extension

import com.srhamburguer.controller.request.PostCustomerRequest
import com.srhamburguer.controller.request.PutCustomerRequest
import com.srhamburguer.model.CustomerModel

fun PostCustomerRequest.toCustomerModel() : CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String) : CustomerModel{
    return CustomerModel(id = id, name = this.name, email = this.email)
}