package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

class GetProductByIdUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {
    suspend operator fun invoke(id: Int) = sourceSelector.getSource().getProduct(id)
}