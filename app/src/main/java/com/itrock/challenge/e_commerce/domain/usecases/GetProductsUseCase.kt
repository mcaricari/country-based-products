package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

class GetProductsUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {
    suspend operator fun invoke() = sourceSelector.getSource().getProducts()
}