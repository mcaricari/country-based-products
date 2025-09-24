package com.itrock.challenge.e_commerce.domain.usecases

import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import com.itrock.challenge.e_commerce.domain.model.Product
import javax.inject.Inject

/**
 * A use case responsible for retrieving a specific product by its unique identifier.
 * It utilizes a [SourceSelector] to determine the data source to fetch the product from.
 *
 * @param sourceSelector The [SourceSelector] used to obtain the appropriate [com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository].
 */
class GetProductByIdUseCase
@Inject constructor(private val sourceSelector: SourceSelector) {

    /**
     * Executes the use case to fetch a product by its ID.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return The [Product] matching the given [id].
     */
    suspend operator fun invoke(id: Int): Product = sourceSelector.getSource().getProduct(id)
}
