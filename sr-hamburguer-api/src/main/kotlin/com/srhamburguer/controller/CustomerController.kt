package com.srhamburguer.controller

import com.srhamburguer.controller.request.PostCustomerRequest
import com.srhamburguer.controller.request.PutCustomerRequest
import com.srhamburguer.extension.toCustomerModel
import com.srhamburguer.model.CustomerModel
import com.srhamburguer.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
         return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody putCustomerRequest: PutCustomerRequest) {
        customerService.updateCustomer(id, putCustomerRequest.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String): Boolean {
        return customerService.deleteCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customerModel: PostCustomerRequest) {
        customerService.createCustomer(customerModel.toCustomerModel())
    }


}