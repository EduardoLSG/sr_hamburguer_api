package com.srhamburguer.services

import com.srhamburguer.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customer = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customer.filter {
                it.name.contains(name, true)
            }
        }
        return customer
    }

    fun getCustomer(id: String): CustomerModel {
        return customer.first { it.id == id }
    }

    fun updateCustomer(id: String, putCustomerRequest: CustomerModel) {
        customer.first { it.id == id }.let {
            it.name = putCustomerRequest.name
            it.email = putCustomerRequest.email
        }
    }

    fun createCustomer(customerModel: CustomerModel) {

        val id = if (customer.isEmpty()) {
            1
        } else {
            (customer.last().id?.toInt() ?: 0) + 1
        }.toString()

        customerModel.id = id

        customer.add(CustomerModel(id, customerModel.name, customerModel.email))
    }

    fun deleteCustomer(id: String): Boolean {
        return customer.removeIf { it.id == id }
    }
}